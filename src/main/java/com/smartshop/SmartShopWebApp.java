package com.smartshop;

import io.javalin.Javalin;

public class SmartShopWebApp {

    public static void main(String[] args) {

        Javalin app = Javalin.create();

        app.get("/", ctx -> ctx.html("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>SmartShop</title>
                <meta charset="UTF-8">
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        max-width: 650px;
                        margin: 40px auto;
                        padding: 20px;
                        background: #f4f6f8;
                    }
                    section {
                        background: white;
                        padding: 24px;
                        margin: 18px 0;
                        border-radius: 10px;
                    }
                    input, button {
                        padding: 10px;
                        margin: 6px 0;
                        width: 95%;
                    }
                    button {
                        cursor: pointer;
                    }
                </style>
            </head>
            <body>
                <h1>SmartShop</h1>
                <p>Welcome to your SmartShop application!</p>

                <section>
                    <h2>Search Products</h2>
                    <form action="/search" method="get">
                        <input name="product" placeholder="Enter product name" required>
                        <button type="submit">Search</button>
                    </form>
                </section>

                <section>
                    <h2>Place an Order</h2>
                    <form action="/order" method="get">
                        <input name="product" placeholder="Product name" required>
                        <input name="quantity" type="number" min="1" placeholder="Quantity" required>
                        <input name="amount" type="number" min="0.01" step="0.01" placeholder="Total amount" required>
                        <input name="address" placeholder="Delivery address" required>
                        <input name="payment" placeholder="Payment method" required>
                        <button type="submit">Place Order</button>
                    </form>
                </section>

                <section>
                    <h2>Size Recommendation</h2>
                    <form action="/size" method="get">
                        <input name="height" type="number" step="any" placeholder="Height" required>
                        <input name="weight" type="number" step="any" placeholder="Weight" required>
                        <input name="chest" type="number" step="any" placeholder="Chest" required>
                        <input name="waist" type="number" step="any" placeholder="Waist" required>
                        <input name="hip" type="number" step="any" placeholder="Hip" required>
                        <button type="submit">Recommend Size</button>
                    </form>
                </section>
            </body>
            </html>
            """));

        Search search = new Search();
        PlaceOrder order = new PlaceOrder();
        SizeRecommendation size = new SizeRecommendation();

        app.get("/search", ctx -> {
            String product = ctx.queryParam("product");
            ctx.result(search.searchProduct(product));
        });

        app.get("/order", ctx -> {
            try {
                String result = order.placeOrder(
                    ctx.queryParam("product"),
                    Integer.parseInt(ctx.queryParam("quantity")),
                    Double.parseDouble(ctx.queryParam("amount")),
                    ctx.queryParam("address"),
                    ctx.queryParam("payment")
                );
                ctx.result(result);
            } catch (Exception e) {
                ctx.status(400).result("Please enter valid order details.");
            }
        });

        app.get("/size", ctx -> {
            try {
                String result = size.recommendSize(
                    Double.parseDouble(ctx.queryParam("height")),
                    Double.parseDouble(ctx.queryParam("weight")),
                    Double.parseDouble(ctx.queryParam("chest")),
                    Double.parseDouble(ctx.queryParam("waist")),
                    Double.parseDouble(ctx.queryParam("hip"))
                );
                ctx.result("Recommended size: " + result);
            } catch (Exception e) {
                ctx.status(400).result("Please enter valid measurements.");
            }
        });

        app.start("0.0.0.0", 8081);
        System.out.println("SmartShop is running at http://localhost:8081");
    }
}