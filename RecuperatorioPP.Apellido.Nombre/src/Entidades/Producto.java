/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Franco
 */
public abstract class Producto {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante));
    }

    static {
        Producto.generadorAleatorio = new Random();
    }

    public int getCalorias() {
        if (this.calorias == 0) {
            this.calorias = Producto.generadorAleatorio.nextInt(200, 801);
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = Producto.generadorAleatorio.nextInt(5, 21);
        }
        return this.tiempoPreparacion;
    }
    

    private static String mostrar(Producto producto) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Producto: ").append(producto.getNombre()).append("\n");
        sb.append("Fabricate: ").append(producto.getFabricante()).append("\n");
        sb.append("Precio: ").append(producto.getPrecio()).append("\n");
        sb.append("Tiempo de Preparacion: ").append(producto.getTiempoPreparacion()).append("\n");
        sb.append("Calorias: ").append(producto.getCalorias()).append("\n");
        

        return sb.toString();
    }
    
    
//   
//    private static boolean sonIguales(Producto p1, Producto p2){
//         if (p1 == p2) {
//            return true;
//        }
//        if (p1 == null) {
//            return false;
//        }
//        if (p1.getClass() != p2.getClass()) {
//            return false;
//        }
//        final Producto other = (Producto) p1;
//        final Producto otherProducto = (Producto) p2;
//        if (!Objects.equals(other.nombre, otherProducto.nombre)) {
//            return false;
//        }
//        return Objects.equals(otherProducto.fabricante, other.fabricante);
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.fabricante, other.fabricante);
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }

    
    
    
}
