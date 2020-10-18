package edu.ic4302.controller;



import java.util.List;

import edu.ic4302.DAO.CompraDAO;
import edu.ic4302.DAO.TipoDAO;
import edu.ic4302.DAO.ProveedorDAO;
import edu.ic4302.model.Proveedor;
import edu.ic4302.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import edu.ic4302.model.Compra;


@Controller
public class CompraController {

    @Autowired
    private CompraDAO compraDAO;

    @RequestMapping("/compras")
    public String viewCompras(Model model) {
        List<Compra> listCompras = compraDAO.listCompras();
        model.addAttribute("listCompras", listCompras);
        return "/compra/view-compras";
    }

    @RequestMapping("/compras/new")
    public String newCompra(Model model) {
        Compra compra = new Compra();
        model.addAttribute("compra", compra);

        return "/compra/new-compra-form";
    }

    @RequestMapping(value = "/compras/save", method = RequestMethod.POST)
    public String saveCompra (@ModelAttribute("compra") Compra compra) {

        compraDAO.saveCompra(compra);

        return "redirect:/compras";
    }

    @RequestMapping("/compras/edit/{id}")
    public ModelAndView editCompraForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/compra/edit-compra-form");
        Compra compra = compraDAO.getCompra(id);
        modelAndView.addObject("compra", compra);

        return modelAndView;
    }

    @RequestMapping(value = "/compras/update", method = RequestMethod.POST)
    public String updateCompra(@ModelAttribute("compra") Compra compra) {
        compraDAO.updateCompra(compra);

        return "redirect:/compras";
    }

    @RequestMapping("/compras/delete/{id}")
    public String deleteProveedor(@PathVariable(name = "id") int id) {

        compraDAO.deleteCompra(id);

        return "redirect:/compras";
    }

}
