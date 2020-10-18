package edu.ic4302.controller;

import java.util.List;

import edu.ic4302.DAO.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import edu.ic4302.model.Proveedor;

@Controller
public class ProveedorController {

    @Autowired
    private ProveedorDAO proveedorDAO;

    @RequestMapping("/proveedores/")
    public String viewProveedores(Model model) {
        List<Proveedor> listProveedores = proveedorDAO.list();
        model.addAttribute("listProveedores", listProveedores);
        return "table-responsive";
    }

    @RequestMapping("/proveedores/new")
    public String showNewForm(Model model) {
        Proveedor proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);

        return "new_form";
    }

    @RequestMapping(value = "/proveedores/save", method = RequestMethod.POST)
    public String save (@ModelAttribute("proveedor") Proveedor proveedor) {

        proveedorDAO.save(proveedor);

        return "redirect:/proveedores/";
    }

    @RequestMapping("/proveedores/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {

        ModelAndView mav = new ModelAndView("edit_form");
        Proveedor proveedor = proveedorDAO.get(id);
        mav.addObject("proveedor", proveedor);

        return mav;
    }

    @RequestMapping(value = "/proveedores/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorDAO.update(proveedor);

        return "redirect:/proveedores/";
    }

    @RequestMapping("/proveedores/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {

        proveedorDAO.delete(id);

        return "redirect:/proveedores/";
    }


}
