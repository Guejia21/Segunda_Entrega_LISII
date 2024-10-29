package co.edu.unicauca.gui.accesoADatos;

import co.edu.unicauca.gui.modelos.Conferencia;
import java.util.List;

public interface InterfaceRepositorioConferencia {
    public boolean almacenarConferencia(Conferencia objConferencia);
    public List<Conferencia> listarConferencias();
}
