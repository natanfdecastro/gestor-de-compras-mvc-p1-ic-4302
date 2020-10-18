package edu.ic4302.controller;

import java.util.List;

import edu.ic4302.DAO.ProductoDAO;
import edu.ic4302.DAO.CompraProductoDAO;
import edu.ic4302.model.Producto;
import edu.ic4302.model.CompraProducto;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import edu.ic4302.model.Proveedor;

@Controller
public class CompraProductoController {

    @Autowired
    private CompraProductoDAO compraProductoDAO;

    @RequestMapping("/compraProductos")
    public String viewProductos(Model model) {
        List<CompraProducto> listCompraProductos = compraProductoDAO.listCompraProducto();
        model.addAttribute("listCompraProductos", listCompraProductos);
        return "/compraProducto/view-compraProducto";
    }

    @RequestMapping("/compraProductos/new")
    public String newProductoForm(Model model) {
        CompraProducto compraProducto = new CompraProducto();
        model.addAttribute("compraProducto", compraProducto);

        return "/compraProducto/new-compraProducto-form";
    }

    @RequestMapping(value = "/compraProductos/save", method = RequestMethod.POST)
    public String saveCompraProducto (@ModelAttribute("compraProducto") CompraProducto compraProducto) {

        compraProductoDAO.saveCompraProducto(compraProducto);

        return "redirect:/compraProductos";
    }
/*
    @RequestMapping("/compraProductos/edit/{id}")
    public ModelAndView editCompraProductoForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/compraProducto/edit-compraProducto-form");
        CompraProducto compraProducto = compraProductoDAO.getCompraProducto(id);
        modelAndView.addObject("compraProducto", compraProducto);

        return modelAndView;
    }
*/
    @RequestMapping(value = "/compraProductos/update", method = RequestMethod.POST)
    public String updateCompraProducto(@ModelAttribute("compraProducto") CompraProducto compraProducto) {
        compraProductoDAO.updateCompraProducto(compraProducto);

        return "redirect:/compraProductos";
    }

    @RequestMapping("/compraProductos/delete/{id}")
    public String deleteCompraProducto(@PathVariable(name = "id") int id) {

        compraProductoDAO.deleteCompraProducto(id);

        return "redirect:/compraProductos";
    }

}
