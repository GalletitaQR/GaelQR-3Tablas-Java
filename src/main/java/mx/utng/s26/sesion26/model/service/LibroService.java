package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Libro;

public interface LibroService {
    List<Libro> list();
    void save(Libro libro);
    Libro getById(Long id);
    void delete(long id);
    
}
