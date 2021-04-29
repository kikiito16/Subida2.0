package edu.upc.dsa;


/*import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;*/

import java.util.*;
import java.util.logging.Logger;


public class ProductManagerImpl implements ProductManager {

    HashMap<String, User> users;

    Queue<Order> pendingOrders = new LinkedList<>();
    List<Product> productList=new ArrayList<>();
    HashMap<String, User> hmUsers=new HashMap<String, User>();
    final static Logger logger = Logger.getLogger(String.valueOf(ProductManagerImpl.class));
    int cont=0;

    private static ProductManager instance;


    public ProductManagerImpl(){

        this.productList = new LinkedList<>();

    }

    public List<Product> getProductByPrize() {
        //Arrays.sort();
        Collections.sort(this.productList, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.precio,o1.precio);
            }
        });
        return this.productList;
    }

    @Override
    public void newOrder(Order o) {
        User user= hmUsers.get(o.getUserName());
        if (user ==null)
                System.out.println("Usuari:"+ o.getUserName() + "no existeix.");
        user.addOrder(o);
        pendingOrders.add(o);

        o.setId(cont);
        cont++;
    }

    @Override
    public Order processOrder()
    {
        Order o =pendingOrders.remove();
        User user = hmUsers.get(o.getUserName());
        user.addOrderDone(o);

        List <String> p =o.getProductNames();
        for (int i=0;i<p.size();i++)
        {
            for (int j=0;j<productList.size();j++)
            {
                if (p.get(i)==productList.get(j).getNombre_producto())
                    productList.get(j).addVenta();
            }
        }

        return o;
    }

    @Override
    public List<Order> getOrdersByUser(String idUser)
    {
        return hmUsers.get(idUser).getOrdersDone();

    }

    @Override
    public List<Product> getProductBySales() {
        Collections.sort(this.productList, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getVentas(),o1.getVentas());
            }
        });
        return this.productList;
    }

    @Override
    public void productonuevo(String nombre_producto, double precio) {
        Product p = new Product(nombre_producto,precio);
        this.productList.add(p);
    }

    @Override
    public void clear() {
        productList.clear();
        hmUsers.clear();
        pendingOrders.clear();
    }

    @Override
    public User getUser(String ID_usuario) {
        return hmUsers.get(ID_usuario);
    }

    @Override
    public Product getProduct(String productName) {
        return null;
    }

    @Override
    public void addProduct(Product p) {
        productList.add(p);
    }

    @Override
    public void addUser(User user) {
        hmUsers.put(user.getID(),user);
    }

    public static ProductManager getInstance()
    {
        if (instance==null) instance= new ProductManagerImpl();
        return instance;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public static void main (String [] args){

    }

}


