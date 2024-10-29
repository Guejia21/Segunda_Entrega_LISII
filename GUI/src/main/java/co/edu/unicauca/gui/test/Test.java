package co.edu.unicauca.gui.test;

import co.edu.unicauca.gui.servicios.ArticuloServices;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.gui.vistas.adminConferencia.VtnPrincipalAdmin;
import javax.swing.UIManager;



public class Test {

    
    public static void main(String[] args) {
        
        seleccionarLookAndField();
        ConferenciaServices objServicioConferencia = new ConferenciaServices();        
        ArticuloServices objServicioArticulos = new ArticuloServices();
        
        VtnPrincipalAdmin objVtnPrincipal= new VtnPrincipalAdmin();    
        objVtnPrincipal.asociarServicios(objServicioConferencia,objServicioArticulos); 
        
        objVtnPrincipal.setVisible(true);
        
    }
    
    private static void seleccionarLookAndField()
    {
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
                 } catch (Exception ex) {
            }
        }
    }
    
    
    
}
