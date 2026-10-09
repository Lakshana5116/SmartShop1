package com.smartshop;

import javax.swing.*;
import java.awt.*;

public class SmartShopApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("SmartShop");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel(
                "SMARTSHOP",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        panel.add(title, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton loginButton =
                new JButton("Login");

        JButton searchButton =
                new JButton("Search Product");

        JButton sizeButton =
                new JButton("Size Recommendation");

        JButton orderButton =
                new JButton("Place Order");

        buttonPanel.add(loginButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(sizeButton);
        buttonPanel.add(orderButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Information area
        JTextArea output = new JTextArea();

        output.setEditable(false);

        output.setText(
                "Welcome to SmartShop\n\n" +
                "AI Powered Intelligent Online Shopping"
        );

        panel.add(
                new JScrollPane(output),
                BorderLayout.SOUTH
        );

        // LOGIN BUTTON
        loginButton.addActionListener(e -> {

            String username =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Username:"
                    );

            String password =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Password:"
                    );

            Login login = new Login();

            if (login.checkLogin(username, password)) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Login Successful!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Username or Password"
                );
            }
        });

        // SEARCH BUTTON
        searchButton.addActionListener(e -> {

            String product =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Product Name:"
                    );

            Search search = new Search();

            String result =
                    search.searchProduct(product);

            output.setText(result);
        });

        // SIZE BUTTON
        sizeButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Size Recommendation\n\n" +
                    "Use the existing SizeRecommendation class."
            );
        });

        // ORDER BUTTON
        orderButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Place Order\n\n" +
                    "Use the existing PlaceOrder class."
            );
        });

        frame.add(panel);

        frame.setVisible(true);
    }
}