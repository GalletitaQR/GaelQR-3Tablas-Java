package mx.utng.s26.sesion26.model.dao;
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Registro;


public interface RegistroDao {
   List<Registro> list();
   void save(Registro registro);
   Registro getById(long id);
   void delete(long id);
}
