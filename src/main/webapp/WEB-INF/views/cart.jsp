<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.OnlineBookStore.models.Cart" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
    	@import url('https://fonts.googleapis.com/css?family=Poppins&display=swap');
        body {
            font-family: 'Poppins', sans-serif;     
            background-color: #121212;
            color: #ffffff;
            text-align: center;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #ffffff;
        }

        table {
            width: 70%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #1e1e1e;
            box-shadow: 0px 4px 8px rgba(255, 255, 255, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            border: 1px solid #333;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #222;
        }

        tr:hover {
            background-color: #333;
        }

        button {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            margin: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }

        form {
            display: inline-block;
        }
    </style>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    
    <table border="1">
        <tr>
            <th>Book</th>
            <th>Quantity</th>
        </tr>
        <%
            List<Cart> cartItems = (List<Cart>) request.getAttribute("cartItems");
            if (cartItems != null && !cartItems.isEmpty()) {
                for (Cart item : cartItems) {
        %>
        <tr>
            <td><%= item.getBook().getTitle() %></td>
            <td><%= item.getQuantity() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2">Your cart is empty.</td>
        </tr>
        <%
            }
        %>
    </table>

    <form action="clear" method="post">
        <button type="submit">Clear Cart</button>
    </form>
    <form action="/order/place" method="post">
    	<button type="submit">Place Order</button> 
    </form>
</body>
</html>
 