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
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
<style>



@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700,800,900');

body{
	font-family: 'Poppins', sans-serif;
	font-weight: 300;
	font-size: 15px;
	line-height: 1.7;
	color: #c4c3ca;
	background-color: #1f2029;
	overflow-x: hidden;
}
a {
	cursor: pointer;
  transition: all 200ms linear;
}
a:hover {
	text-decoration: none;
}
.link {
  color: #c4c3ca;
}
.link:hover {
  color: #ffeba7;
}
p {
  font-weight: 500;
  font-size: 14px;
  line-height: 1.7;
}
h4 {
  font-weight: 600;
}
h6 span{
  padding: 0 20px;
  text-transform: uppercase;
  font-weight: 700;
}
.section{
  position: relative;
  width: 100%;
  display: block;
}
.full-height{
  min-height: 100vh;
}
[type="checkbox"]:checked,
[type="checkbox"]:not(:checked){
  position: absolute;
  left: -9999px;
}
.checkbox:checked + label,
.checkbox:not(:checked) + label{
  position: relative;
  display: block;
  text-align: center;
  width: 60px;
  height: 16px;
  border-radius: 8px;
  padding: 0;
  margin: 10px auto;
  cursor: pointer;
  background-color: #ffeba7;
}
.checkbox:checked + label:before,
.checkbox:not(:checked) + label:before{
  position: absolute;
  display: block;
  width: 36px;
  height: 36px;
  border-radius: 50%;
  color: #ffeba7;
  background-color: #102770;
  font-family: 'unicons';
  content: '\eb4f';
  z-index: 20;
  top: -10px;
  left: -10px;
  line-height: 36px;
  text-align: center;
  font-size: 24px;
  transition: all 0.5s ease;
}
.checkbox:checked + label:before {
  transform: translateX(44px) rotate(-270deg);
}


.card-3d-wrap {
  position: relative;
  width: 440px;
  max-width: 100%;
  height: 400px;
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  perspective: 800px;
  margin-top: 60px;
}
.card-3d-wrapper {
  width: 100%;
  height: 100%;
  position:absolute;    
  top: 0;
  left: 0;  
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  transition: all 600ms ease-out; 
}
.card-front, .card-back {
  width: 100%;
  height: 100%;
  background-color: #2a2b38;
  background-image: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/1462889/pat.svg');
  background-position: bottom center;
  background-repeat: no-repeat;
  background-size: 300%;
  position: absolute;
  border-radius: 6px;
  left: 0;
  top: 0;
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  -o-backface-visibility: hidden;
  backface-visibility: hidden;
}
.card-back {
  transform: rotateY(180deg);
}
.checkbox:checked ~ .card-3d-wrap .card-3d-wrapper {
  transform: rotateY(180deg);
}
.center-wrap{
  position: absolute;
  width: 100%;
  padding: 0 35px;
  top: 50%;
  left: 0;
  transform: translate3d(0, -50%, 35px) perspective(100px);
  z-index: 20;
  display: block;
}


.form-group{ 
  position: relative;
  display: block;
    margin: 0;
    padding: 0;
}
.form-style {
  padding: 13px 20px;
  padding-left: 55px;
  height: 48px;
  width: 100%;
  font-weight: 500;
  border-radius: 4px;
  font-size: 14px;
  line-height: 22px;
  letter-spacing: 0.5px;
  outline: none;
  color: #c4c3ca;
  background-color: #1f2029;
  border: none;
  -webkit-transition: all 200ms linear;
  transition: all 200ms linear;
  box-shadow: 0 4px 8px 0 rgba(21,21,21,.2);
}
.form-style:focus,
.form-style:active {
  border: none;
  outline: none;
  box-shadow: 0 4px 8px 0 rgba(21,21,21,.2);
}
.input-icon {
  position: absolute;
  top: 0;
  left: 18px;
  height: 48px;
  font-size: 24px;
  line-height: 48px;
  text-align: left;
  color: #ffeba7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}

.form-group input:-ms-input-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input::-moz-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:-moz-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input::-webkit-input-placeholder  {
  color: #c4c3ca;
  opacity: 0.7;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus:-ms-input-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus::-moz-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus:-moz-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}
.form-group input:focus::-webkit-input-placeholder  {
  opacity: 0;
  -webkit-transition: all 200ms linear;
    transition: all 200ms linear;
}

.btn{  
  border-radius: 4px;
  height: 44px;
  font-size: 13px;
  font-weight: 600;
  text-transform: uppercase;
  -webkit-transition : all 200ms linear;
  transition: all 200ms linear;
  padding: 0 30px;
  letter-spacing: 1px;
  display: -webkit-inline-flex;
  display: -ms-inline-flexbox;
  display: inline-flex;
  -webkit-align-items: center;
  -moz-align-items: center;
  -ms-align-items: center;
  align-items: center;
  -webkit-justify-content: center;
  -moz-justify-content: center;
  -ms-justify-content: center;
  justify-content: center;
  -ms-flex-pack: center;
  text-align: center;
  border: none;
  background-color: #ffeba7;
  color: #102770;
  box-shadow: 0 8px 24px 0 rgba(255,235,167,.2);
}
.btn:active,
.btn:focus{  
  background-color: #102770;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}
.btn:hover{  
  background-color: #102770;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}




.logo {
	position: absolute;
	top: 30px;
	right: 30px;
	display: block;
	z-index: 100;
	transition: all 250ms linear;
}
.logo img {
	height: 26px;
	width: auto;
	display: block;
}
 table {
    table-layout: fixed; /* Define a largura das colunas fixas */
  }

  td {
    word-break: break-word; /* Quebra a palavra quando o conteúdo é muito grande */
  }
</style>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
</head>
<body>

<div class="collapse" id="navbarToggleExternalContent">
  <div class="bg-dark p-4">
    <h5 class="text-white h4">Menu</h5>
    <a id="sair" class="text-muted">Sair</a>
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
    <div style="background-color: #212529!important;" class="modal-content">

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
    <div class="col-12 col-md-12 col-lg-12 col-xl-12">
      <div class="card bg-dark text-white" style="border-radius: 5rem;">
        <div class="card-body p-4 text-center table-responsive overflow-x-auto">
                <table id="myTable">
    				<thead>
      					<tr>
        					<th class="text-center">Nome</th>
        					<th class="text-center">Descricao</th>
        					<th class="text-center">Editar</th>
        					<th class="text-center">Excluir</th>
      					</tr>
    				</thead>
    				<tbody>
    				</tbody>
  				</table>
    <a class="btn btn-primary" href="view/cadastroTarefa.jsp">Criar nova tarefa</a>
                  
                  </div>
                
                </div>
              </div>
            </div>
          </div>
</section>
    <script>
    $(document).ready(function(){
    	var urlGet = "<%= request.getContextPath() %>/obterTarefasServelet"
    		$.ajax({
    			  type: "GET",
    			  url: urlGet,
    			  data: JSON.stringify(obj),
    			  success: function(response) {
    			    dataTable.clear();

    			    response.forEach(function(data) {
    			      dataTable.row.add(data);
    			    });

    			    dataTable.draw();
    			    $("a[data-id]").click(function() {
    			    	id = $(this).data('id'); 
    			    	$("#myModal").modal('toggle')
    			        obj = {
    			    		"id":id
    			    	};
    			    });
    			  },
    			  error: function(error) {
    			    console.log(error);
    			  }
    			});
    	var dataTable = $('#myTable').DataTable({
    		  language: {
    		    emptyTable: "Sem dados encontrados",
    		    zeroRecords: "Sem dados encontrados",
    		    info: "Mostrando _START_ até _END_ de _TOTAL_ entradas",
    		    infoEmpty: "Mostrando 0 até 0 de 0 entradas",
    		  },
    		  columns: [
    		    { data: 'titulo' },
    		    { data: 'descricao' },
    		    {
    		      data: 'id',
    		      render: function(data, type, row) {
    		        var editarLink = '<a style="white-space: nowrap;" class="btn btn-warning" href="edicaoTarefaServlet?id=' + data + '">Editar</a>';
    		        return editarLink;
    		      }
    		    },
    		    {
    		      data: null,
    		      render: function(data, type, row) {
    		        var excluirLink = '<a data-id="' + data.id + '" class="btn btn-danger" style="background-color: #ed6a6a!important; white-space: nowrap;">Excluir</a>';
    		        return excluirLink;
    		      }
    		    }
    		  ]
    		});
	});
    var obj = null;
    var url = "<%= request.getContextPath() %>/deletarTarefa"
    var urlSair = "<%= request.getContextPath() %>/mainServlet"
    
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
    	
    	$("#sair").on("click", function(){
    		$.ajax({
				type: "PUT",
				url: urlSair,
			    success: function(response){
			        window.location.href= urlSair
			    },
	            error: function(error) {
	            	window.location.href= urlSair
	            }
		  });
    	})
    </script>
</body>
</html>
