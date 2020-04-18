<%@page import="br.com.desenvolvimentoweb.model.Pais" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Visualizar País</title>
	
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="menu.jsp" />
        <div id="main" class="container">
            <h3 class="page-header">Visualizar País #${pais.id}</h3>
            <div class="row">
                <div class="col-md-12">
                    <p>
                    	<strong>Nome</strong>
                    </p>
                    <p>
                        ${pais.nome}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p>
                    	<strong>População</strong>
                    </p>
                    <p>
                        ${pais.populacao}
                    </p>
                </div>
                <div class="col-md-6">
                    <p>
                    	<strong>Área</strong>
                    </p>
                    <p>
                        ${pais.area}
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	</body>
</html>
