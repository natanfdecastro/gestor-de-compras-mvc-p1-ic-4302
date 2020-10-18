package edu.ic4302.controller;


import java.util.List;

import edu.ic4302.DAO.ProductoDAO;
import edu.ic4302.DAO.ProveedorDAO;
import edu.ic4302.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import edu.ic4302.model.Proveedor;

@Controller
public class ProductoController {

    @Autowired
    private ProductoDAO productoDAO;

    @RequestMapping("/productos")
    public String viewProductos(Model model) {
        List<Producto> listProductos = productoDAO.listProductos();
        model.addAttribute("listProductos", listProductos);
        return "/producto/view-productos";
    }

    @RequestMapping("/productos/new")
    public String newProductoForm(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);

        return "/producto/new-producto-form";
    }

    @RequestMapping(value = "/productos/save", method = RequestMethod.POST)
    public String saveProducto (@ModelAttribute("producto") Producto producto) {

        productoDAO.saveProducto(producto);

        return "redirect:/productos";
    }

    @RequestMapping("/productos/edit/{id}")
    public ModelAndView editProductoForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/producto/edit-producto-form");
        Producto producto = productoDAO.getProducto(id);
        modelAndView.addObject("producto", producto);

        return modelAndView;
    }

    @RequestMapping(value = "/productos/update", method = RequestMethod.POST)
    public String updateProducto(@ModelAttribute("producto") Producto producto) {
        productoDAO.updateProducto(producto);

        return "redirect:/productos";
    }

    @RequestMapping("/productos/delete/{id}")
    public String deleteProducto(@PathVariable(name = "id") int id) {

        productoDAO.deleteProducto(id);

        return "redirect:/productos";
    }


}
