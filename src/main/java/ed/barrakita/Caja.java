/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.barrakita;

import java.util.ArrayList;
import java.util.List;

/**
 * Container de productos
 * @author andyloz
 */
public class Caja implements Item {
    private String nombre;
    private ArrayList<Producto> productos;
    private double descuento;

    /**
     * Construye una Caja personalizada y sin descuento
     */
    public Caja() {
        this.nombre = "Personalizada";
        this.productos = new ArrayList<>();
        this.descuento = 0;
    }

    /**
     * Construye una Caja totalmente formada y con descuento. Se destina a
     * cajas premontadas
     * @param nombre Nombre de la caja
     * @param productos Los productos que contendra la caja
     */
    public Caja(String nombre, Producto... productos) {
        this.nombre = nombre;
        this.descuento = 2;
        
        this.productos = new ArrayList<>();
        for (int i = 0; i < productos.length; i++) {
            this.productos.add(productos[i]);
        }
    }
    
    public List<Producto> getProductos() {
        return this.productos;
    }
    
    /**
     * Añade un producto a la caja
     * @param producto El producto a añadir
     */
    public void add(Producto producto) {
        this.productos.add(producto);
    }
    
    /**
     * Elimina un producto de la caja
     * @param producto El producto a eliminar
     */
    public void remove(Producto producto) {
        this.productos.remove(producto);
    }
    
    /**
     * Obtiene el precio de cada uno de los productos que contiene la caja,
     * aplicando ademas el descuento de la caja
     * @return El precio total de la caja
     */
    @Override
    public double getPrecio() {
        return this.productos.stream()
                .mapToDouble(p -> p.getPrecio())
                .reduce(Double::sum).orElse(0) - this.descuento;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve los productos contenidos en la Caja
     * @return Un List de productos
     */
    public ArrayList<Producto> getItems() {
        return productos;
    }

    public double getDescuento() {
        return descuento;
    }
}
