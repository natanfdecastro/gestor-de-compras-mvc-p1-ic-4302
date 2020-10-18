package edu.ic4302.controller;

import java.util.List;

import edu.ic4302.DAO.ProveedorDAO;
import edu.ic4302.DAO.TipoDAO;
import edu.ic4302.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import edu.ic4302.model.Tipo;

@Controller
public class TipoController {

    @Autowired
    private TipoDAO tipoDAO;

    @RequestMapping("/tipos")
    public String viewTipos(Model model) {
        List<Tipo> listTipos = tipoDAO.listTipo();
        model.addAttribute("listTipos", listTipos);
        return "/tipo/view-tipos";
    }

    @RequestMapping("/tipo/new")
    public String newTipoForm(Model model) {
        Tipo tipo = new Tipo();
        model.addAttribute("tipo", tipo);

        return "/tipo/new-tipo-form";
    }

    @RequestMapping(value = "/tipo/save", method = RequestMethod.POST)
    public String save (@ModelAttribute("tipo") Tipo tipo) {

        tipoDAO.saveTipo(tipo);

        return "redirect:/tipos";
    }

    @RequestMapping("/tipo/edit/{id}")
    public ModelAndView editTipoForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/tipo/edit-tipo-form");
        Tipo tipo = tipoDAO.getTipo(id);
        modelAndView.addObject("tipo", tipo);

        return modelAndView;
    }

    @RequestMapping(value = "/tipo/update", method = RequestMethod.POST)
    public String updateTipo(@ModelAttribute("tipo") Tipo tipo) {
        tipoDAO.updateTipo(tipo);

        return "redirect:/tipos";
    }

    @RequestMapping("/tipo/delete/{id}")
    public String deleteTipo(@PathVariable(name = "id") int id) {

        tipoDAO.deleteTipo(id);

        return "redirect:/tipos";
    }

}
