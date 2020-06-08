/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.barrakita;

/**
 * Objetos a almacenar en Cajas
 * @author andyloz
 * @see Caja
 */
public class Producto implements Item, Cloneable {
    private String nombre;
    private double precio;

    /**
     * Construye un producto totalmente formado
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    protected Producto clone() {
        return new Producto(this.nombre, this.precio);
    }
}
