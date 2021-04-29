package edu.upc.dsa;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List <String> productNames = new ArrayList<String>();
    private String userName;
    private int id=0;

    public Order(String user)
    {
        this.userName=user;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProduct (String productName)
    {
        productNames.add(productName);
    }



}