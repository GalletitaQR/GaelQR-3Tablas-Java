package mx.utng.s26.sesion26.model.dao;
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Libro;


public interface LibroDao {
    //Listar libros
   List<Libro> list();
   //Guardar un libro
   void save(Libro libro);
   Libro getById(long id);
   void delete(long id);
}
