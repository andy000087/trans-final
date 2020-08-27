package org.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import java.io.FileWriter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import com.squareup.okhttp.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;  // Import this class to handle errors



//@WebServlet(name = "TranslateServlet", urlPatterns = {"/service"}, loadOnStartup = 1) 
@WebServlet("/service") 
public class TranslateServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String subscriptionKey = "e14b9c1d098f402bb6518cd2f2b3a152";
	    String url = "https://api.cognitive.microsofttranslator.com//translate?api-version=3.0&to=";

	    OkHttpClient client = new OkHttpClient();

	    
	        MediaType mediaType = MediaType.parse("application/json");
	        String relativePath = getServletContext().getRealPath("");
			System.out.println("relativePath = " + relativePath);
			
			String sourcecontent = request.getParameter("sourcecontent");
			String allLang = request.getParameter("allLang");
			String language = request.getParameter("language");
			System.out.println("allLang = " + allLang);
			System.out.println("language = " + language);
			
			if(allLang.isEmpty()) {
				allLang = "hi,zh-Hans,ar,it,vi,el";
			}
			url = url+allLang;
			System.out.println("url = " + url);
			
			RequestBody body = RequestBody.create(mediaType,"[{\n\t\"Text\": \""+sourcecontent+"\"}]");
			Request requestAPI = new Request.Builder()
	                .url(url).post(body)
	                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
					.addHeader("Ocp-Apim-Subscription-Region", "australiaeast")
	                .addHeader("Content-type", "application/json").build();
			System.out.println(" body = "+body);	
			System.out.println(" request = "+requestAPI);	
			System.out.println(" subscriptionKey = "+subscriptionKey);	
			
	        Response responseAPI = client.newCall(requestAPI).execute(); 
	        System.out.println(" responseAPI = "+responseAPI);	
				
			StringBuffer translations= new StringBuffer();
			try {
				JSONArray jArray = new JSONArray(responseAPI.body().string()); 
				String resContent = "";
				String docName = "";
				String docTrans = "";
				String arContent = "";
				String itContent = "";
				String viContent = "";
				for (int i = 0; i < jArray.length(); i++) {
	            JSONObject c = jArray.getJSONObject(i);
				JSONArray translationsList = (JSONArray) c.get("translations");
				
				for (int j = 0; j < translationsList.length(); j++) {
					JSONObject d = translationsList.getJSONObject(j);
					String languagetype = d.get("to").toString();
					System.out.println(" languagetype = "+languagetype);
					resContent = d.get("text").toString();
					
					
					if(languagetype.equals("hi")){
						docName = "EnglishtoHindi.docx";
						docTrans = "EnglishtoHindi";
					}else if(languagetype.equals("zh-Hans")){
						docName = "EnglishtoChinese.docx";
						docTrans = "EnglishtoChinese";
					}else if(languagetype.equals("ar")){
						docName = "EnglishtoArabic.docx";
						docTrans = "EnglishtoArabic";
					}else if(languagetype.equals("it")){
						docName = "EnglishtoItalian.docx";
						docTrans = "EnglishtoItalian";
					}else if(languagetype.equals("vi")){
						docName = "EnglishtoVietnamese.docx";
						docTrans = "EnglishtoVietnamese";
					}else if(languagetype.equals("el")){
						docName = "EnglishtoGreek.docx";
						docTrans = "EnglishtoGreek";
					} 
					System.out.println(" relativePath===docName = "+relativePath+docName);	
					XWPFDocument document = new XWPFDocument();
					FileOutputStream out = new FileOutputStream(new File(relativePath+docName));
					XWPFParagraph paragraph1 = document.createParagraph();
					XWPFParagraph paragraph2 = document.createParagraph();
					XWPFParagraph paragraph3 = document.createParagraph();
					XWPFRun run1 = paragraph1.createRun();
					run1.setText(sourcecontent);
					XWPFRun run2 = paragraph2.createRun();
					run2.setText("To:"+languagetype);
					XWPFRun run3 = paragraph3.createRun();
					run3.setText(resContent);
					document.write(out);
					out.close();
					
					request.setAttribute(docTrans, docTrans+".docx");
					
				}
				}
				

				
				
			} catch(Exception e) {
				  e.printStackTrace();
			}
			
			request.setAttribute("sourcecontent", sourcecontent);	
			request.setAttribute("allLang", allLang);	
		/*
		 * request.setAttribute("EnglishtoHindi", "EnglishtoHindi.docx");
		 * request.setAttribute("EnglishtoChinese", "EnglishtoChinese.docx");
		 * request.setAttribute("EnglishtoArabic", "EnglishtoArabic.docx");
		 * request.setAttribute("EnglishtoItalian", "EnglishtoItalian.docx");
		 * request.setAttribute("EnglishtoVietnamese", "EnglishtoVietnamese.docx");
		 */
			request.getRequestDispatcher("index.jsp").forward(request, response); 
	        //return responseAPI.body().string(); 
	
}
}
