<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.project.OnlineBookStore.models.Order" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
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
            color: #bbb;
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
    <h1>Order History</h1>

    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        if (orders != null && !orders.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Total Price</th>
                <th>Status</th>
            </tr>
            <%
                for (Order order : orders) {
            %>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getOrderDate() %></td>
                <td>$<%= order.getTotalPrice() %></td>
                <td><%= order.getStatus() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>You have not placed any orders yet.</p>
    <%
        }
    %>

    <a href="<%= request.getContextPath() %>/home">Back to Home</a>
</body>
</html>
 