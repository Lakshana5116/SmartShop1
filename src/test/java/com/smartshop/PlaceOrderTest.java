package com.smartshop;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlaceOrderTest {

    @Test
    public void testPlaceOrder() {

        PlaceOrder order = new PlaceOrder();

        assertEquals(
                "Order Placed Successfully! Payment Completed. Order ID: SB10025",
                order.placeOrder(
                        "Wireless Earbuds",
                        1,
                        999.0,
                        "Chennai",
                        "UPI"
                )
        );
    }

    @Test
    public void testInvalidQuantity() {

        PlaceOrder order = new PlaceOrder();

        assertEquals(
                "Invalid quantity",
                order.placeOrder(
                        "Wireless Earbuds",
                        0,
                        999.0,
                        "Chennai",
                        "UPI"
                )
        );
    }
}