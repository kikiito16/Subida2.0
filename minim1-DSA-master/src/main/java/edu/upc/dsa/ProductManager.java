package edu.upc.dsa;

import java.util.List;

public interface ProductManager {

    public List<Product> getProductByPrize();
    public void newOrder(Order o);
    public Order processOrder();
    public List<Order> getOrdersByUser(String idUser);
    public List<Product> getProductBySales();
    public void productonuevo(String nombre_producto, double precio);
    public void clear();
    public User getUser(String ID_usuario);
    public Product getProduct(String productName);
    public void addProduct(Product p);
    public void addUser(User user);

}