package mx.utng.s26.sesion26.model.dao;
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Proyecto;


public interface ProyectoDao {
   List<Proyecto> list();
   void save(Proyecto proyecto);
   Proyecto getById(long id);
   void delete(long id);
}
