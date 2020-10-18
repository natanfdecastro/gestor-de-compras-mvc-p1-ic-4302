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

    @RequestMapping("/proveedores")
    public String viewProveedores(Model model) {
        List<Proveedor> listProveedores = proveedorDAO.listProveedores();
        model.addAttribute("listProveedores", listProveedores);
        return "/proveedor/view-proveedores";
    }

    @RequestMapping("/proveedores/new")
    public String newProveedorForm(Model model) {
        Proveedor proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);

        return "/proveedor/new-proveedor-form";
    }

    @RequestMapping(value = "/proveedores/save", method = RequestMethod.POST)
    public String saveProveedor (@ModelAttribute("proveedor") Proveedor proveedor) {

        proveedorDAO.saveProveedor(proveedor);

        return "redirect:/proveedores";
    }

    @RequestMapping("/proveedores/edit/{id}")
    public ModelAndView editProveedorForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/proveedor/edit-proveedor-form");
        Proveedor proveedor = proveedorDAO.getProveedor(id);
        modelAndView.addObject("proveedor", proveedor);

        return modelAndView;
    }

    @RequestMapping(value = "/proveedores/update", method = RequestMethod.POST)
    public String updateProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorDAO.updateProveedor(proveedor);

        return "redirect:/proveedores";
    }

    @RequestMapping("/proveedores/delete/{id}")
    public String deleteProveedor(@PathVariable(name = "id") int id) {

        proveedorDAO.deleteProveedor(id);

        return "redirect:/proveedores";
    }
}
