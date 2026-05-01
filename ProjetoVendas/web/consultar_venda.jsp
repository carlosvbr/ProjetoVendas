<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.ModeloVendas" %>

<!DOCTYPE html>
<html>
<head>
    <title>Consultar Vendas</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>

        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .center-box {
            max-width: 1100px;
            width: 100%;
        }
    </style>
</head>

<body>

<div class="container center-box">

    <h2 class="text-center mb-4">Consultar Vendas</h2>

<%
    String msg = request.getParameter("msg");
    if ("erroConsulta".equals(msg)) {
%>
    <script>
        alert("Erro, não foi possível consultar venda");
    </script>
<%
    }
%>

    <div class="d-flex flex-column align-items-center mb-4">

        <div class="d-flex justify-content-center w-100 mb-3">

            <form action="VendasServlet" method="get" class="mr-2 w-25">

                <input type="hidden" name="operacao" value="consultarTodos">

                <button type="submit" class="btn btn-success w-100">
                    Consultar Todas
                </button>
            </form>

            <form action="VendasServlet" method="get" class="w-25 d-flex flex-column">

                <input type="hidden" name="operacao" value="consultarPorId">

                <button type="submit" class="btn btn-primary w-100 mb-2">
                    Consultar por ID
                </button>

                <input type="number" name="id" class="form-control" placeholder="Digite o ID" required>

            </form>

        </div>

    </div>

    <hr>

<%
    List<ModeloVendas> lista = (List<ModeloVendas>) request.getAttribute("listaVendas");

    if (lista != null && !lista.isEmpty()) {
%>

    <h4 class="text-center mb-3">Lista de Vendas</h4>

    <div class="table-responsive">
        <table class="table table-bordered table-striped text-center">

            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Data</th>
                <th>Valor</th>
                <th>Pagamento</th>
                <th>Desconto</th>
                <th>Status</th>
                <th>Imposto</th>
                <th>Endereço</th>
                <th>Frete</th>
                <th>Item</th>
            </tr>
            </thead>

            <tbody>

<%
        for (ModeloVendas v : lista) {
%>
            <tr>
                <td><%= v.getId() %></td>
                <td><%= v.getDataVenda() %></td>
                <td><%= v.getValorTotal() %></td>
                <td><%= v.getFormaPagamento() %></td>
                <td><%= v.getDescontoAplicado() %></td>
                <td><%= v.getStatusVenda() %></td>
                <td><%= v.getImposto() %></td>
                <td><%= v.getEnderecoEntrega() %></td>
                <td><%= v.getFrete() %></td>
                <td><%= v.getItemVendido() %></td>
            </tr>
<%
        }
%>

            </tbody>
        </table>
    </div>

<%
    }

    ModeloVendas venda = (ModeloVendas) request.getAttribute("venda");

    if (venda != null) {
%>

    <h4 class="text-center mt-4">Venda Encontrada</h4>

    <div class="table-responsive">
        <table class="table table-bordered table-striped text-center mt-3">

            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Data</th>
                    <th>Valor</th>
                    <th>Pagamento</th>
                    <th>Desconto</th>
                    <th>Status</th>
                    <th>Imposto</th>
                    <th>Endereço</th>
                    <th>Frete</th>
                    <th>Item</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td><%= venda.getId() %></td>
                    <td><%= venda.getDataVenda() %></td>
                    <td><%= venda.getValorTotal() %></td>
                    <td><%= venda.getFormaPagamento() %></td>
                    <td><%= venda.getDescontoAplicado() %></td>
                    <td><%= venda.getStatusVenda() %></td>
                    <td><%= venda.getImposto() %></td>
                    <td><%= venda.getEnderecoEntrega() %></td>
                    <td><%= venda.getFrete() %></td>
                    <td><%= venda.getItemVendido() %></td>
                </tr>
            </tbody>

        </table>
    </div>

<%
    }
%>

    <div class="text-center mt-4">
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>