package clases;

import Presentacion.F_Cliente;
import Presentacion.F_Producto;
import Presentacion.Menu;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.gt;
import static javax.management.Query.lt;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class validaciones 
{
   
    public DefaultFormatterFactory moneda()
    {
                // Formato de visualización
        NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
        // Formato de edición: inglés (separador decimal: el punto)
        NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
        // Para la edición, no queremos separadores de millares
        editFormat.setGroupingUsed(false);
        // Creamos los formateadores de números
        NumberFormatter dnFormat = new NumberFormatter(dispFormat);
        NumberFormatter enFormat = new NumberFormatter(editFormat);
        // Creamos la factoría de formateadores especificando los
        // formateadores por defecto, de visualización y de edición
        DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
        // El formateador de edición admite caracteres incorrectos
        enFormat.setAllowsInvalid(true);
        // Asignamos la factoría al campo
        return currFactory;
    }
    public void mayusculas(KeyEvent evt) 
    {
        char c=evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }        
    }

    public void decimales(KeyEvent evt, String text) 
    {
        boolean estado=true;
        String formato = null;
        if(text.equals(""))
        {
            formato=String.valueOf(evt.getKeyChar());
        }
        else
        {
            formato=text+String.valueOf(evt.getKeyChar());
        }
 
        boolean deci=false;
        int dosdecimales=0;
        for (int i = 0; i < formato.length(); i++) 
        {
            char let=formato.charAt(i);
            if(deci)
            {
                dosdecimales++;
            }
            if(formato.charAt(i)=='.')
            {
                deci=true;
            }            
        }

        try
        {
            if(dosdecimales<=2)
            {
                if(evt.getExtendedKeyCode()!=8)
                {
                    double dec=Double.parseDouble(formato);
                }
            }
            else
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        catch (NumberFormatException e)
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void enteros(KeyEvent evt) 
    {
//        evt.VK_ENTER==evt.getKeyCode()            
        if(evt.getKeyChar() != '\b')
        {
            try
            {
                Integer.parseInt(String.valueOf(evt.getKeyChar()));
            }
            catch(NumberFormatException e)
            {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
        else
        {
//            JOptionPane.showMessageDialog(null, "borro");
        }
    }
    
    public double redondearDecimales(double numero)
    {
        BigDecimal redondeado = new BigDecimal(numero)
                                .setScale(2, RoundingMode.HALF_EVEN);
        return redondeado.doubleValue();
    }

    public DecimalFormat formatoMoneda() {
        DecimalFormat formateador = new DecimalFormat("$#,###,###.##");
        return formateador;
    }

    public DecimalFormat formatoNumero() {
        DecimalFormat formateador = new DecimalFormat("#,###,###.##");
        return formateador;
    }
    
    public double formatDinero(String dinero)
    {
        System.out.println("esto es el valor: "+dinero);
        
        dinero=dinero.replace('.', ',');
        
        double num=0;
        try 
        {
            num=formatoMoneda().parse(dinero).doubleValue();
        }
        catch (ParseException ex) 
        {
//            System.out.println("no es formato moneda");
        }
        
        try 
        {
            num=formatoNumero().parse(dinero).doubleValue();
        }
        catch (ParseException ex) 
        {
//            System.out.println("no es formato decimal");
        }
        return num;
    }
    
    
public String getFechaHora()
{
    
  
    Date date = new Date();
    //Caso 1: obtener la hora y salida por pantalla con formato:
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//    System.out.println("Hora: "+hourFormat.format(date));
    //Caso 2: obtener la fecha y salida por pantalla con formato:
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println("Fecha: "+dateFormat.format(date));
    //Caso 3: obtenerhora y fecha y salida por pantalla con formato:
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    return hourdateFormat.format(date); //    2019-03-24 21:08:12
}
   
public String getFecha()
{
    
  
    Date date = new Date();
    //Caso 1: obtener la hora y salida por pantalla con formato:
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//    System.out.println("Hora: "+hourFormat.format(date));
    //Caso 2: obtener la fecha y salida por pantalla con formato:
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println("Fecha: "+dateFormat.format(date));

    return dateFormat.format(date); //    2019-03-24 21:08:12
}
public String getHora()
{
    Date date = new Date();
    //Caso 1: obtener la hora y salida por pantalla con formato:
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//    System.out.println("Hora: "+hourFormat.format(date));
    

    return hourFormat.format(date); //    2019-03-24 21:08:12
}
    
public String getFechaLarga()
{
    

   SimpleDateFormat formateador = new SimpleDateFormat( "EEEE d' de 'MMMM' de 'yyyy",new Locale("es","ES"));
   Date fechaDate = new Date();

    

    return formateador.format(fechaDate); //    2019-03-24 21:08:12
}

    public String convierteNumeroFactura(int fac_cab_id) {
        
        int caracteres =String.valueOf(fac_cab_id).length();
        String numFac="";
        for(int i=7;i>caracteres;i--)
        {
            numFac=numFac+"0";
        }
        numFac=numFac+String.valueOf(fac_cab_id);
        return numFac;

    }

    public void colorRojo(JTextField jTextField2) 
    {
        jTextField2.setBackground(Color.decode("#FCDEDE"));
    }
    public void colorVerde(JTextField jTextField2)
    {
        jTextField2.setBackground(Color.decode("#EBF9DE"));
    }
    public void colorBlanco(JTextField jTextField2)
    {
        jTextField2.setBackground(Color.decode("#FFFFFF"));
    }
    public int validaTxtVacios(JTextField txt)
    {
        int validado=1;
        if(txt.getText().equals(""))          {validado=0; colorRojo(txt);}else{colorBlanco(txt);}
        return validado;
    }

    public void tamanioTextFiel(KeyEvent evt, int length, int i) 
    {
       if(length>=i)
       {
           evt.consume();
           Toolkit.getDefaultToolkit().beep();
       }
    }
    public int getInteger(String num)
    {
        int entero=-1;
        try 
        {
            entero=Integer.parseInt(num);
        } 
        catch (NumberFormatException e) 
        {
//            System.out.println("no es un numero");
        }
        return entero;
    }

    public boolean noNulloText(JTextField prod_nombre) 
    {
        boolean bool=true;        
        if(prod_nombre.getText().equals("")||prod_nombre.getText().charAt(0)==' ')
        {
            bool=false;
            this.colorRojo(prod_nombre);
        }
        else
        {
            this.colorVerde(prod_nombre);
        }
        return bool;
    }

    
    
    
    
    //validaciones de cedulas y ruc
        
    public boolean validarCIoRUC(String numero, JTextField txtCedula)
    {
        try 
        {
            validarInicial(numero);
            validarCodigoProvincia(numero.substring(0, 2));
            int tipoDocumento=validarTercerDigito(numero);
            if(tipoDocumento!=1)
            {
                validarCodigoEstablecimiento(numero.substring(10, 13));
            }
            
            algoritmo(numero,tipoDocumento);
            colorVerde(txtCedula);
        } 
        catch (Exception ex) 
        {
            colorRojo(txtCedula);
            return false;
        }
        return true;
    }

    protected boolean validarInicial(String numero) throws Exception 
    {   
        if (StringUtils.isEmpty(numero)) 
        {
            throw new Exception("Valor no puede estar vacio");
        }
        
//        if (! NumberUtils.isDigits(numero)) 
//        {
//            throw new Exception("Valor ingresado solo puede tener dígitos");
//        }

//        if (numero.length() != caracteres) 
//        {
//            throw new Exception("Valor ingresado debe tener "+ caracteres + " caracteres");
//        }
        
        switch(numero.length())
        {
            case 10:
                System.out.println("Tipo de numero: Cedula");
                break;
            case 13:
                System.out.println("Tipo de numero: RUC");
                break;
            default:
                throw new Exception("Cedula o Ruc no es el correcto");
        }

        return true;
    }
    protected boolean validarCodigoProvincia(String numero) throws Exception
    {
        if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 24) 
        {
            throw new Exception("Codigo de Provincia (dos primeros dígitos) no deben ser mayor a 24 ni menores a 0");
        }

        return true;
    }

    private int validarTercerDigito(String numero) throws Exception
    {
        
        int tipo=Integer.parseInt(String.valueOf(numero.charAt(2)));
        switch (tipo) 
        {
            case 9:
                tipo=3;//identificador ruc privada
                break;

            case 6:
                tipo=4;//identificador ruc publica
                break;
            default:
                if(tipo>=0&&tipo<=5)
                {
                    if(numero.length()==10)
                    {
                        tipo=1;//identificador para cedulas
                    }
                    if(numero.length()==13)
                    {
                        tipo=2;//identificador para ruc persona natural
                    }                    
                }
                else
                {
                    throw new Exception("Tipo de Identificacion no existe.");
                }                
        }
        return tipo;
    }
    
    protected boolean validarCodigoEstablecimiento(String numero) throws Exception
    {
        if (Integer.parseInt(numero) != 1) 
        {
            throw new Exception("Código de establecimiento no puede ser 0");
        }
        return true;
    }

    protected boolean algoritmo(String numero, int tipoDocumento) throws Exception
    {
        Integer [] arrayCoeficientes = null;
        String digitosIniciales=numero.substring(0, 9);
        int digitoVerificador = Integer.parseInt(String.valueOf(numero.charAt(9)));
        int constante = 0;
        switch (tipoDocumento) 
        {
            case 1:
                arrayCoeficientes = new Integer[]{2,1,2,1,2,1,2,1,2};
                constante=10;
                break;

                case 2:
                arrayCoeficientes = new Integer[]{2,1,2,1,2,1,2,1,2};
                constante=10;
                break;

                case 3:
                arrayCoeficientes = new Integer[]{4, 3, 2, 7, 6, 5, 4, 3, 2};
                constante=11;
                break;
                
                case 4:
                arrayCoeficientes = new Integer[]{3, 2, 7, 6, 5, 4, 3, 2};
                constante=11;
                digitoVerificador=Integer.parseInt(String.valueOf(numero.charAt(8)));
                break;
        }

        Integer [] digitosInicialesTMP = new Integer[digitosIniciales.length()];
        int indice=0;
        for(char valorPosicion: digitosIniciales.toCharArray())
        {
            digitosInicialesTMP[indice] = NumberUtils.createInteger(String.valueOf(valorPosicion));
            indice++;
        }  

        int total = 0;
        int key = 0;
        switch (tipoDocumento) 
        {
            case 1:
                for(Integer valorPosicion: digitosInicialesTMP)
                {
                    int valor = ((valorPosicion * arrayCoeficientes[key]) > 9) ? ((valorPosicion * arrayCoeficientes[key]) - 9) : (valorPosicion * arrayCoeficientes[key]);
                    total += valor;
                    key++;
                }
                break;

            case 2:
                for(Integer valorPosicion: digitosInicialesTMP)
                {
                    int valor = ((valorPosicion * arrayCoeficientes[key]) > 9) ? ((valorPosicion * arrayCoeficientes[key]) - 9) : (valorPosicion * arrayCoeficientes[key]);
                    total += valor;
                    key++;
                }
                break;

            case 3:
                for(Integer valorPosicion: digitosInicialesTMP)
                {
                    int valor = valorPosicion * arrayCoeficientes[key];
                    total += valor;
                    key++;
                }
                break;
            case 4:
                for(Integer valorPosicion: arrayCoeficientes)
                {
                    int valor = valorPosicion * digitosInicialesTMP[key];
                    total += valor;
                    key++;
                }
                break;
        }
        System.out.println("valor buscado "+total);
        int residuo, resp;
        residuo = total % constante;
        resp = constante - residuo; 
        resp = (residuo == 0) ? 0 : resp; 
        
        if (resp == digitoVerificador) 
        {
            return true;
        }
        else 
        {
            throw new Exception("Dígitos iniciales no validan contra Dígito Idenficador");
        }
    }

    public String getFecha(Date date) 
    {
    //Caso 1: obtener la hora y salida por pantalla con formato:
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//    System.out.println("Hora: "+hourFormat.format(date));
    //Caso 2: obtener la fecha y salida por pantalla con formato:
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println("Fecha: "+dateFormat.format(date));

    return dateFormat.format(date); //    2019-03-24 21:08:12
    }

    public Date getFechaParseada(String usu_fecha_nacimiento) 
    {
        java.util.Date fechaParseada = null;
        try {
            return fechaParseada = new SimpleDateFormat("yyyy-MM-dd").parse(usu_fecha_nacimiento);
        } catch (ParseException ex) {
           
        }
        return fechaParseada;
    }

    public void mensajeError(String numError,String mensaje) 
    {
        switch(numError)
        {
            case"1062"://codigo de error de clave duplicada
                JOptionPane.showMessageDialog(null, mensaje+" ya se encuentra registrado");
                break;
        }
    }
    
    
}
