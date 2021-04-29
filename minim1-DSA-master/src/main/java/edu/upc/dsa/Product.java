package edu.upc.dsa;

public class Product {
   private String nombre_producto;
   double precio;
   private int ventas=0;

   public String getNombre_producto() {
      return nombre_producto;
   }

   public void setNombre_producto(String nombre_producto) {
      this.nombre_producto = nombre_producto;
   }

   public double getPrecio() {
      return precio;
   }

   public void setPrecio (double precio)
   {
      this.precio=precio;
   }

   public int getVentas() {
      return ventas;
   }

   public void setVentas(int ventas) {
      this.ventas = ventas;
   }



   public Product(String nombre_producto, double precio){
      this.nombre_producto = nombre_producto;
      this.precio = precio;
   }

   public void addVenta()
   {
      this.ventas++;
   }

   public String toString() {
      return nombre_producto + " " + precio;
   }



}
