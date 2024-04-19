package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Registro;

public interface RegistroService {
    List<Registro> list();
    void save(Registro registro);
    Registro getById(Long id);
   void delete(long id);
    
}
