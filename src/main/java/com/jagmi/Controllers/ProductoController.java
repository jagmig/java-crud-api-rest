package com.jagmi.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagmi.Entities.Producto;
import com.jagmi.Repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/obtener")
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/obtenerPorId/{id}")
    public Producto obtenerporId(@PathVariable Long id){

        return productoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El id no existe"));
    }

    @PostMapping("/add")
    public Producto createProduct(@RequestBody Producto producto) {
                
        return productoRepository.save(producto);
    }

    @PutMapping("update/{id}")
    public Producto updateProduct(@PathVariable Long id, @RequestBody Producto producto) {
        
        Producto producto2 = productoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El id no existe"));
        producto2.setName(producto.getName());
        producto2.setPrice(producto.getPrice());
        producto2.setDescription(producto.getDescription());

        return productoRepository.save(producto2);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){

        Producto producto = productoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El id no existe"));

        productoRepository.delete(producto);
        
        System.out.println("El producto se ha eliminado");
    }



    

    

}
