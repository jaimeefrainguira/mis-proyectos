<!-- Header -->
<header id="header">
    <div class="inner">
        <a href="home.php" class="logo">Sistema <strong>CBVA</strong></a>
        <nav id="nav">
            <a href="home.php">Inicio</a>						
            <a href="logout.php">Cerrar Sesion</a>
            <a>Rol: <?php                        
                echo $_SESSION["tipo_usuario"];
                ?></a>
        </nav>
        <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
    </div>
</header>