package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Proyecto;

public interface ProyectoService {
    List<Proyecto> list();
    void save(Proyecto proyecto);
    Proyecto getById(Long id);
   void delete(long id);
    
}
