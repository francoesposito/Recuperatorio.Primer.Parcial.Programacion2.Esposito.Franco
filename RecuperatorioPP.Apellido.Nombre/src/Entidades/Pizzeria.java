/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Franco
 */
public class Pizzeria implements Iterable<Producto> {

    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Pizzeria(String nombre, int capacidad) {
        this(nombre);
        this.capacidad = capacidad;
    }

    private boolean sonIguales(Producto p1) {

        for (Producto producto : productos) {
            if (p1.equals(producto)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(Producto p1) {
        if (!this.sonIguales(p1) && this.capacidad > this.productos.size()) {
            this.productos.add(p1);
            System.out.println("Se agrego el producto");
        } else {
            System.out.println("No se pudo agregar el producto");
        }

    }

    private double getPrecioProductos(TipoProducto tipoProducto) {

        double suma = 0;

        for (Producto producto : productos) {
            if (tipoProducto == TipoProducto.PIZZAS && producto instanceof Pizza pizza) {
                suma += pizza.getPrecioTotal();
            } else if (tipoProducto == TipoProducto.POSTRES && producto instanceof Postre postre) {
                suma += postre.getPrecioTotal();
            } else if (tipoProducto == TipoProducto.TODOS) {
                if (producto instanceof Postre postre2) {
                    suma += postre2.getPrecioTotal();
                }

                if (producto instanceof Pizza pizza2) {
                    suma += pizza2.getPrecioTotal();
                }
            }
        }

        return suma;

    }

    @Override
    public Iterator<Producto> iterator() {
        
        int indice = 0;
        
        return (Iterator<Producto>) this;
    }

    private double getPrecioDePizzas() {
        return this.getPrecioProductos(TipoProducto.PIZZAS);
    }

    private double getPrecioDePostres() {
        return this.getPrecioProductos(TipoProducto.POSTRES);
    }

    private double getPrecioTotal() {
        return this.getPrecioProductos(TipoProducto.TODOS);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizzeria: ").append(this.getNombre()).append("\n");
        sb.append("Capacidad: ").append(this.getCapacidad()).append("\n");
        sb.append("Productos: ").append("\n");
        for (Producto producto : productos) {
            sb.append(producto).append("\n");
        }
        sb.append("Precio total pizzas: ").append(this.getPrecioDePizzas()).append("\n");
        sb.append("Precio total postres: ").append(this.getPrecioDePostres()).append("\n");
        sb.append("Precio total: ").append(this.getPrecioTotal()).append("\n");
        return sb.toString();
    }

}
