<!DOCTYPE HTML>
<?php 

require './requiere/requierehome.php';
?>
<html>
    <head>
        <title>CBVA</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body>

        <?php menu(); ?>

        <!-- Banner -->
        <section id="banner">
            <div class="inner">
                <header>
                    <h1>Bienvenido <?php
                        echo $_SESSION['usuario'];
                        ?>
                    </h1>
                </header>

                <div class="flex ">
                    <?php
                    cotenido();
                    ?>
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