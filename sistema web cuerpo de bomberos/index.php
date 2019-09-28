<!DOCTYPE html>
<html>

<head>
    <title>dise</title>
    <?php require 'dependencias.php';?>
</head>

<body>
     
    <div class="login-dark" style="background-image:url(&quot;assets/img/bom.jpg&quot;);background-position:center;background-size:cover;background-repeat:no-repeat;height:100vh;">
        <form method="post" id="frmlogin" style="background-color:rgb(40,38,34);max-width:350px;">
            <h2 class="sr-only">Login Form</h2>
            <div data-bs-hover-animate="jello" class="illustration"><i class="icon ion-fireball" style="color:rgb(211,136,48);"></i></div>
            <div class="form-group"><input class="form-control" type="text" id ="usuario" name="usuario" placeholder="Usuario"></div>
            <div class="form-group"><input class="form-control" type="password" id='password' name="password" placeholder="Password"></div>
            <div class="form-group"><input type="button" class="btn btn-primary btn-block" id="iniciar" value="Ingresar" class="button alt" style="background-color:rgb(211,136,48);"></div>
            <a href="#" class="forgot">Ovidó su usuario o contraseña?</a>
            <div id="mensaje"></div>            
<!--            <div class="alert alert-success" role="alert"><span><strong>Alert</strong> text.</span></div>-->
        </form>
    </div>
    
		
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    
<script type="text/javascript">
    $(document).ready(function(){

        $('#iniciar').click(function(){

            datos=$('#frmlogin').serialize();
            $.ajax({
                data:  datos, //datos que se envian a traves de ajax
                url:   'controlador/controladorUsuario.php?funcion=ingresar', //archivo que recibe la peticion
                type:  'post', //método de envio
                beforeSend: function ()
                {
                    $("#mensaje").html("Procesando, espere por favor...");
                },
                success:  function (response) 
                { //una vez que el archivo recibe el request lo procesa y lo devuelve
                    $("#mensaje").html(response);                    
                }
                
            });
        });
    });    
</script>
</body>

</html>



