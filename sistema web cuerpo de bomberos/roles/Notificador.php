<!DOCTYPE html>
<html>
<?php 


$usuario=$_SESSION['usuario'];
$tipo_usuario=$_SESSION['tipo_usuario'];
?>
<head>    
    <title>dise</title>
    <?php require './dependencias.php';?>
    <style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
    </style>
</head>

<body style="background-color:rgb(255,255,255);">
    <div style="height:100vh;">
        <div class="header-blue" style="height:100vh;">
            <nav class="navbar navbar-dark navbar-expand-md sticky-top navigation-clean-search">
                <div class="container"><a class="navbar-brand" href="#">Sistema&nbsp;<strong>CBVA</strong><br></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div
                        class="collapse navbar-collapse justify-content-end" id="navcol-1"><span class="navbar-text"> <a href="#" class="login"><?php echo $usuario.' | '.$tipo_usuario; ?></a></span><a class="btn btn-light action-button" role="button" href="./logout.php">Cerrar sesión</a></div>
        </div>
        </nav>
        <div id="mensaje">
        <div class="container hero">
            <div class="row">
                <div class="col-12 col-lg-6 col-xl-5 offset-xl-1">
                    <h1>Bienvenido <?php echo $usuario;?>.</h1>
                    <p>Crea e imprime notificaciones de contribuyentes, para la aprobación de permisos de funcionamiento de establecimientos comerciales.</p>
                    <input class="btn btn-light btn-lg action-button" type="button" id="iniciar" value="Iniciar">
                    <!--<button class="btn btn-light btn-lg action-button" type="button">Iniciar</button>-->
                </div>
                <div class="col-md-5 col-lg-5 offset-lg-1 offset-xl-0 d-none d-lg-block phone-holder">
                    <div class="iphone-mockup"><img src="assets/img/questionnaire-2834264_960_720.png" class="device" style="width:400px;"></div>
                </div>
            </div>
        </div>
        </div>
    </div> 
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){

        $('#iniciar').click(function(){

            
            $.ajax({
                data:  '', //datos que se envian a traves de ajax
                url:   'roles/consultaContribuyente.php', //archivo que recibe la peticion
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