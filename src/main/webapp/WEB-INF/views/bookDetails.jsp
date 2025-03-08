<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.project.OnlineBookStore.models.Book" %>

<!DOCTYPE html>
<html>
<head>
    <title>Book Details</title>
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

        .details-container {
            background: #1e1e1e;
            width: 50%;
            margin: auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(255, 255, 255, 0.1);
            text-align: left;
        }

        p {
            font-size: 18px;
            margin: 10px 0;
            padding: 8px;
            border-bottom: 1px solid #333;
        }

        strong {
            color: #007BFF;
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
    <h1>Book Details</h1>
    <p><strong>Title:</strong> ${book.title}</p>
    <p><strong>Author:</strong> ${book.author}</p>
    <p><strong>Genre:</strong> ${book.genre}</p>
    <p><strong>Sub Genre:</strong> ${book.subGenre}</p>
    <p><strong>Height:</strong> ${book.height}</p>
    <p><strong>Price:</strong> ${book.price}</p>
    <p><strong>Publisher:</strong> ${book.publisher}</p>
    <a href="${pageContext.request.contextPath}/home">Back to Home</a>
</body>
</html>
  