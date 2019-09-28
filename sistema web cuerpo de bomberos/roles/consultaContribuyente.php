
        <div class="container" style="margin-top:50px;">
            <div class="intro">
                <h2 class="text-center">Notificación</h2>
                <p class="text-center">Crea notificaciones para la aprobación de permiso de funcionamiento de Cuerpo de Bomberos.</p>
            </div>
            <form class="form-inline justify-content-center" id="forConsultaContri">
                <div class="form-group"><input class="form-control" type="text" id="idcontribuyente" name="idcontribuyente" placeholder="Cedula o RUC"></div>
                <div class="form-group"><button class="btn btn-dark" type="button" id="consultaContri" style="background-color:rgb(39,37,33);color:rgb(211,136,48);">Consultar</button></div>
            </form>            
        </div>
<div id="formularioNotificacion">
    
</div>
<!--=======================modal====================-->
<div class="modal fade" role="dialog" tabindex="-1" id="modal1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Actualizar Contribuyente</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body">
                        <form id="frmactualiza">
            <input type="text" hidden="" name="idgetcontri" id="idgetcontri">
            <label>Razon_social</label>
            <input type="text" class="form-control form-control-sm" name="Razon_social" id="Razon_social">
            <label>direccion</label>
            <input type="text" class="form-control form-control-sm" name="direccion" id="direccion">
            <label>telefono</label>
            <input type="text" class="form-control form-control-sm" name="telefono" id="telefono">
            <label>email</label>
            <input type="text" class="form-control form-control-sm" name="email" id="email">
            
          </form>
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Close</button><button class="btn btn-primary" type="button" id="btnactualizar">Guardar</button></div>
                </div>
            </div>
        </div>

<script type="text/javascript">
    $(document).ready(function(){

        $('#consultaContri').click(function(){
            
            datos=$('#forConsultaContri').serialize();
            
            $.ajax({
                data:  datos, //datos que se envian a traves de ajax
                url:   'controlador/controladorContribuyente.php?funcion=cargarRegistro', //archivo que recibe la peticion
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

<script type="text/javascript">

  function obtenDatos(idgetcontri){
    $.ajax({
      type:"POST",
      data:"idgetcontri=" + idgetcontri,
      url:"controlador/controladorContribuyente.php?funcion=extraerRegistro",
      success:function(r){
        datos=jQuery.parseJSON(r);

        $('#idgetcontri').val(datos['idgetcontri']);
        $('#Razon_social').val(datos['Razon_social']);
        $('#direccion').val(datos['direccion']);
        $('#telefono').val(datos['telefono']);
        $('#email').val(datos['email']);        
      }
    });
  }
</script>

<script type="text/javascript">
  $(document).ready(function(){
    $('#btnactualizar').click(function(){

      datos=$('#frmactualiza').serialize();
        $.ajax({
          type:"POST",
          data:datos,
          url:"controlador/controladorContribuyente.php?funcion=actualizar",
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

<!--        <div class="container d-flex justify-content-center" style="margin-top:60px;background-color:#ffffff;padding-bottom:30px;max-width:none;padding-top:15px;">
            <div class="row">
                <div class="col">
                    <h1>Notificación # 1</h1>
                </div>
            </div>
        </div>
        <div class="container" style="max-width:none;background-color:#ffffff;margin-bottom:50px;">
            <div class="row">
                <div class="col d-inline-flex justify-content-center">
                    <form style="width:870px;">
                        <div class="form-row">
                            <div class="col">
                                <div class="form-row d-inline">
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">C.I. / R.U.C.:</span><input class="form-control-plaintext" type="text" value="0104516257" readonly=""></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Rasón Social:</span><input class="form-control-plaintext" type="text" value="Jaime Efrain Guiracocha Chocho" readonly="" style="width:250px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Teléfono:</span><input class="form-control-plaintext" type="text" value="0994778739" readonly="" style="width:90px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Correo:</span><input class="form-control-plaintext" type="text" value="jaimeefrainguira@gmail.com" readonly="" style="width:250px;"></div>
                                    </div>
                                    <div class="col align-self-center"><button class="btn btn-primary" type="button" style="width:150px;">Actualizar</button></div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-row d-inline-flex">
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Tipo:</span><input class="form-control-plaintext" type="text" value="Especial" readonly="" style="width:150px;"></div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group d-inline"><span style="font-weight:bold;">Patente:</span><input class="form-control-plaintext" type="text" value="$3" readonly="" style="width:90px;"></div>
                                    </div>
                                </div>
                                <div class="form-row d-inline-flex">
                                    <div class="col d-flex justify-content-center">
                                        <div class="form-group d-inline"><span style="font-weight:bold;font-size:19pt;">Valor:</span><input class="form-control-plaintext" type="text" value="$20" readonly="" style="width:150px;font-size:20pt;"></div>
                                    </div>
                                    <div class="col d-flex justify-content-center">
                                        <div class="form-group d-inline"><span style="font-weight:bold;font-size:19pt;">Estado:</span><input class="form-control-plaintext" type="text" value="Pendiente" readonly="" style="width:200px;font-size:20pt;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-md-flex d-lg-flex">
                            <div style="width:400px;margin-right:40px;">
                                <div class="form-group"><input class="form-control" type="text" name="direccion" placeholder="Dirección de establesimiento"></div>
                                <div class="form-group">
                                    <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Extintor</label></div>
                                    <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Instalaciones Elécticas</label></div>
                                    <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Recipientes</label></div>
                                    <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Material Combustible</label></div>
                                </div>
                                <div class="form-group"><span>Observaciones</span><textarea class="form-control"></textarea></div>
                            </div>
                            <div>
                                <div class="form-group">
                                    <div class="d-flex" style="margin-bottom:10px;">
                                        <div><span>Longitud</span><input class="form-control" type="text"></div>
                                        <div><span>Latitud</span><input class="form-control" type="text"></div>
                                    </div><iframe allowfullscreen="" frameborder="0" width="100%" height="300" src="https://www.google.com/maps/embed/v1/place?q=Paris%2C+France&amp;zoom=11" style="height:200px;"></iframe></div>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center"><button class="btn btn-primary" type="button">Crear Notificación</button></div>
                    </form>
                </div>
            </div>
        </div>-->
