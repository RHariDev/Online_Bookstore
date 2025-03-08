<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.OnlineBookStore.models.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Bookstore</title>
    <style>
    	@import url('https://fonts.googleapis.com/css?family=Poppins&display=swap');
        body {
            font-family: 'Poppins',sans-serif;
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
            width: 90%;
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

        button, a {
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            padding: 8px 15px;
            display: inline-block;
            margin: 10px 5px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
        }

        button:hover, a:hover {
            background-color: #0056b3;
        }

        input[type="number"] {
            width: 50px;
            text-align: center;
            padding: 5px;
            border: 1px solid #007BFF;
            border-radius: 5px;
            background: #1e1e1e;
            color: white;
        }

        .actions {
            display: flex;
            justify-content: center;
            gap: 10px;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Online Bookstore</h1>
    
    <h2>Available Books</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Publisher</th>
            <th>Price</th>
            <th colspan="2">Actions</th>
        </tr>
        <%
            List<Book> books = (List<Book>) request.getAttribute("books");
            if (books != null) {
                for (Book book : books) {
        %>
        <tr>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getGenre() %></td>
            <td><%= book.getPublisher() %></td>
            <td><%= book.getPrice() %></td>
            <td><a href="books/<%= book.getId() %>">View Details</a></td>
            <td>
            	<form action="cart/add" method="post">
            		<input type="hidden" name="bookId" value="<%= book.getId() %>">
            		<input type="number" name="quantity" value="1" min="1" required>
            		<button type="submit">Add to Cart</button>
            	</form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">No books available</td>
        </tr>
        <%
            }
        %>
    </table>  
    <a href="cart/view">Go to Cart</a>
    <a href="orders">View Order History</a> 
</body>
</html>
 