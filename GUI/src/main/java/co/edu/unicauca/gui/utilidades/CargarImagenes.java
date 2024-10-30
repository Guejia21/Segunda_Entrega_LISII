/*
 * CargarImagenes.java
 */
package co.edu.unicauca.gui.utilidades;

import javax.swing.ImageIcon;


public class CargarImagenes {
    /**
     * Metodo que se encarga de cargar una imagen
     * @param ruta Ruta de la imagen que se desea cargar
     * @return Objeto de tipo ImageIcon
     */
    public ImageIcon CargarImagen(String ruta)
    {
        ImageIcon imagen= new javax.swing.ImageIcon(getClass().getResource(ruta));  
        return imagen;
    }
}
