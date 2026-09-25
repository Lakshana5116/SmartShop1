package com.smartshop;

public class PlaceOrder {

    public String placeOrder(String product, int quantity, double totalAmount,
                             String address, String paymentMethod) {

        if (product == null || product.trim().isEmpty()) {
            return "Product is required";
        }

        if (quantity <= 0) {
            return "Invalid quantity";
        }

        if (totalAmount <= 0) {
            return "Invalid total amount";
        }

        if (address == null || address.trim().isEmpty()) {
            return "Delivery address is required";
        }

        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            return "Payment method is required";
        }

        return "Order Placed Successfully! Payment Completed. Order ID: SB10025";
    }
}