
package sist_ecuaciones;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.scilab.forge.jlatexmath.TeXIcon;

public class DiseñadorImagen {
    BufferedImage imagen;
    
    public DiseñadorImagen(BufferedImage imagen){
        this.imagen = imagen;
    }
    public DiseñadorImagen(TeXIcon TexIcon){
        imagen = DiseñadorImagen.TexIconToBuffImage(TexIcon);
    }
    
    public BufferedImage getImagen(){
        return imagen;
    }
    
    public ImageIcon getImageIcon(){
        return new ImageIcon(imagen);
    }
    
    public void agregarArriba(BufferedImage img, double centrado){
        imagen = DiseñadorImagen.pegarVerticalmente(img, imagen, centrado);
    }
    public void agregarAbajo(BufferedImage img, double centrado){
        imagen = DiseñadorImagen.pegarVerticalmente(imagen, img, centrado);
    }
    public void agregarIzquierda(BufferedImage img, double centrado){
        imagen = DiseñadorImagen.pegarHorizontalmente(img, imagen, centrado);
    }
    public void agregarDerecha(BufferedImage img, double centrado){
        imagen = DiseñadorImagen.pegarHorizontalmente(imagen, img, centrado);
    }
    public void agregarDerecha(BufferedImage img, double centrado, int espacio){
        imagen = DiseñadorImagen.pegarHorizontalmente(imagen, img, centrado, espacio);
    }
    
    public static BufferedImage pegarHorizontalmente(BufferedImage img1, BufferedImage img2, double centrado){
        if( centrado<0 )
            centrado = 0;
        else if( centrado>1 )
            centrado = 1;
        int anchoImg1 = img1.getWidth();
        int anchoImg2 = img2.getWidth();
        System.out.println("Imagen 1: w="+anchoImg1+"\th="+img1.getHeight());
        System.out.println("Imagen 2: w="+anchoImg2+"\th="+img2.getHeight());
        int altoMax = img1.getHeight() > img2.getHeight() ? img1.getHeight() : img2.getHeight();
        int altoMin = img1.getHeight() < img2.getHeight() ? img1.getHeight() : img2.getHeight();
        System.out.println("AltoMax = "+altoMax);
        System.out.println("AltoMin = "+altoMin);
        int espLibre, desplazamiento;
        
        espLibre = altoMax - altoMin;
        desplazamiento = (int) Math.round(espLibre*centrado);
        System.out.println("espacio libre = "+espLibre);
        System.out.println("Desplazamiento = "+desplazamiento);
        BufferedImage imgFinal = new BufferedImage ( anchoImg1+anchoImg2, altoMax, BufferedImage.TYPE_4BYTE_ABGR);
        if( img1.getHeight() > img2.getHeight() ){
            imgFinal.createGraphics().drawImage(img1, 0,0 , null);
            imgFinal.createGraphics().drawImage(img2, anchoImg1,desplazamiento , null);
        }else{
            imgFinal.createGraphics().drawImage(img1, 0,desplazamiento , null);
            imgFinal.createGraphics().drawImage(img2, anchoImg1,0 , null);
        }
        
        return imgFinal;
    }
    
    public static BufferedImage pegarHorizontalmente(BufferedImage img1, BufferedImage img2, double centrado, int espacio){
        if( centrado<0 )
            centrado = 0;
        else if( centrado>1 )
            centrado = 1;
        int anchoImg1 = img1.getWidth();
        int anchoImg2 = img2.getWidth();
        System.out.println("Imagen 1: w="+anchoImg1+"\th="+img1.getHeight());
        System.out.println("Imagen 2: w="+anchoImg2+"\th="+img2.getHeight());
        int altoMax = img1.getHeight() > img2.getHeight() ? img1.getHeight() : img2.getHeight();
        int altoMin = img1.getHeight() < img2.getHeight() ? img1.getHeight() : img2.getHeight();
        System.out.println("AltoMax = "+altoMax);
        System.out.println("AltoMin = "+altoMin);
        int espLibre, desplazamiento;
        
        espLibre = altoMax - altoMin;
        desplazamiento = (int) Math.round(espLibre*centrado);
        System.out.println("espacio libre = "+espLibre);
        System.out.println("Desplazamiento = "+desplazamiento);
        BufferedImage imgFinal = new BufferedImage ( anchoImg1+anchoImg2, altoMax, BufferedImage.TYPE_4BYTE_ABGR);
        if( img1.getHeight() > img2.getHeight() ){
            imgFinal.createGraphics().drawImage(img1, 0,0 , null);
            imgFinal.createGraphics().drawImage(img2, anchoImg1+espacio,desplazamiento , null);
        }else{
            imgFinal.createGraphics().drawImage(img1, 0,desplazamiento , null);
            imgFinal.createGraphics().drawImage(img2, anchoImg1+espacio,0 , null);
        }
        
        return imgFinal;
    }
    
    public static BufferedImage pegarVerticalmente(BufferedImage img1, BufferedImage img2, double centrado){
        if( centrado<0 )
            centrado = 0;
        else if( centrado>1 )
            centrado = 1;
        int espLibre, desplazamiento;
        int altoIcon1 = img1.getHeight();
        int altoIcon2 = img2.getHeight();
        int anchoIcon1 = img1.getWidth();
        int anchoIcon2 = img2.getWidth();
        int anchoMax = anchoIcon1 > anchoIcon2 ? anchoIcon1 : anchoIcon2;
        int anchoMin = anchoIcon1 < anchoIcon2 ? anchoIcon1 : anchoIcon2;
        
        espLibre = anchoMax - anchoMin;
        desplazamiento = (int) Math.round(espLibre*centrado);
        BufferedImage imgFinal = new BufferedImage ( anchoMax, altoIcon1+altoIcon2, BufferedImage.TYPE_4BYTE_ABGR);
        if( anchoIcon1 > anchoIcon2 ){
            imgFinal.createGraphics().drawImage(img1, 0,0 , null);
            imgFinal.createGraphics().drawImage(img2, desplazamiento,altoIcon1 , null);
        }else{
            imgFinal.createGraphics().drawImage(img1, desplazamiento,0 , null);
            imgFinal.createGraphics().drawImage(img2, 0,altoIcon1 , null);
        }
        
        return imgFinal;
    }
    
    public static BufferedImage TexIconToBuffImage(TeXIcon icon){
        BufferedImage buffImg = new BufferedImage (icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        icon.paintIcon(null, buffImg.createGraphics(), 0, 0);
        return buffImg;
    }
    
    public static void main (String[] args){
        
        JLabel label = new JLabel("A");
        TeXIcon ti = new MathText().dibujarFormula("x");
        BufferedImage b = new BufferedImage (ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d = b.createGraphics();
        ti.paintIcon(label, g2d, 0, 0);
        
        Image imTex = new ImagenMathText().imgFraccion("2", "34");
        ImageIcon icon = new ImageIcon(imTex);
        BufferedImage buffIm1 = (BufferedImage) new ImagenMathText().imgFraccion("2", "3489");
        DiseñadorImagen di = new DiseñadorImagen(b);
        di.agregarDerecha((BufferedImage) icon.getImage(), 0.5);
        BufferedImage imagen = di.getImagen();
        System.out.println("Dimension Imagen: w="+imTex.getWidth(label)+"\th="+imTex.getHeight(label));
        
        Ventana v = new Ventana(imagen);
        v.add( label );
        v.add( label );
        v.setBounds(100,100, 200,200);
        v.setVisible(true);
    }
}
