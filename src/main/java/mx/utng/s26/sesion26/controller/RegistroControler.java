package mx.utng.s26.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.s26.sesion26.model.entity.Registro;
import mx.utng.s26.sesion26.model.service.RegistroService;

@Controller
@SessionAttributes("registro")
public class RegistroControler {
    //inyectamos un a dependencias del servicio 
    @Autowired
    private RegistroService registroService;

    //Manda llamar este metodo en una petición GET
    //Que cocntenga como final de la querystring "","/", "/list"
    @GetMapping({"/registro/list","/registro","/registro/"})
    public String list(Model model){
        model.addAttribute("Title", "Listado de registro");
        model.addAttribute("registros", registroService.list());
        return "rlist";
    }

    //Petición que contenga al final de la url /form
    @GetMapping("/registro/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Registrar registro");
        model.addAttribute("registro", new Registro());
        return "rform";
    }

    @GetMapping("/registro/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Registro registro = null;
        if(id>0){
            registro = registroService.getById(id);
        }else{
            return "redirect:/registro/list";
        }
        model.addAttribute("title", "Editar Registro");
        model.addAttribute("registro", registro);
        return "rform";
    }

    @PostMapping("/registro/form")
    public String save(@Valid Registro registro, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Registrar registro");
            return "rform";
        }
        registroService.save(registro);
        return "redirect:/registro/list";
    }

    @GetMapping("/registro/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0) {
            registroService.delete(id);
        }
        return "redirect:/registro/list";
    }
}