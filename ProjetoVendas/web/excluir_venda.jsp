<!DOCTYPE html>
<html>
<head>
    <title>Excluir Venda</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>

        .full-height {
            height: 100vh; 
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .form-group {
            width: 100%;
            max-width: 400px;
        }

    </style>

    <script>

        function confirmarExclusao(event) {
            event.preventDefault(); 

            const confirmar = confirm("Tem certeza que deseja excluir esta venda?");

            if (confirmar) {
                event.target.closest("form").submit();
            }
        }
    </script>
</head>

<body>

<div class="container full-height">

    <h2 class="text-center mb-4">Excluir Venda</h2>

    <script>
        const urlParams = new URLSearchParams(window.location.search);
        const msg = urlParams.get("msg");

        // Feedback visual simples via alert
        if (msg === "sucessoExcluir") {
            alert("Venda excluída com sucesso");

        } else if (msg === "erroExcluir") {
            alert("Erro ao excluir venda");
        }
    </script>

    <form action="VendasServlet" method="post">

        <input type="hidden" name="operacao" value="excluir">

        <div class="form-group">
            <label>ID da venda</label>
            <input type="number" name="id" class="form-control" required>
        </div>

        <div class="d-flex justify-content-between mt-3" style="max-width: 400px; width: 100%;">

            <button type="submit" class="btn btn-danger" onclick="confirmarExclusao(event)">
                Excluir
            </button>

            <a href="index.jsp" class="btn btn-secondary">Voltar</a>

        </div>

    </form>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>