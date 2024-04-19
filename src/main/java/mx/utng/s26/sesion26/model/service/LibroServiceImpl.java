package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.LibroDao;
import mx.utng.s26.sesion26.model.entity.Libro;

@Service
public class LibroServiceImpl implements LibroService{

    //Inyecta una interfaz para utilizar sus metodos 
    @Autowired
    private LibroDao libroDao;

    @Transactional(readOnly=true)
    @Override
    public List<Libro> list() {
       return libroDao.list();
    }

    @Transactional
    @Override
    public void save(Libro libro) {
        libroDao.save(libro);
    }

    @Transactional(readOnly=true)
    @Override
    public Libro getById(Long id) {
        return libroDao.getById(id);
    }


    @Transactional
    @Override
    public void delete(long id) {
        libroDao.delete(id);
    }





    
}
