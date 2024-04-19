package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.sesion26.model.entity.Libro;

@Repository
public class LibroDaoImp implements LibroDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(long id) {
        Libro libro = getById(id);
        em.remove(libro);
    }

    @Override
    public Libro getById(long id) {
        return em.find(Libro.class, id);
    }

    @Override
    public List<Libro> list() {
        return em.createQuery("from Libro").getResultList();
    }




    
    @Override
    public void save(Libro libro) {
        if (libro.getId() != null && libro.getId()>0) {
           em.merge(libro);
        }else{
            em.persist(libro);
        }
    }
    
}
