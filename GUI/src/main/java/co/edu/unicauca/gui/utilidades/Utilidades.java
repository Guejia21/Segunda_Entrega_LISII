package co.edu.unicauca.gui.utilidades;


import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.text.JTextComponent;

/**
 *
 * @author libardo
 */
public class Utilidades {

    /**
     * Genera un emergente de aventencia
     *
     * @param mns mensaje dentro de la ventana
     * @param titulo título de la ventana
     */
    public static void mensajeAdvertencia(String mns, String titulo) {
        CargarImagenes objCargarImagenes= new CargarImagenes();
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, objCargarImagenes.CargarImagen("/recursos/logo.png"));
    }

    /**
     * Genera un emergente de error
     *
     * @param mns mensaje dentro de la ventana
     * @param titulo título de la ventana
     */
    public static void mensajeError(String mns, String titulo) {
        CargarImagenes objCargarImagenes= new CargarImagenes();
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, objCargarImagenes.CargarImagen("/recursos/warning.png"));
    }

    /**
     * Genera un emergente de exito
     *
     * @param mns mensaje dentro de la ventana
     * @param titulo título de la ventana
     */
    public static void mensajeExito(String mns, String titulo) {
        CargarImagenes objCargarImagenes= new CargarImagenes();
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, objCargarImagenes.CargarImagen("/recursos/exitoso.png"));
    }

    /**
     * Genera un emergente de confirmación con los botones Si ó No
     *
     * @param mns mensaje dentro de la ventana
     * @param titulo título de la ventana
     * @return Si ó No
     */
    public static int mensajeConfirmacion(String mns, String titulo) {        
        return JOptionPane.showConfirmDialog(null, mns, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    /**
     * Valida los campos de entrada
     * @param campos Inputs
     * @return false si algún campo está vacio, true en caso contrario
     */
    public static boolean validarCampos(List<JTextComponent> campos){
        for(JTextComponent campo : campos){
            if(campo.getText().isBlank()) return false;          
        }
        return true;
    }
    public static void limpiarCampos(List<JTextComponent> campos){
        for(JTextComponent campo : campos){
         campo.setText("");
        }
    }

}
