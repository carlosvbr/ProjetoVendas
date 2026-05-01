<!DOCTYPE html>
<html>
<head>
    <title>Atualizar Venda</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>


<div class="container mt-5">

    <h2 class="text-center mb-4">Atualizar Venda</h2>

    <form action="VendasServlet" method="post">

        <input type="hidden" name="operacao" value="atualizar">

        <div class="row">

            <div class="col-md-6">
                <div class="form-group">
                    <label>ID</label>
                    <input type="number" name="id" class="form-control" placeholder="Ex: 1" required>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Data</label>
                    <input type="date" name="dataVenda" class="form-control">
                </div>
            </div>

        </div>

        <div class="row">

            <div class="col-md-6">
                <div class="form-group">
                    <label>Valor Total</label>

                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">R$</span>
                        </div>
                        <input type="number" step="0.01" name="valorTotal" class="form-control" placeholder="Ex: 150.00">
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Frete</label>

                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">R$</span>
                        </div>
                        <input type="number" step="0.01" name="frete" class="form-control" placeholder="Ex: 20.00">
                    </div>
                </div>
            </div>

        </div>

        <div class="row">

            <div class="col-md-6">
                <div class="form-group">
                    <label>Desconto</label>

                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">R$</span>
                        </div>
                        <input type="number" step="0.01" name="descontoAplicado" class="form-control" placeholder="Ex: 10.00">
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Imposto</label>

                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">R$</span>
                        </div>
                        <input type="number" step="0.01" name="imposto" class="form-control" placeholder="Ex: 5.00">
                    </div>
                </div>
            </div>

        </div>

        <div class="row">

            <div class="col-md-6">
                <div class="form-group">
                    <label>Forma de Pagamento</label>
                    <input type="text" name="formaPagamento" class="form-control" placeholder="Ex: Cartão, Pix">
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Status</label>
                    <input type="text" name="statusVenda" class="form-control" placeholder="Ex: Pago, Pendente">
                </div>
            </div>

        </div>

        <div class="form-group">
            <label>Endereço</label>
            <input type="text" name="enderecoEntrega" class="form-control" placeholder="Rua, número, bairro">
        </div>

        <div class="form-group">
            <label>Item</label>
            <input type="text" name="itemVendido" class="form-control" placeholder="Nome do item vendido">
        </div>

        <div class="text-center mt-4">

            <button type="submit" class="btn btn-warning mr-2">
                Atualizar Venda
            </button>

            <a href="index.jsp" class="btn btn-secondary">Voltar</a>

        </div>

    </form>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<%
String msg = request.getParameter("msg");
if (msg != null) {
%>
<script>

    <% if ("sucessoAtualizar".equals(msg)) { %>
        alert("Venda atualizada com sucesso!");

    <% } else if ("erroAtualizar".equals(msg)) { %>
        alert("Erro ao atualizar venda.");
    <% } %>

</script>
<%
}
%>

</body>
</html>