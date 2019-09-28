/*!
  * Bootstrap v4.1.3 (https://getbootstrap.com/)
  * Copyright 2011-2018 The Bootstrap Authors (https://github.com/twbs/bootstrap/graphs/contributors)
  * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
  */
 $('.btn-expand-collapse').click(function(e) 
 {
				$('.navbar-primary').toggleClass('collapsed');
});

$('.btn-expand-collapse2').click(function(e) 
{
				$('.navbar-primary').toggleClass('collapsed2');
});

$("#mi-boton").click(function()
{
  $(this).toggleClass("collapsed3");
});
$('.vermas1').click(function(e) 
 {
     var a = document.getElementById("vermas1").innerHTML;
     if (a==="Ver mas...") {
        document.getElementById("vermas1").innerHTML = "Ocultar";
    }
    else{
        document.getElementById("vermas1").innerHTML = "Ver mas...";
    }

     
});
$('.vermas2').click(function(e) 
 {
     var a = document.getElementById("vermas2").innerHTML;
     if (a==="Ver mas...") {
        document.getElementById("vermas2").innerHTML = "Ocultar";
    }
    else{
        document.getElementById("vermas2").innerHTML = "Ver mas...";
    }

     
});

$('.vermas3').click(function(e) 
 {
     var a = document.getElementById("vermas3").innerHTML;
     if (a==="Ver mas...") {
        document.getElementById("vermas3").innerHTML = "Ocultar";
    }
    else{
        document.getElementById("vermas3").innerHTML = "Ver mas...";
    }

     
});


$('#menu-toggle').click(function(e) 
 {
    
    $("#wrapper").toggleClass("toggled");
    $("#mi-boton").toggleClass("toggled");

     
});

    

$(function()
        {
            $('[data-toggle="tooltip"]').tooltip()
        });




