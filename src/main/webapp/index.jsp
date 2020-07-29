<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<link rel="stylesheet" href="translate.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <title>Translate Language</title>
  
</head>
<body>
<script src="translate.js"></script>

<form method="post" action="service" style="margin-bottom: 8px;">  
<div><svg aria-labelledby="title-wbc" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="69px" height="28px" viewBox="0 0 69 28" enable-background="new 0 0 69 28" xml:space="preserve"> <title id="title-wbc" lang="en">Westpac logo</title> <path d="M24.4 25L17.6 4.1C16.7 0.9 15 0 12.6 0H0c1 0.4 1.6 2.9 1.6 2.9l6.1 21c0.7 2.6 2.9 4 5.4 4h13.3C25.4 27.8 24.4 25 24.4 25" fill="#D5002B"></path> <path d="M44.6 25l6.8-20.9C52.3 0.9 54 0 56.4 0H69c-1 0.4-1.6 2.9-1.6 2.9l-6.1 21c-0.7 2.6-2.9 4-5.4 4H42.6C43.6 27.8 44.6 25 44.6 25" fill="#D5002B"></path> <rect x="27" width="15" height="28" fill="#D5002B"></rect></svg>
	<h3>Language Translator</h3>
	<div style="padding-top: 0px;padding-bottom: 10px;">
Please enter content to translate:<textarea id="say-hello-text-input" name="sourcecontent" rows="6" cols="157"></textarea>
  <input type="hidden" name="allLang" id="allLang" value=""/>
  </div>
  <div style="padding-top: 0px;padding-bottom: 10px;">
  Select languages:
  <select id="language" name="language" multiple onclick="getMultipleSelectedValue()" style="padding-top: 1px;padding-bottom: 15px;margin-top: 0px;">
      <option value="ar">Arabic</option>
      <option value="zh-Hans">Chinese</option>
      <option value="hi">Hindi</option>
      <option value="it">Italian</option>
      <option value="vi">Vietnamese</option>
      
    </select>
    </div>
    
    
  <input class="button" type="submit" id="say-hello-button" value="Translate" /></div>
</form>

<form>
    	<div>Download translated content:</div>
        <table id="customers">
		  <tr>
		    <th>Translated to</th>
		    <th>Downloads</th>
		  </tr>
		  <%
		  String EnglishtoArabic = (String) request.getAttribute("EnglishtoArabic");
		  if(EnglishtoArabic != null){
		  %>
		  <tr>
		    <td>Arabic</td>
		    <td><a href='EnglishtoArabic.docx' download>EnglishtoArabic.docx</a></td>
		  </tr>
		  <% }%>
		  
		  <%
		  String EnglishtoChinese = (String) request.getAttribute("EnglishtoChinese");
		  if(EnglishtoChinese != null){
		  %>
		  <tr>
		    <td>Chinese</td>
		    <td><a href='EnglishtoChinese.docx' download>EnglishtoChinese.docx</a></td>
		  </tr>
		  <% }%>
		  
		  
		  <%
		  String EnglishtoHindi = (String) request.getAttribute("EnglishtoHindi");
		  if(EnglishtoHindi != null){
		  %>
		  <tr>
		    <td>Hindi</td>
		    <td><a href='EnglishtoHindi.docx' download>EnglishtoHindi.docx</a></td>
		  </tr>
		  <% }%>
		  
		  <%
		  String EnglishtoItalian = (String) request.getAttribute("EnglishtoItalian");
		  if(EnglishtoItalian != null){
		  %>
		  <tr>
		    <td>Italian</td>
		    <td><a href='EnglishtoItalian.docx' download>EnglishtoItalian.docx</a></td>
		  </tr>
		  <% }%>
		  
		  <%
		  String EnglishtoVietnamese = (String) request.getAttribute("EnglishtoVietnamese");
		  if(EnglishtoVietnamese != null){
		  %>
		  <tr>
		    <td>Vietnamese</td>
		    <td><a href='EnglishtoVietnamese.docx' download>EnglishtoVietnamese.docx</a></td>
		  </tr>
		  <% }%>
		
		  
		  
		</table>
</form>
  </body>
</html>