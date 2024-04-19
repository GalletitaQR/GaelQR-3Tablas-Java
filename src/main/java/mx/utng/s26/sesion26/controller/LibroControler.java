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
import mx.utng.s26.sesion26.model.entity.Libro;
import mx.utng.s26.sesion26.model.service.LibroService;

@Controller
@SessionAttributes("libro")
public class LibroControler {
    //inyectamos un a dependencias del servicio 
    @Autowired
    private LibroService libroService;

    //Manda llamar este metodo en una petición GET
    //Que cocntenga como final de la querystring "","/", "/list"
    @GetMapping({"/libro/list","/libro","/libro/"})
    public String list(Model model){
        model.addAttribute("Title", "Listado de Libros");
        model.addAttribute("libros", libroService.list());
        return "llist";
    }

    //Petición que contenga al final de la url /form
    @GetMapping("/libro/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Registrar Libros");
        model.addAttribute("libro", new Libro());
        return "lform";
    }

    @GetMapping("/libro/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Libro libro = null;
        if(id>0){
            libro = libroService.getById(id);
        }else{
            return "redirect:/libro/list";
        }
        model.addAttribute("title", "Editar Libro");
        model.addAttribute("libro", libro);
        return "lform";
    }

    @PostMapping("/libro/form")
    public String save(@Valid Libro libro, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Registrar Libros");
            return "lform";
        }
        libroService.save(libro);
        return "redirect:/libro/list";
    }

    @GetMapping("/libro/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0) {
            libroService.delete(id);
        }
        return "redirect:/libro/list";
    }
}