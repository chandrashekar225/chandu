<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<style type="text/css">
* {box-sizing: border-box;}

/* Style the input container */
.input-container {
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

/* Style the form icons */
.icon {
  padding: 10px;
  background: dodgerblue;
  color: white;
  min-width: 50px;
  text-align: center;
}

/* Style the input fields */
.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
  background-color: dodgerblue;
  color: white;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}

</style>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<<script>
$(document).ready(function() {
	alert("hey jquery..");
	$('#email').on("input keyup",function() {
		alert("entered into function");
		var email=$('#email').val();
		$.post("ControlSignUpPage",{
			email:email
		},
		function(res){
			alert("entered into response function"+res);
			$('#iderror').text(res);
			if(res!=""){
				$('#email').val();
			}
		});
	});
});

</script> 
</head>
<body>
 <form action="" method="">
  <h2>Register Form</h2>
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="Username" name="user" required />
  </div>

  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text" placeholder="Email" name="email" required />
  </div>

  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="Password" name="psw" required />
  </div>

  <input type="submit"  value="Register"></input>
</form> 


</form>
</body>
</html>