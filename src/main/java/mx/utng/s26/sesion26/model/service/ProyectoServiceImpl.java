package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.ProyectoDao;
import mx.utng.s26.sesion26.model.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService{

    //Inyecta una interfaz para utilizar sus metodos 
    @Autowired
    private ProyectoDao proyectoDao;

    @Transactional(readOnly=true)
    @Override
    public List<Proyecto> list() {
       return proyectoDao.list();
    }

    @Transactional
    @Override
    public void save(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Transactional(readOnly=true)
    @Override
    public Proyecto getById(Long id) {
        return proyectoDao.getById(id);
    }


    @Transactional
    @Override
    public void delete(long id) {
        proyectoDao.delete(id);
    }





    
}
