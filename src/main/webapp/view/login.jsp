<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    
	<div class="section">
		<div class="container">
			<div class="row full-height justify-content-center">
				<div class="col-12 text-center align-self-center py-5">
					<div class="section pb-5 pt-5 pt-sm-2 text-center">
						<h6 class="mb-0 pb-3"><span>Entrar </span><span>Cadastrar</span></h6>
			          	<input class="checkbox" type="checkbox" id="reg-log" name="reg-log"/>
			          	<label for="reg-log"></label>
						<div class="card-3d-wrap mx-auto">
							<div class="card-3d-wrapper">
								<div class="card-front">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3">Entrar</h4>
											<div class="form-group">
												<input type="email" name="logemail" class="form-style" placeholder="Seu Usuario" id="logUser" autocomplete="off">
												<i class="input-icon uil uil-at"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="logpass" class="form-style" placeholder="Sua Senha" id="logpass" autocomplete="off">
												<i class="input-icon uil uil-lock-alt"></i>
											</div>
											<a id="login" class="btn mt-4">Entrar</a>
				      					</div>
			      					</div>
			      				</div>
								<div class="card-back">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3">Cadastrar</h4>
											<div class="form-group">
												<input type="text" name="logname" class="form-style" placeholder="Seu nome" id="cName" autocomplete="off">
												<i class="input-icon uil uil-user"></i>
											</div>
											<div class="form-group mt-2">
												<input type="text" name="username" class="form-style" placeholder="Username" id="cUser" autocomplete="off">
												<i class="input-icon uil uil-user"></i>
											</div>
											<div class="form-group mt-2">
												<input type="email" name="logemail" class="form-style" placeholder="Seu Email" id="cEmail" autocomplete="off">
												<i class="input-icon uil uil-at"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="logpass" class="form-style" placeholder="Sua senha" id="cPass" autocomplete="off">
												<i class="input-icon uil uil-lock-alt"></i>
											</div>
											<a id="cadastrar" class="btn mt-4">Criar conta</a>
				      					</div>
			      					</div>
			      				</div>
			      			</div>
			      		</div>
			      	</div>
		      	</div>
	      	</div>
	    </div>
	</div>
	<script>
		$("#login").on("click",function(){
			var url = "<%= request.getContextPath() %>/loginServlet"
			var obj = {
						"login": $("#logUser").val(),
						"senha": $("#logpass").val()
				}
				
		    	$.ajax({
		    			type: "POST",
		    			url: url,
		    			data: JSON.stringify(obj),
		    			success: function(response){
		    				if (response.status) {
		    					window.location.href = "<%= request.getContextPath() %>/" + response.redirectUrl;	
		    				} else {
		    					window.location.href = "<%= request.getContextPath() %>/" + response.redirectUrl;
		    				}
		    			 },
		    	         error: function(error) {
		    	            console.log(error)
		    	         }
		    	});
		})
		$("#cadastrar").on("click",function(){
			var url = "<%= request.getContextPath() %>/cadastroUsuario";
			var obj = {
					"login": $("#cUser").val(),
					"senha": $("#cPass").val(),
					"email": $("#cEmail").val(),
					"nome": $("#cName").val()
			}
			$.ajax({
    			type: "POST",
    			url: url,
    			data: JSON.stringify(obj),
    			success: function(response){
    				if (response.status) {
    					window.location.href = "<%= request.getContextPath() %>/" + response.redirectUrl;	
    				} else {
    					window.location.href = "<%= request.getContextPath() %>/" + response.redirectUrl;
    				}
    			 },
    	         error: function(error) {
    	            console.log(error)
    	         }
    	});
		})
	</script>
</body>
</html>