package co.edu.unicauca.gui.accesoADatos;

import co.edu.unicauca.gui.modelos.Articulo;
import java.util.List;

public interface InterfaceRepositorioArticulo {
    public boolean almacenarArticulo(Articulo objArticulo);
    public List<Articulo> listarArticulos();
    public boolean eliminarArticulo(int idArticulo);
    public Articulo consultarArticulo(int idArticulo);
    public boolean actualizarArticulo(Articulo objArticulo);
}
