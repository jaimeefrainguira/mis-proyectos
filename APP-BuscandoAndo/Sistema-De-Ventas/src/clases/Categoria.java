package clases;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Categoria 
{
    private int CAT_ID;
    private String CAT_DESCRIPCION;
    private byte[] CAT_IMAGEN;
    
    public Categoria()
    {
    }
    
    public Categoria (int CAT_ID, String CAT_DESCRIPCION,byte[] CAT_IMAGEN)
    {
        this.CAT_ID=CAT_ID;
        this.CAT_DESCRIPCION=CAT_DESCRIPCION;
        this.CAT_IMAGEN=CAT_IMAGEN;
    }

    /**
     * @return the CAT_ID
     */
    public int getCAT_ID() {
        return CAT_ID;
    }

    /**
     * @param CAT_ID the CAT_ID to set
     */
    public void setCAT_ID(int CAT_ID) {
        this.CAT_ID = CAT_ID;
    }

    /**
     * @return the CAT_DESCRIPCION
     */
    public String getCAT_DESCRIPCION() {
        return CAT_DESCRIPCION;
    }

    /**
     * @param CAT_DESCRIPCION the CAT_DESCRIPCION to set
     */
    public void setCAT_DESCRIPCION(String CAT_DESCRIPCION) {
        this.CAT_DESCRIPCION = CAT_DESCRIPCION;
    }
    

    /**
     * @return the CAT_IMAGEN
     */
    public byte[] getCAT_IMAGEN() {
        return CAT_IMAGEN;
    }

    /**
     * @param CAT_IMAGEN the CAT_IMAGEN to set
     */
    public void setCAT_IMAGEN(byte[] CAT_IMAGEN) {
        this.CAT_IMAGEN = CAT_IMAGEN;
    }
    
    public String getValuesSLQ()
    {
        return this.getCAT_ID()+",'"+this.getCAT_DESCRIPCION()+"',"+this.getCAT_IMAGEN();
    }
    
    public Icon getIcono(int w,int h)
    {
        JLabel lbl;
        try
        {
            byte[] bi = this.getCAT_IMAGEN();
            BufferedImage image = null;
            InputStream in = new ByteArrayInputStream(bi);
            image = ImageIO.read(in);
            ImageIcon imgi = new ImageIcon(image.getScaledInstance(w, h, 0));
            lbl = new JLabel(imgi);
        }
        catch(Exception ex)
        {
            lbl = new JLabel("No imagen");                
        }
        return lbl.getIcon();
        
    }
}
