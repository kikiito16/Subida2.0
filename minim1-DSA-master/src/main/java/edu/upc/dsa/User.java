package edu.upc.dsa;

import java.util.ArrayList;
import java.util.List;

public class User {

    private  String ID_usu;
    private int ordenes_acabadas;
    private List<Order> orders_done= new ArrayList <Order>();
    public List<Order> orders = new ArrayList <Order>();

    public int getOrdenes_acabadas() {
        return ordenes_acabadas;
    }

    public void setOrdenes_acabadas(int ordenes_acabadas) {
        this.ordenes_acabadas = ordenes_acabadas;
    }

    public User(String nombre)
    {
        this.ID_usu=nombre;
    }

    public void addOrder (Order order)
    {
        orders.add(order);
    }

    public void addOrderDone (Order order)
    {
        ordenes_acabadas++;
        orders_done.add(order);
    }

    public List<Order> getListOrders()
    {
        return orders;
    }

    public void setListOrders (List <Order> orders)
    {
        this.orders=orders;
    }

    public String getID()
    {
        return ID_usu;
    }

    public void setID_usu (String ID)
    {
        this.ID_usu=ID;
    }

    public List<Order> getOrdersDone() {
        return orders_done;
    }

    public void setListOrdersDone (List <Order> ordersDone)
    {
        this.orders_done=ordersDone;
    }
/*
    public List toChar{
        return this.orders_done;
    }*/

}
