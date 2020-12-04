package com.jeffcar.equals;

/**
 * @author JeffCar
 * @date 11/22/2020 - 12:17 PM
 */
public class Order {

    private int orderId;
    private String orderName;

    public Order(){

    }

    public Order(int orderId, String orderName){
        this.orderId = orderId;
        this.orderName = orderName;

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj instanceof Order){
            Order order =(Order) obj;
            return this.orderId==order.orderId &&
                    this.orderName.equals(order.orderName);

        }
        return false;
    }
}
