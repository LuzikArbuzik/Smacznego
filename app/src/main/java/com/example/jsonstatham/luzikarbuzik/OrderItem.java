package com.example.jsonstatham.luzikarbuzik;

class OrderItem {

    private String name;
    private int quantity;

    private OrderItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    static OrderItem decode(String orderItem) {
        String[] parts = orderItem.split(" ");
        String foodName = parts[3];
        for(int s = 4; s < parts.length; s++) {
            foodName += " " + parts[s];
        }
        return new OrderItem(foodName + " " + parts[2], Integer.parseInt(parts[0]));
    }

    public String getName() {
        return name;
    }

    int getQuantity() {
        return quantity;
    }

}


