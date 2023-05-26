<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="model.Tarefa" %>
<%@ page import="java.util.List" %>
<%
List<Tarefa> tarefas =  (List<Tarefa>) request.getAttribute("tarefas");
%>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style>

.gradient-custom {
/* fallback for old browsers */
background: #6a11cb;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
}
</style>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
</head>
<body>

<div class="collapse" id="navbarToggleExternalContent">
  <div class="bg-dark p-4">
    <h5 class="text-white h4">Collapsed content</h5>
    <span class="text-muted">Toggleable via the navbar brand.</span>
  </div>
</div>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</nav>


<section class="vh-100 gradient-custom">

<!-- Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Delete</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Essa ação é definitiva, deseja realmente deletar ?
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" id="deletarTarefa" class="btn btn-danger" data-bs-dismiss="modal">Deletar</button>
      </div>

    </div>
  </div>
</div>
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
              <div class="card bg-dark text-white" style="border-radius: 5rem;">
                <div class="card-body p-5 text-center">
                	<table class="table table-dark"> 
                		<tbody>Tarefas</tbody>
                		<tr>
                			<th>Nome</th>
                			<th>Descricao</th>
                			<th>Editar</th>
                			<th>Excluir</th>
                		</tr>
                		<% for (Tarefa tarefa : tarefas) { %>
                    <tr>
                        <td><%= tarefa.getTitulo() %></td>
                        <td><%= tarefa.getDescricao() %></td>
                        <td><a class="btn btn-warning" href="edicaoTarefaServlet?id=<%= tarefa.getId() %>">Editar</a></td>
                        <td><a  data-id="<%= tarefa.getId() %>" class="btn btn-danger" >Deletar</a></td>
                    </tr>
                <% } %>
                	</table>
                	
        
    
    <a href="view/cadastroTarefa.jsp">Criar nova tarefa</a>
                  
                  </div>
                
                </div>
              </div>
            </div>
          </div>
</section>
    <script>
    var obj = null;
    var url = "<%= request.getContextPath() %>/deletarTarefa"
    $("a[data-id]").click(function() {
    	id = $(this).data('id'); 
    	$("#myModal").modal('toggle')
        obj = {
    		"id":id
    	};
    });
    	$("#deletarTarefa").on('click',function(){
    		$.ajax({
    				type: "DELETE",
    				url: url,
    				data: JSON.stringify(obj),
    			    success: function(response){
    			        window.location.reload();
    			    },
    	            error: function(error) {
    	            	console.log(error)
    	            }
    		  });
    		console.log(id);
    		id = null;
    	})
    </script>
</body>
</html>
