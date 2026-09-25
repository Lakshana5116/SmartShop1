package com.smartshop;

public class Search {

    public String searchProduct(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            return "Please enter a product name";
        }

        return "Searching for: " + productName;
    }
}