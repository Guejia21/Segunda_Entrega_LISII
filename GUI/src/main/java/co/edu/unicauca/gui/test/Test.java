package co.edu.unicauca.gui.test;

import co.edu.unicauca.gui.accesoADatos.RepositorioArticuloMemoriaArrayList;
import co.edu.unicauca.gui.accesoADatos.RepositorioConferenciaMemoriaArrayList;
import co.edu.unicauca.gui.controladores.ServicioAlmacenamientoArticulos;
import co.edu.unicauca.gui.controladores.ServicioAlmacenamientoConferencias;
import co.edu.unicauca.gui.vistas.adminConferencia.VtnPrincipalAdmin;
import javax.swing.UIManager;



public class Test {

    
    public static void main(String[] args) {
        
        seleccionarLookAndField();
                
        RepositorioConferenciaMemoriaArrayList objRepositorio1=
                new RepositorioConferenciaMemoriaArrayList();
        
        ServicioAlmacenamientoConferencias objServicio1
                = new   ServicioAlmacenamientoConferencias(objRepositorio1);  
        
        
        RepositorioArticuloMemoriaArrayList objRepositorio2=
                new RepositorioArticuloMemoriaArrayList();
        
        ServicioAlmacenamientoArticulos objServicio2
                = new ServicioAlmacenamientoArticulos(objRepositorio2);
        
        VtnPrincipalAdmin objVtnPrincipal= new VtnPrincipalAdmin();    
        objVtnPrincipal.asociarServios(objServicio1,objServicio2); 
        
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
