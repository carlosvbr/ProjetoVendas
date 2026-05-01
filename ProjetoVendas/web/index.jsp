<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Vendas</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>

        .full-height {
            height: 100vh; 
            display: flex; 
            flex-direction: column; 
            justify-content: center; 
            align-items: center; 
        }

        .button-container {
            display: flex; 
            gap: 15px; 
            flex-wrap: wrap; 
            justify-content: center; 
        }
    </style>
</head>

<body>

<div class="container full-height">

    <h1 class="text-center mb-4">Sistema de Vendas</h1>

    <div class="button-container">

        <a href="cadastrar_venda.jsp" class="btn btn-primary">Cadastrar Venda</a>

        <a href="atualizar_venda.jsp" class="btn btn-warning">Atualizar Venda</a>

        <a href="excluir_venda.jsp" class="btn btn-danger">Excluir Venda</a>

        <a href="consultar_venda.jsp" class="btn btn-info">Consultar Venda</a>

    </div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>