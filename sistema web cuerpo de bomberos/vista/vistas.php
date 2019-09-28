
<?php

class vistas {
    //put your code here
    public function tabla($array_usuario)
    {     
        echo '<table border="1">';
        foreach ($array_usuario as $key => $value) {
            $usu=new Usuario ();
            $usu=$value;
            echo '<tr>'.'<td>'.$usu->getIdusuarios().'</td>';
            echo '<td>'.$usu->getUsuario().'</td>';
            echo '<td>'.$usu->getCedula().'</td>';
            echo '<td>'.$usu->getClave().'</td>';
            echo '<td>'.$usu->getFecha_creacion().'</td>';
            echo '<td>'.$usu->getApe_nombre().'</td>';
            echo '<td>'.$usu->getDireccion().'</td>';
            echo '<td>'.$usu->getPerfil().'</td>'.'</tr>';  
        }
        echo '</table>';
    }
    public function verContribuyente($contribuyente)
    {
        
     ?>

        <?php
        foreach ($contribuyente as $key => $value) {
            
            $usu=new Contribuyente();
            $usu=$value;
            $id=$usu->getIdcontribuyente();
            $numnot=0;
            require '../basedatos/conexion.php';
            
            $metodos=new metodos();
            $sql = "call numeroNotificacion('".$id."','".$metodos->getAnio()."')";
            $result= mysqli_query($mysqli, $sql);
            $ver;
            while ($ver= mysqli_fetch_row($result))
            {
                $numnot=$ver[0];
                $fecha_limite=$ver[2];
                $estado=$ver[3];                
                
                $mesLimite = substr($fecha_limite, 5, 2);
                $mesActual=$metodos->getMes();
//                if($mesLimite<$mesActual)
//                {
                    $numnot++;                    
//                }
                if($estado=='P')
                {
                    if ($numnot>3)
                    {
                        $this->forEspirada();
                    }
                    else {
                        $this->cargarForNoti($numnot,$usu);
                    }                
                }
                else
                {
                    $this->forPagado();
                }
            }
            if($result->num_rows==0)
            {
                $this->cargarForNoti(1,$usu);
            }
            
            
            
        }
        
    
    }
    public function forPagado() {
        echo "valores cancelados";
        
    }
    public function forEspirada() {
        echo 'Numero de notificaciones Exedida para este anio';
    }
    public function cargarForNoti($numnot,$usu)
        {
            
            
            ?>        


<!--formulario para crear notificaciones-->
        <div class="container d-flex justify-content-center" style="margin-top:60px;background-color:#ffffff;padding-bottom:30px;max-width:none;padding-top:15px;">
            <div class="row">
                <div class="col">
                    <h1>Notificación # <?php echo $numnot; ?></h1>
                </div>
            </div>
        </div>
        <div class="container" style="max-width:none;background-color:#ffffff;margin-bottom:50px;">
            <div class="row">
                <div class="col d-inline-flex justify-content-center">
                    <form style="width:870px;"id="forNotificacion">
                        <div class="form-row">
                            <div class="col">
                                <div class="form-row d-inline">                                    
                                    <div class="col">
                                        <input type="text" hidden="" value="<?php echo $numnot; ?>" name="numnoti">
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">C.I. / R.U.C.:</span><input class="form-control-plaintext" type="text" name="idcontr" value="<?php echo $usu->getIdcontribuyente();?>" readonly=""></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Rasón Social:</span><input class="form-control-plaintext" type="text" value="<?php echo $usu->getRazon_social();?>" readonly="" style="width:250px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Dirección:</span><input class="form-control-plaintext" type="text" name="direccion" value="<?php echo $usu->getDireccion();?>" readonly="" style="width:250px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Teléfono:</span><input class="form-control-plaintext" type="text" name="direccion" value="<?php echo $usu->getTelefono();?>" readonly="" style="width:90px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Correo:</span><input class="form-control-plaintext" type="text" value="<?php echo $usu->getEmail();?>" readonly="" style="width:250px;"></div>
                                    </div>
                                    <div class="col align-self-center"><button class="btn btn-primary" type="button" style="width:150px;" onclick="obtenDatos('<?php echo $usu->getIdcontribuyente(); ?>')" data-toggle="modal" data-target="#modal1">Actualizar</button></div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-row d-inline-flex">
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Tipo:</span><input class="form-control-plaintext" type="text" value="<?php echo $usu->getEspecial();?>" readonly="" style="width:150px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Patente:</span><input class="form-control-plaintext" type="text" value="<?php echo $usu->getPatente();?>" readonly="" style="width:90px;"></div>
                                    </div>
                                </div>
                                <div class="form-row d-inline-flex">
                                    <div class="col d-flex justify-content-center">
                                        <div class="form-group d-inline"><span style="font-weight:bold;font-size:19pt;">Valor:</span><input class="form-control-plaintext" type="text" value="<?php echo $usu->getValor()?>" readonly="" style="width:150px;font-size:20pt;"></div>
                                    </div>
                                    <div class="col d-flex justify-content-center">
                                        <div class="form-group d-inline"><span style="font-weight:bold;font-size:19pt;">Estado:</span><input class="form-control-plaintext" type="text" value="<?php echo $usu->getEstado();?>" readonly="" style="width:200px;font-size:20pt;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-md-flex d-lg-flex">
                            <div style="width:400px;margin-right:40px;">
                                <div class="form-group"><input class="form-control" type="text" name="direccion" placeholder="Dirección de establesimiento"></div>
                                <div class="form-group">
                                    <div class="form-check"><input class="form-check-input" name="extintor" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Extintor</label></div>
                                    <div class="form-check"><input class="form-check-input" name="instaele" type="checkbox" id="formCheck-2"><label class="form-check-label" for="formCheck-2">Instalaciones Elécticas</label></div>
                                    <div class="form-check"><input class="form-check-input" name="recipi" type="checkbox" id="formCheck-3"><label class="form-check-label" for="formCheck-3">Recipientes</label></div>
                                    <div class="form-check"><input class="form-check-input" name="mate" type="checkbox" id="formCheck-4"><label class="form-check-label" for="formCheck-4">Material Combustible</label></div>
                                </div>
                                <div class="form-group"><span>Otros</span><input class="form-control" name="otros" type="text"></div>
                                <div class="form-group"><span>Observaciones</span><textarea class="form-control" name="obserba"></textarea></div>
                            </div>
                            <div>
                                <div class="form-group">
                                    <div class="d-flex" style="margin-bottom:10px;">
                                        <div><span>Longitud</span><input class="form-control" name="latitud" type="text"></div>
                                        <div><span>Latitud</span><input class="form-control" name="longitud" type="text"></div>
                                    </div>
                                    <div>
                                        <div><div id="map"></div></div>
<!--                                        <iframe allowfullscreen="" frameborder="0" width="100%" height="300" src="https://www.google.com/maps/embed/v1/place?q=Paris%2C+France&amp;zoom=11" style="height:200px;"></iframe>-->
                                   
                                    
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center"><button class="btn btn-primary" id="btcrearNoti"type="button">Crear Notificación</button></div>
                    </form>
                </div>
            </div>
        </div>
          <script type="text/javascript">
    $(document).ready(function(){

        $('#btcrearNoti').click(function(){
            
            datos=$('#forNotificacion').serialize();
            
            $.ajax({
                data:  datos, //datos que se envian a traves de ajax
                url:   'controlador/controladorNotificacion.php?funcion=registrar', //archivo que recibe la peticion
                type:  'post', //método de envio
                beforeSend: function ()
                {
                    $("#formularioNotificacion").html("Procesando, espere por favor...");
                },
                success:  function (response) 
                { //una vez que el archivo recibe el request lo procesa y lo devuelve
                    $("#formularioNotificacion").html(response);
                }
                
            });
        });
    });    
</script>

 <script>
// Initialize and add the map
function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: new google.maps.LatLng(-33.863276, 151.207977),
          zoom: 12
        });
        var infoWindow = new google.maps.InfoWindow;

          // Change this depending on the name of your PHP or XML file
          downloadUrl('https://storage.googleapis.com/mapsdevsite/json/mapmarkers2.xml', function(data) {
            var xml = data.responseXML;
            var markers = xml.documentElement.getElementsByTagName('marker');
            Array.prototype.forEach.call(markers, function(markerElem) {
              var id = markerElem.getAttribute('id');
              var name = markerElem.getAttribute('name');
              var address = markerElem.getAttribute('address');
              var type = markerElem.getAttribute('type');
              var point = new google.maps.LatLng(
                  parseFloat(markerElem.getAttribute('lat')),
                  parseFloat(markerElem.getAttribute('lng')));

              var infowincontent = document.createElement('div');
              var strong = document.createElement('strong');
              strong.textContent = name
              infowincontent.appendChild(strong);
              infowincontent.appendChild(document.createElement('br'));

              var text = document.createElement('text');
              text.textContent = address
              infowincontent.appendChild(text);
              var icon = customLabel[type] || {};
              var marker = new google.maps.Marker({
                map: map,
                position: point,
                label: icon.label
              });
              marker.addListener('click', function() {
                infoWindow.setContent(infowincontent);
                infoWindow.open(map, marker);
              });
            });
          });
        }
        function downloadUrl(url, callback) {
        var request = window.ActiveXObject ?
            new ActiveXObject('Microsoft.XMLHTTP') :
            new XMLHttpRequest;

        request.onreadystatechange = function() {
          if (request.readyState == 4) {
            request.onreadystatechange = doNothing;
            callback(request, request.status);
          }
        };

        request.open('GET', url, true);
        request.send(null);
      }

      function doNothing() {}
    </script>


    <!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAG0b50FsrNrIcrhc31i_qbGfKU4Jzi1cY&callback=initMap">
    </script>
         <?php
        }
}
