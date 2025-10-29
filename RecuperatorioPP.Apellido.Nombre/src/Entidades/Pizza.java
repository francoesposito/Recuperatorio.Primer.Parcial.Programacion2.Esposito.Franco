/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Franco
 */
public class Pizza extends Producto implements IVendible {
    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    public Pizza(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante,  TipoPizza sabor, TamanoPizza tamano) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante), sabor, tamano);
    }
    
    @Override
    public double getPrecioTotal(){
        if (this.getTamano() == TamanoPizza.CHICA){
            return super.getPrecio() * 1.05;
        } else if (this.getTamano() == TamanoPizza.MEDIANA){
            return super.getPrecio() * 1.10;
        } else {
            return super.getPrecio() * 1.20;
        }
        
    }

    public TipoPizza getSabor() {
        return this.sabor;
    }

    public TamanoPizza getTamano() {
        return this.tamano;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tamano: ").append(this.getTamano()).append("\n");
        sb.append("Sabor: ").append(this.getSabor()).append("\n");
        sb.append("Precio total: ").append(this.getPrecioTotal()).append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Pizza other = (Pizza) obj;
        if (this.sabor != other.sabor) {
            return false;
        }
        return super.equals(other) && this.tamano == other.tamano;
    }
    
    
    
    
    
    
}
