
package interfaces;

import java.util.ArrayList;
import java.util.List;


public interface CRUD<E> {
    public ArrayList<E> listar();
    public E list(int id);
    public boolean add(E e);
    public boolean edit(E e);
    public boolean eliminar(int id);
}
