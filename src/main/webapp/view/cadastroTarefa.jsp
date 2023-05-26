<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Tarefa</title>
</head>
<body>
    
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
              <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-5 text-center">
                
                  <div class="mb-md-5 mt-md-4 pb-5">
                  
                    <h2 class="fw-bold mb-2 text-uppercase">Cadastrar Tarefa</h2>
                    
                    <div class="form-outline form-white mb-4">
                      <label class="form-label" for=""tituloX"">Nome da tarefa</label>
                      <input required name="titulo" type="text" id="tituloX" class="form-control form-control-lg" />
                          
                    </div>
                  
                    <div class="form-outline form-white mb-4">
                      <label class="form-label" for="descricaoX">Descrição da tarefa</label>
                        <textarea required class="form-control" id="descricaoX" name="descricao" rows="3"></textarea>
                    </div>
                  
                    <button class="btn btn-outline-light btn-lg px-5" id="cadastrarTarefa">Cadastrar Tarefar</button>
                  
                    <div class="d-flex justify-content-center text-center mt-4 pt-1">
                      <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                      <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                      <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                    </div>
                  
                  </div>
                
                  <div>
                    <p class="mb-0">Crie uma conta aqui <a href="<%= request.getContextPath() %>/cadastroUsuario" class="text-white-50 fw-bold">Registrars</a>
                    </p>
                  </div>
                
                </div>
              </div>
            </div>
          </div>
        </div>
</section>
</body>
<script>
	$("#cadastrarTarefa").on('click',function(){
		if ($('#tituloX').val()) == ''{
			$('#tituloX').css('background-color','#f0a1a9')
			return;
		}
		if ($('#descricaoX').val() == '') {
			$('#descricaoX').css('background-color','#f0a1a9')
			return;
		}
		
	})
	
</script>
</html>
