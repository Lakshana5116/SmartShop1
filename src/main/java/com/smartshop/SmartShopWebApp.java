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
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <style>
                    * {
                        box-sizing: border-box;
                        margin: 0;
                        padding: 0;
                    }

                    body {
                        font-family: Arial, Helvetica, sans-serif;
                        background: linear-gradient(135deg, #eef2ff, #f8f5ff, #eaf8ff);
                        color: #20243a;
                        min-height: 100vh;
                    }

                    /* NAVBAR */
                    nav {
                        background: linear-gradient(90deg, #312e81, #6d28d9, #2563eb);
                        color: white;
                        padding: 18px 8%;
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        box-shadow: 0 4px 18px rgba(0,0,0,0.15);
                    }

                    .logo {
                        font-size: 25px;
                        font-weight: bold;
                        letter-spacing: 0.5px;
                    }

                    .nav-links {
                        display: flex;
                        gap: 28px;
                        font-size: 14px;
                    }

                    .nav-links span {
                        cursor: pointer;
                    }

                    /* HERO */
                    .hero {
                        max-width: 1100px;
                        margin: 35px auto 20px;
                        padding: 45px;
                        border-radius: 24px;
                        background: linear-gradient(135deg, #4338ca, #7c3aed, #2563eb);
                        color: white;
                        box-shadow: 0 12px 35px rgba(67,56,202,0.25);
                        position: relative;
                        overflow: hidden;
                    }

                    .hero::after {
                        content: "🛍️";
                        position: absolute;
                        right: 55px;
                        top: 35px;
                        font-size: 90px;
                        opacity: 0.15;
                    }

                    .hero h1 {
                        font-size: 42px;
                        margin-bottom: 12px;
                    }

                    .hero p {
                        font-size: 17px;
                        opacity: 0.92;
                        max-width: 600px;
                        line-height: 1.6;
                    }

                    .hero-button {
                        display: inline-block;
                        margin-top: 24px;
                        padding: 12px 25px;
                        background: white;
                        color: #4f46e5;
                        border-radius: 25px;
                        text-decoration: none;
                        font-weight: bold;
                    }

                    /* MAIN */
                    .container {
                        max-width: 1100px;
                        margin: 25px auto 50px;
                        padding: 0 20px;
                    }

                    .section-title {
                        text-align: center;
                        margin: 35px 0 22px;
                    }

                    .section-title h2 {
                        font-size: 27px;
                        color: #312e81;
                    }

                    .section-title p {
                        margin-top: 7px;
                        color: #6b7280;
                    }

                    /* CARDS */
                    .grid {
                        display: grid;
                        grid-template-columns: repeat(3, 1fr);
                        gap: 20px;
                    }

                    .card {
                        background: rgba(255,255,255,0.95);
                        padding: 28px;
                        border-radius: 18px;
                        box-shadow: 0 7px 25px rgba(31,41,55,0.09);
                        border: 1px solid rgba(99,102,241,0.12);
                        transition: 0.25s;
                    }

                    .card:hover {
                        transform: translateY(-5px);
                        box-shadow: 0 12px 30px rgba(31,41,55,0.14);
                    }

                    .icon {
                        width: 52px;
                        height: 52px;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        border-radius: 15px;
                        font-size: 25px;
                        margin-bottom: 17px;
                        background: #ede9fe;
                    }

                    .card h3 {
                        color: #312e81;
                        margin-bottom: 8px;
                        font-size: 21px;
                    }

                    .card p {
                        color: #6b7280;
                        line-height: 1.5;
                        font-size: 14px;
                        margin-bottom: 18px;
                    }

                    /* FORMS */
                    .form-card {
                        background: white;
                        padding: 30px;
                        border-radius: 20px;
                        box-shadow: 0 7px 25px rgba(31,41,55,0.09);
                        margin-bottom: 25px;
                    }

                    .form-card h2 {
                        color: #312e81;
                        margin-bottom: 7px;
                    }

                    .form-card .subtitle {
                        color: #6b7280;
                        margin-bottom: 22px;
                        font-size: 14px;
                    }

                    .form-grid {
                        display: grid;
                        grid-template-columns: repeat(2, 1fr);
                        gap: 15px;
                    }

                    input {
                        width: 100%;
                        padding: 13px 15px;
                        border: 1px solid #d1d5db;
                        border-radius: 10px;
                        outline: none;
                        font-size: 14px;
                        background: #fafafa;
                    }

                    input:focus {
                        border-color: #6366f1;
                        box-shadow: 0 0 0 3px rgba(99,102,241,0.12);
                        background: white;
                    }

                    button {
                        border: none;
                        padding: 13px 22px;
                        border-radius: 10px;
                        background: linear-gradient(90deg, #4f46e5, #7c3aed);
                        color: white;
                        font-weight: bold;
                        cursor: pointer;
                        font-size: 14px;
                        transition: 0.2s;
                    }

                    button:hover {
                        transform: translateY(-2px);
                        box-shadow: 0 6px 15px rgba(79,70,229,0.3);
                    }

                    .full-button {
                        width: 100%;
                        margin-top: 18px;
                    }

                    /* FEATURES */
                    .features {
                        display: grid;
                        grid-template-columns: repeat(3, 1fr);
                        gap: 18px;
                        margin-top: 20px;
                    }

                    .feature {
                        background: white;
                        padding: 22px;
                        border-radius: 16px;
                        text-align: center;
                        box-shadow: 0 5px 20px rgba(0,0,0,0.07);
                    }

                    .feature-icon {
                        font-size: 30px;
                        margin-bottom: 10px;
                    }

                    .feature h3 {
                        color: #312e81;
                        font-size: 17px;
                        margin-bottom: 6px;
                    }

                    .feature p {
                        color: #6b7280;
                        font-size: 13px;
                    }

                    /* FOOTER */
                    footer {
                        margin-top: 45px;
                        background: #1e1b4b;
                        color: white;
                        text-align: center;
                        padding: 25px;
                    }

                    footer p {
                        opacity: 0.75;
                        font-size: 13px;
                    }

                    /* RESPONSIVE */
                    @media (max-width: 800px) {
                        .grid,
                        .features {
                            grid-template-columns: 1fr;
                        }

                        .form-grid {
                            grid-template-columns: 1fr;
                        }

                        .hero {
                            margin: 20px;
                            padding: 30px;
                        }

                        .hero h1 {
                            font-size: 32px;
                        }

                        .nav-links {
                            gap: 12px;
                        }
                    }
                </style>
            </head>

            <body>

                <nav>
                    <div class="logo">🛍️ SmartShop</div>

                    <div class="nav-links">
                        <span>Home</span>
                        <span>Products</span>
                        <span>Orders</span>
                        <span>About</span>
                    </div>
                </nav>

                <div class="hero">
                    <h1>Shop Smart. Shop Easy.</h1>
                    <p>
                        Welcome to SmartShop — a simple and user-friendly
                        online shopping application for searching products,
                        placing orders and getting personalized size recommendations.
                    </p>

                    <a href="#products" class="hero-button">Explore SmartShop →</a>
                </div>

                <div class="container">

                    <div class="section-title" id="products">
                        <h2>What would you like to do?</h2>
                        <p>Choose a service below to get started</p>
                    </div>

                    <div class="grid">

                        <div class="card">
                            <div class="icon">🔎</div>
                            <h3>Search Products</h3>
                            <p>
                                Quickly find the product you are looking for
                                using our simple search feature.
                            </p>

                            <form action="/search" method="get">
                                <input
                                    name="product"
                                    placeholder="Enter product name"
                                    required>
                                <button class="full-button" type="submit">
                                    Search Product
                                </button>
                            </form>
                        </div>

                        <div class="card">
                            <div class="icon">🛒</div>
                            <h3>Place an Order</h3>
                            <p>
                                Enter your product and delivery details
                                to place an order easily.
                            </p>

                            <form action="/order" method="get">

                                <input
                                    name="product"
                                    placeholder="Product name"
                                    required>

                                <br><br>

                                <input
                                    name="quantity"
                                    type="number"
                                    min="1"
                                    placeholder="Quantity"
                                    required>

                                <br><br>

                                <input
                                    name="amount"
                                    type="number"
                                    min="0.01"
                                    step="0.01"
                                    placeholder="Total amount"
                                    required>

                                <br><br>

                                <input
                                    name="address"
                                    placeholder="Delivery address"
                                    required>

                                <br><br>

                                <input
                                    name="payment"
                                    placeholder="Payment method"
                                    required>

                                <button class="full-button" type="submit">
                                    Place Order
                                </button>

                            </form>
                        </div>

                        <div class="card">
                            <div class="icon">📏</div>
                            <h3>Size Recommendation</h3>
                            <p>
                                Enter your body measurements and receive
                                a recommended clothing size.
                            </p>

                            <form action="/size" method="get">

                                <input
                                    name="height"
                                    type="number"
                                    step="any"
                                    placeholder="Height"
                                    required>

                                <br><br>

                                <input
                                    name="weight"
                                    type="number"
                                    step="any"
                                    placeholder="Weight"
                                    required>

                                <br><br>

                                <input
                                    name="chest"
                                    type="number"
                                    step="any"
                                    placeholder="Chest"
                                    required>

                                <br><br>

                                <input
                                    name="waist"
                                    type="number"
                                    step="any"
                                    placeholder="Waist"
                                    required>

                                <br><br>

                                <input
                                    name="hip"
                                    type="number"
                                    step="any"
                                    placeholder="Hip"
                                    required>

                                <button class="full-button" type="submit">
                                    Recommend Size
                                </button>

                            </form>
                        </div>

                    </div>

                    <div class="section-title">
                        <h2>Why Choose SmartShop?</h2>
                        <p>Designed to make online shopping simple</p>
                    </div>

                    <div class="features">

                        <div class="feature">
                            <div class="feature-icon">⚡</div>
                            <h3>Fast & Simple</h3>
                            <p>Quick product search and easy ordering.</p>
                        </div>

                        <div class="feature">
                            <div class="feature-icon">🔒</div>
                            <h3>Easy to Use</h3>
                            <p>A clean and user-friendly shopping interface.</p>
                        </div>

                        <div class="feature">
                            <div class="feature-icon">🎯</div>
                            <h3>Smart Recommendation</h3>
                            <p>Get a size recommendation using measurements.</p>
                        </div>

                    </div>

                </div>

                <footer>
                    <h3>🛍️ SmartShop</h3>
                    <p>Smart shopping made simple.</p>
                </footer>

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