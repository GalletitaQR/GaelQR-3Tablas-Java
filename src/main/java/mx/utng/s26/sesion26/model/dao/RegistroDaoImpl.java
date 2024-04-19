package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.sesion26.model.entity.Registro;

@Repository
public class RegistroDaoImpl implements RegistroDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(long id) {
        Registro registro = getById(id);
        em.remove(registro);
    }

    @Override
    public Registro getById(long id) {
        return em.find(Registro.class, id);
    }

    @Override
    public List<Registro> list() {
        return em.createQuery("from Registro").getResultList();
    }




    
    @Override
    public void save(Registro registro) {
        if (registro.getId() != null && registro.getId()>0) {
           em.merge(registro);
        }else{
            em.persist(registro);
        }
    }
    
}
