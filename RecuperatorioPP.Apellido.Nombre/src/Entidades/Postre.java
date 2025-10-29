/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Franco
 */
public class Postre extends Producto implements IVendible {

    private TipoPostre tipo;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipo) {
        super(nombre, precio, fabricante);
        this.tipo = tipo;
    }

    public Postre(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante, TipoPostre tipo) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante), tipo);
    }

    @Override
    public double getPrecioTotal() {
        if (this.getTipo() == TipoPostre.TIRAMISU) {
            return super.getPrecio() * 1.20;
        } else if (this.getTipo() == TipoPostre.HELADO) {
            return super.getPrecio() * 1.15;
        } else {
            return super.getPrecio() * 1.10;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo: ").append(this.getTipo()).append("\n");
        sb.append("Precio total: ").append(this.getPrecioTotal()).append("\n");
        return sb.toString();
    }

    public TipoPostre getTipo() {
        return this.tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Postre other = (Postre) obj;
        return super.equals(other) && this.tipo == other.tipo;
    }

    
}
