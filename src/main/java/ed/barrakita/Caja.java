/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.barrakita;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andyloz
 */
public class Caja implements Item {
    private String nombre;
    private ArrayList<Producto> items;
    private double descuento;

    public Caja() {
        this.nombre = "Personalizada";
        this.items = new ArrayList<>();
        this.descuento = 0;
    }

    public Caja(String nombre, Producto... items) {
        this.nombre = nombre;
        this.descuento = 2;
        
        this.items = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            this.items.add(items[i]);
        }
    }
    
    public List<Producto> getProductos() {
        return this.items;
    }
    
    public void add(Producto item) {
        this.items.add(item);
    }
    
    public void remove(Producto item) {
        this.items.remove(item);
    }
    
    @Override
    public double getPrecio() {
        return this.items.stream()
                .mapToDouble(p -> p.getPrecio())
                .reduce(Double::sum).orElse(0) - this.descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Producto> getItems() {
        return items;
    }

    public double getDescuento() {
        return descuento;
    }
}
