/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author Franco
 */
public class Fabricante {
    private String nombre;
    private String ciudad;
    private int antiguedad;
    
    public Fabricante(String nombre, String ciudad, int antiguedad){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }
            
    public static boolean sonIguales(Fabricante f1, Fabricante f2){
        return f1.equals(f2);
    }
    
    private String getInfoFabricante(){
        StringBuilder sb = new StringBuilder("\nFabricante: " + this.getNombre() + "\n");
        sb.append("Ciudad: ").append(this.getCiudad()).append("\n");
        sb.append("Antiguedad: ").append(this.getAntiguedad()).append("\n");
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getInfoFabricante();
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public int getAntiguedad() {
        return this.antiguedad;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Fabricante other = (Fabricante) obj;
        if (this.antiguedad != other.antiguedad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.ciudad, other.ciudad);
    }
    
    
    
}
