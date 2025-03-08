<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <style>
    	@import url('https://fonts.googleapis.com/css?family=Poppins&display=swap');
		*{
		  margin: 0;
		  padding: 0;
		  font-family: 'Poppins',sans-serif;
		}
		body{
		  display: flex;
		  height: 100vh;
		  text-align: center;
		  align-items: center;
		  justify-content: center;
		  background: #151515;
		}
		.register-form{
		  position: relative;
		  width: 370px;
		  height: auto;
		  background: #1b1b1b;
		  padding: 40px 35px 60px;
		  box-sizing: border-box;
		  border: 1px solid black;
		  border-radius: 5px;
		  box-shadow: inset 0 0 1px #272727;
		}
		.text{
		  font-size: 30px;
		  color: #c7c7c7;
		  font-weight: 600;
		  letter-spacing: 2px;
		}
		form{
		  margin-top: 40px;
		}
		form .field{
		  margin-top: 20px;
		  display: flex;
		}
		.field input,form button{
		  height: 50px;
		  width: 100%;
		  outline: none;
		  font-size: 19px;
		  color: #868686;
		  padding: 0 15px;
		  border-radius: 0 5px 5px 0;
		  border: 1px solid #444;
		  caret-color: #339933;
		  background: linear-gradient(#333,#222);
		}
		input:focus{
		  color: #339933;
		  box-shadow: 0 0 5px rgba(0,255,0,.2),
		              inset 0 0 5px rgba(0,255,0,.1);
		  background: linear-gradient(#333933,#222922);
		  animation: glow .8s ease-out infinite alternate;
		}
		@keyframes glow {
		   0%{
		    border-color: #339933;
		    box-shadow: 0 0 5px rgba(0,255,0,.2),
		                inset 0 0 5px rgba(0,0,0,.1);
		  }
		   100%{
		    border-color: #6f6;
		    box-shadow: 0 0 20px rgba(0,255,0,.6),
		                inset 0 0 10px rgba(0,255,0,.4);
		  }
		}
		button{
		  margin-top: 30px;
		  border-radius: 5px!important;
		  font-weight: 600;
		  letter-spacing: 1px;
		  cursor: pointer;
		}
		button:hover{
		  color: #339933;
		  border: 1px solid #339933;
		  box-shadow: 0 0 5px rgba(0,255,0,.3),
		              0 0 10px rgba(0,255,0,.2),
		              0 0 15px rgba(0,255,0,.1),
		              0 2px 0 black;
		}
		.link{
		  margin-top: 25px;
		  color: #868686;
		}
		.link a{
		  color: #339933;
		  text-decoration: none;
		}
		.link a:hover{
		  text-decoration: underline;
		}
    </style>
</head>
<body>
    <!-- <h2>User Registration</h2>
    <form action="register" method="post">
        Username: <input type="text" name="username" required><br>
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <button type="submit">Register</button>
    </form>  
    <p>Already have an account? <a href="login">Login</a></p>    -->
    <div class="register-form">
         <div class="text">
            REGISTER
         </div>
         <form action="register" method="post">
         	<div class="field">
         		<input type="text" name="username" placeholder="Username" required>
         	</div>
            <div class="field">
                <input type="email" name="email" placeholder="Email">
            </div>
            <div class="field">
                <input type="password" name="password" placeholder="Password">
            </div>
            <button type="submit">REGISTER</button>
            <div class="link">
               Already have an account ? 
               <a href="login">Login</a>     
            </div>
         </form>
      </div>  
</body>
</html>
 