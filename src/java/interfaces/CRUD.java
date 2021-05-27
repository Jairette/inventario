
package interfaces;

import java.util.List;


public interface CRUD<E> {
        public List listar();
    public E list(int id);
    public boolean add(E e);
    public boolean edit(E e);
    public boolean eliminar(int id);
}
