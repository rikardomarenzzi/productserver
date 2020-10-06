package de.neuefische.productserver.service;

import de.neuefische.productserver.db.OrderDb;
import de.neuefische.productserver.db.ProductDB;
import de.neuefische.productserver.model.Order;
import de.neuefische.productserver.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private ProductDB productDb;
    private OrderDb orderDb;

    public OrderService(ProductDB productDb, OrderDb orderDb) {
        this.productDb = productDb;
        this.orderDb = orderDb;
    }

    public List<Order> orderList() {
        return orderDb.listOrder();
    }

    public Order placeOrder(List<Product> products) {

        if(!productDb.containsAll(products)) {
            return null;
        }
        return orderDb.placeOrder(products);
    }
}
