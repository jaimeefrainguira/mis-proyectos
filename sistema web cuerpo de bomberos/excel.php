<!DOCTYPE HTML>
<?php
//include("header.php");
?>
<html>
    <head>
        <title>CBVA</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <link rel="stylesheet" href="css1/styles.css" >
        <script type="text/javascript" src="js1/filestyle.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="css1/styles.css" >

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js1/filestyle.min.js"></script>
        <script src="js/funciones.js"></script>
    </head>
    <body>

        <!-- Header -->
        <header id="header">
            <div class="inner">
                <a href="home.php" class="logo">Sistema <strong>CBVA</strong></a>
                <nav id="nav">
                    <a href="home.php">Inicio</a>						
                    <a href="logout.php">Cerrar Sesion</a>
                    <a>Rol: <?php
                        session_start();
                        print_r($_SESSION['tipo_usuario']);
                        ?></a>
                </nav>
                <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
            </div>
        </header>

        <!-- Banner -->
        <section id="banner">
            <div class="inner">

                <!-- FORMULARIO PARA ESTE EJERCICIO -->

                <!--<h2>Cargar e importar archivo excel a MySQL</h2>-->
                <form name="importa" method="post" action="" enctype="multipart/form-data" >
                    <div class="col-xs-4">
                        <div class="form-group">
                            <input type="file" class="filestyle" data-buttonText="Seleccione archivo" name="excel" id="archivo">
                        </div>
                    </div>
                    <div class="col-xs-2">
                        <input class="btn btn-default btn-file" type='submit' name='enviar'  value="Importar"  />
                    </div>
                    <input type="hidden" value="upload" name="action" />
                    <input type="hidden" value="usuarios" name="mod">
                    <input type="hidden" value="masiva" name="acc">
                </form>
                <div id="resultados"></div>

                <!-- PROCESO DE CARGA Y PROCESAMIENTO DEL EXCEL-->
                <?php include './cargarExcel.php'; ?>
                

            </div>
        </div>
    </section>



    <!-- Scripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/skel.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>

</body>
</html>