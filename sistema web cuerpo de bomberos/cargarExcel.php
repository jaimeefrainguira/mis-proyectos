<?php
extract($_POST);
if (isset($_POST['action'])) {
    $action = $_POST['action'];
}

if (isset($action) == "upload") {
    try {
        
        
        
        
    if($_FILES['excel']['name']==null)
    {
        throw new Exception("se debe cargar un archivo de excel");
        
    }
    if($_FILES['excel']['type']!='application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')
    {
        throw new Exception('Archivo no es de tipo excel');
    }

//cargamos el fichero
    $archivo = $_FILES['excel']['name'];
    $tipo = $_FILES['excel']['type'];
    $destino = "cop_" . $archivo; //Le agregamos un prefijo para identificarlo el archivo cargado
    if (copy($_FILES['excel']['tmp_name'], $destino))
        echo "Archivo Cargado Con Éxito";
    else
        echo "Error Al Cargar el Archivo";

    if (file_exists($destino)) {
        require_once './Classes/PHPExcel.php';;;
        require_once './metodos.php';

//                        $archivo = "cop_BASE_PRUEBa.xlsx";
        $inputFileType = PHPExcel_IOFactory::identify($destino);
        $objReader = PHPExcel_IOFactory::createReader($inputFileType);
        $objPHPExcel = $objReader->load($destino);
        $datos = $objPHPExcel->getSheet(0); 
        $totalfilas = $datos->getHighestRow(); 
        $totalcolumnas = $datos->getHighestColumn();
        require 'borrarLuego/clases/Contribuyente.php';
        require 'borrarLuego/controlador/controladorContribuyent.php';
        
        for ($row = 2; $row <= $totalfilas; $row++)
        { 
            $metodos=new metodos();
            
            $idcontribuyente=$datos->getCell("A".$row)->getValue();
         $tipo_documento=$metodos->getTipoDocumento($datos->getCell("A".$row)->getValue());        
         $razon_social=$datos->getCell("B".$row)->getValue();        
         $direccion=$datos->getCell("D".$row)->getValue();
         $telefono=$datos->getCell("E".$row)->getValue();
         $email=$datos->getCell("F".$row)->getValue();
         $fecha_ingreso=$metodos->getFechaHora();
         $especial=$metodos->getEspecial();
         $patente=$datos->getCell("C".$row)->getValue();
         $fecha_importacion=$metodos->getFechaHora();
        $val=$datos->getCell("C".$row)->getValue();        
        $metodos->_metodos($val);
        $valor=$metodos->extraeValor();
         $valor.' - ';
         $estado=$metodos->getEstado();
         $idusuarios=$metodos->getIdUsuario();
            
                                
                $contribuyente=new Contribuyente();
                     $contribuyente->__Contribuyente(
                        $idcontribuyente, 
                        $tipo_documento, 
                        $razon_social, 
                        $direccion, 
                        $telefono, 
                        $email, 
                        $fecha_ingreso, 
                        $especial, 
                        $patente, 
                        $fecha_importacion, 
                        $valor, 
                        $estado, 
                        $idusuarios);                   
                $controlador=new controladorContribuyent();                
                if ($controlador->registraContribuyente($contribuyente)) 
                {     
                    
                }
                else 
                {
                    
                }
            
        }
        /////////////////////////////////////////////////////////////////////////	
        // Borramos el archivo que esta en el servidor con el prefijo cop_
        unlink($destino);
    }
    //si por algun motivo no cargo el archivo  
    else {
        throw new Exception('No se cargo correctamente el archivo');
    }
    
    if (isset($action)) {
    $filas = $objPHPExcel->setActiveSheetIndex(0)->getHighestRow();
}
if (isset($filas)) {
    $columnas = $objPHPExcel->setActiveSheetIndex(0)->getHighestColumn();
}
if (isset($filas)) {
    $filas = $objPHPExcel->setActiveSheetIndex(0)->getHighestRow();
}

//echo 'getHighestColumn() =  [' . $columnas . ']<br/>';
//echo 'getHighestRow() =  [' . $filas . ']<br/>';
if (isset($action) == "upload") {
    echo '<table border="1" class="table">';
    echo '<thead>';
    echo '<tr>';
    echo '<th>Documento</th>';
    echo '<th>RAZON_SOCIAL</th>';
    echo '<th>PATENTE</th>';
    echo '<th>DIRECCION</th>';
    echo '<th>TELEFONO</th>';

    echo '</tr> ';
    echo '</thead> ';
    echo '<tbody> ';

    $count = 0;
    foreach ($objPHPExcel->setActiveSheetIndex(0)->getRowIterator() as $row) {
        $count++;
        $cellIterator = $row->getCellIterator();
        $cellIterator->setIterateOnlyExistingCells(false);
        echo '<tr>';
        foreach ($cellIterator as $cell) {
            if (!is_null($cell)) {
                $value = $cell->getCalculatedValue();
                echo '<td>';
                echo $value . ' ';
                echo '</td>';
            }
        }
        echo '</tr>';
    }
    echo '</tbody>';
    echo '</table>';
}
echo '</div>';
    }
    catch (Exception $exc) {
        echo $exc->getMessage();
    }
    
}
?>
