<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.project.OnlineBookStore.models.Order" %>
<%@ page import="com.project.OnlineBookStore.models.OrderItem" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
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

        h1, h2 {
            color: #ffffff;
        }

        table {
            width: 80%;
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

        p {
            font-size: 18px;
            color: #ccc;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            padding: 10px 20px;
            display: inline-block;
            margin-top: 20px;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>     
</head>
<body>
    <h1>Order Confirmation</h1>

    <%
        Order order = (Order) request.getAttribute("order");
        if (order != null) {
    %>
        <p><strong>Order ID:</strong> <%= order.getId() %></p>
        <p><strong>Order Date:</strong> <%= order.getOrderDate() %></p>
        <p><strong>Total Price:</strong> $<%= order.getTotalPrice() %></p>
        <p><strong>Status:</strong> <%= order.getStatus() %></p>

        <h2>Order Items</h2>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <%
                List<OrderItem> orderItems = order.getOrderItems();
                for (OrderItem item : orderItems) {
            %>
            <tr>
                <td><%= item.getBook().getTitle() %></td>
                <td><%= item.getQuantity() %></td>
                <td>$<%= item.getPrice() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>Order details not found.</p>
    <%
        }
    %>

    <a href="<%= request.getContextPath() %>/home">Back to Home</a>
</body>
</html>
 