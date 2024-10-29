package co.edu.unicauca.gui.controladores;

import co.edu.unicauca.gui.accesoADatos.InterfaceRepositorioConferencia;
import co.edu.unicauca.gui.infraestructura.Subject;
import java.util.List;
import co.edu.unicauca.gui.modelos.Conferencia;


public class ServicioAlmacenamientoConferencias extends Subject{
    
    private InterfaceRepositorioConferencia referenciaRepositorioConferencias;
    
    public ServicioAlmacenamientoConferencias(InterfaceRepositorioConferencia referenciaRepositorioConferencias)
    {
        this.referenciaRepositorioConferencias=referenciaRepositorioConferencias;
    }
    
    public boolean almacenarConferencia(Conferencia objConfererencia) {
        boolean bandera=this.referenciaRepositorioConferencias.almacenarConferencia(objConfererencia);
        this.notifyAllObserves();
        return bandera;
    }

   
    public List<Conferencia> listarConferencias() {
        return this.referenciaRepositorioConferencias.listarConferencias();
    }
}
