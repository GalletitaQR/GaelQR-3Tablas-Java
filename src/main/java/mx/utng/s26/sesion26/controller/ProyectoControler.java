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
import mx.utng.s26.sesion26.model.entity.Proyecto;
import mx.utng.s26.sesion26.model.service.ProyectoService;

@Controller
@SessionAttributes("proyecto")
public class ProyectoControler {
    //inyectamos un a dependencias del servicio 
    @Autowired
    private ProyectoService proyectoService;

    //Manda llamar este metodo en una petición GET
    //Que cocntenga como final de la querystring "","/", "/list"
    @GetMapping({"","/","/list"})
    public String list(Model model){
        model.addAttribute("Title", "Listado de Proyecto");
        model.addAttribute("proyectos", proyectoService.list());
        return "list";
    }

    //Petición que contenga al final de la url /form
    @GetMapping("/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Registrar Proyecto");
        model.addAttribute("proyecto", new Proyecto());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Proyecto proyecto = null;
        if(id>0){
            proyecto = proyectoService.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Materia");
        model.addAttribute("proyecto", proyecto);
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Proyecto proyecto, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Registrar Proyecto");
            return "form";
        }
        proyectoService.save(proyecto);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0) {
            proyectoService.delete(id);
        }
        return "redirect:/list";
    }
}