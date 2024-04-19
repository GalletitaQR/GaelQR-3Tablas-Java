package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.RegistroDao;
import mx.utng.s26.sesion26.model.entity.Registro;

@Service
public class RegistroServiceImpl implements RegistroService{

    //Inyecta una interfaz para utilizar sus metodos 
    @Autowired
    private RegistroDao registroDao;

    @Transactional(readOnly=true)
    @Override
    public List<Registro> list() {
       return registroDao.list();
    }

    @Transactional
    @Override
    public void save(Registro registro) {
        registroDao.save(registro);
    }

    @Transactional(readOnly=true)
    @Override
    public Registro getById(Long id) {
        return registroDao.getById(id);
    }


    @Transactional
    @Override
    public void delete(long id) {
        registroDao.delete(id);
    }





    
}
