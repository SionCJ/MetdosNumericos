package sist_ecuaciones;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    Image imagen;
    
    public Ventana(Image imagen){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());
        this.imagen = imagen;
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(imagen, 50, 50, rootPane);
    }
}
