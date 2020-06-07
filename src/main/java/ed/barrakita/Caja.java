/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.barrakita;

import java.util.ArrayList;

/**
 *
 * @author andyloz
 */
public class Caja implements Item {
    private String nombre;
    private ArrayList<Producto> items;

    public Caja() {
        this.items = new ArrayList<>();
    }

    public Caja(String nombre, Producto... items) {
        this.nombre = nombre;
        this.items = new ArrayList<>();
        
        for (int i = 0; i < items.length; i++) {
            this.items.add(items[i]);
        }
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
                .reduce(Double::sum).orElse(0) - 2;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Producto> getItems() {
        return items;
    }
}
