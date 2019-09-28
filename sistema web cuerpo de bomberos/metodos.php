<?php

class metodos {
    
    var $patente;
    var $valor;
    var $especial;
    var $estado;
    
    public function metodos()
    {
    }

    public function _metodos($patente)
    {
        $this->patente=$patente;
    }
//public function getAutor(){
//return $this->autor;
//}
//
//public function setAutor($autor){
//$this->autor = $autor;
//}
    public function getEspecial()
    {
        $especial='N';
        return $this->especial=$especial;
    }
    public function getEstado()
    {
        $estado='P';
        return $this->estado=$estado;
    }
    public function getIdUsuario()
    {
        $idusuarios=$_SESSION['idusuarios'];
        return $idusuarios;
    }
            
   function extraeValor()
   {
       $patente=$this->patente;
       if ($patente >= 0.02 && $patente <= 10) {
            $valor = ($patente * 2 / 100 );
        } else if ($patente >= 10.01 && $patente <= 50) {
            $valor = ($patente * 6 / 100 );
        } else if ($patente >= 50.01 && $patente <= 100) {
            $valor = ($patente * 8 / 100 );
        } else if ($patente >= 100.01 && $patente <= 150) {
            $valor = ($patente * 13 / 100 );
        } else if ($patente >= 150.01 && $patente <= 200) {
            $valor = ($patente * 19 / 100 );
        } else if ($patente >= 200.01 && $patente <= 250) {
            $valor = ($patente * 25 / 100 );
        } else if ($patente >= 250.01 && $patente <= 300) {
            $valor = ($patente * 30 / 100 );
        } else if ($patente >= 300.01 && $patente <= 350) {
            $valor = ($patente * 35 / 100 );
        } else if ($patente >= 350.01 && $patente <= 400) {
            $valor = ($patente * 40 / 100 );
        } else if ($patente >= 400.01 && $patente <= 450) {
            $valor = ($patente * 45 / 100 );
        } else if ($patente >= 450.01 && $patente <= 500) {
            $valor = ($patente * 50 / 100 );
        } else if ($patente >= 500.01 && $patente <= 550) {
            $valor = ($patente * 55 / 100 );
        } else if ($patente >= 550.01 && $patente <= 600) {
            $valor = ($patente * 60 / 100 );
        } else if ($patente >= 600.01 && $patente <= 650) {
            $valor = ($patente * 65 / 100 );
        } else if ($patente >= 650.01 && $patente <= 700) {
            $valor = ($patente * 70 / 100 );
        } else if ($patente >= 700.01 && $patente <= 750) {
            $valor = ($patente * 75 / 100 );
        } else if ($patente >= 750.01 && $patente <= 800) {
            $valor = ($patente * 80 / 100 );
        } else if ($patente >= 800.01 && $patente <= 850) {
            $valor = ($patente * 85 / 100 );
        } else if ($patente >= 850.01 && $patente <= 900) {
            $valor = ($patente * 90 / 100 );
        } else if ($patente >= 900.01 && $patente <= 950) {
            $valor = ($patente * 95 / 100 );
        } else if ($patente >= 950.01) {            
            $valor = ($patente * 100 / 100 );
        }
        return $this->valor=$valor;
   }
   function getTipoDocumento($documento)
   {
       switch (strlen($documento))
       {
           case 10:
               $documento='CEDULA';
               break;
           case 13:
               $documento='RUC';
               break;
           default :
               $documento='DOCUMENTO NO VALIDO';
               break;
       }
       return $documento;                            
   }
   function getFechaHora()
   {
       //metodo para extraer fecha
        date_default_timezone_set('America/Guayaquil');
        $fechaHora= date ("Y-m-d").' '.date ("H:i:s");
        return $fechaHora;
   }
   function getAnio()
   {
       //metodo para extraer fecha
        date_default_timezone_set('America/Guayaquil');
        $anio= date ("Y");
        return $anio;
   }
   function getMes()
   {
       //metodo para extraer fecha
        date_default_timezone_set('America/Guayaquil');
        $mes= date ("m");
        return $mes;
   }
   function getfechaMas3meses()
   {
       date_default_timezone_set('America/Guayaquil');        
       $fecha = date("Y-m-d");
        $nuevafecha = strtotime ( '+3 month' , strtotime ( $fecha ) ) ;
        $nuevafecha = date ("Y-m-d" , $nuevafecha ).' '.date ("H:i:s");
        return $nuevafecha;
   }
}
