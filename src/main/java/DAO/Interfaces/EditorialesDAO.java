
package DAO.Interfaces;
import Modelo.*;
import java.util.List;


public interface EditorialesDAO {
    public List ListarEditoriales();
    public Editoriales Obtener(int id);
    public boolean Crear(Editoriales edi);
    public boolean Actualizar(Editoriales edi);
    public boolean Eliminar(int id);
}
