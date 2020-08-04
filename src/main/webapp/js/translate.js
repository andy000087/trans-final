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

$(document).ready(function () {
    $('.selectpicker').selectpicker();
})


