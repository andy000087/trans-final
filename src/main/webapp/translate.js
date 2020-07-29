$(document).ready(function(){
    $('select').mousedown(function(e){
        e.preventDefault();

        var select = this;
        
        var scroll = select.scrollTop;

        e.target.selected = !e.target.selected;

        setTimeout(function(){select.scrollTop = scroll;}, 0);

        $(select).focus();
        
        
    });
    $('select').mousemove(function(e){
        e.preventDefault();
        
    });
});

function getMultipleSelectedValue()
{
  document.getElementById("allLang").value="";	
  var selectedVal = "";
  var x=document.getElementById("language");
  for (var i = 0; i < x.options.length; i++) {
	 if(x.options[i].selected ==true){
          if(selectedVal !=""){selectedVal = selectedVal+","+x.options[i].value;}else{selectedVal=x.options[i].value;}
      }
  }
  document.getElementById("allLang").value = selectedVal;
}