package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.sesion26.model.entity.Proyecto;

@Repository
public class ProyectoDaoImpl implements ProyectoDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(long id) {
        Proyecto proyecto = getById(id);
        em.remove(proyecto);
    }

    @Override
    public Proyecto getById(long id) {
        return em.find(Proyecto.class, id);
    }

    @Override
    public List<Proyecto> list() {
        return em.createQuery("from Proyecto").getResultList();
    }




    
    @Override
    public void save(Proyecto proyecto) {
        if (proyecto.getId() != null && proyecto.getId()>0) {
           em.merge(proyecto);
        }else{
            em.persist(proyecto);
        }
    }
    
}
