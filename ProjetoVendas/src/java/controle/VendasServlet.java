package controle;

import dao.VendasDAO;
import modelo.ModeloVendas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/VendasServlet")
public class VendasServlet extends HttpServlet {

    // DAO responsável pela comunicação com o banco de dados
    private VendasDAO vendasDAO;

    @Override
    public void init() {
        // Inicializa o DAO quando o servlet é carregado pelo servidor
        vendasDAO = new VendasDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Define qual operação será executada via parâmetro da requisição
        String operacao = request.getParameter("operacao");

        try {
            switch (operacao) {

                case "cadastrar":
                    cadastrarVenda(request, response);
                    break;

                case "atualizar":
                    atualizarVenda(request, response);
                    break;

                case "excluir":
                    excluirVenda(request, response);
                    break;
            }
        } catch (Exception e) {
            // Encapsula qualquer erro como ServletException (boa prática em Servlets)
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Define operação de consulta via GET
        String operacao = request.getParameter("operacao");

        try {
            switch (operacao) {

                case "consultarPorId":
                    consultarPorId(request, response);
                    break;

                case "consultarTodos":
                    consultarTodos(request, response);
                    break;
            }
        } catch (Exception e) {
            // Em caso de erro, redireciona para página com mensagem genérica
            response.sendRedirect("consultar_venda.jsp?msg=erroConsulta");
        }
    }

    // =========================
    // CADASTRAR VENDA
    // =========================
    private void cadastrarVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            ModeloVendas venda = new ModeloVendas();

            // Conversão de dados vindos do formulário (String → tipos Java)
            venda.setId(Integer.parseInt(request.getParameter("id")));
            venda.setDataVenda(LocalDate.parse(request.getParameter("dataVenda")));
            venda.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
            venda.setFormaPagamento(request.getParameter("formaPagamento"));
            venda.setDescontoAplicado(Double.parseDouble(request.getParameter("descontoAplicado")));
            venda.setStatusVenda(request.getParameter("statusVenda"));
            venda.setImposto(Double.parseDouble(request.getParameter("imposto")));
            venda.setEnderecoEntrega(request.getParameter("enderecoEntrega"));
            venda.setFrete(Double.parseDouble(request.getParameter("frete")));
            venda.setItemVendido(request.getParameter("itemVendido"));

            // Envia objeto preenchido para camada DAO (persistência no banco)
            vendasDAO.inserir(venda);

            response.sendRedirect("cadastrar_venda.jsp?msg=sucessoCadastro");

        } catch (Exception e) {
            response.sendRedirect("cadastrar_venda.jsp?msg=erroCadastro");
        }
    }

    // =========================
    // ATUALIZAR VENDA
    // =========================
    private void atualizarVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            ModeloVendas venda = new ModeloVendas();

            // Mesma lógica de mapeamento request → objeto
            venda.setId(Integer.parseInt(request.getParameter("id")));
            venda.setDataVenda(LocalDate.parse(request.getParameter("dataVenda")));
            venda.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
            venda.setFormaPagamento(request.getParameter("formaPagamento"));
            venda.setDescontoAplicado(Double.parseDouble(request.getParameter("descontoAplicado")));
            venda.setStatusVenda(request.getParameter("statusVenda"));
            venda.setImposto(Double.parseDouble(request.getParameter("imposto")));
            venda.setEnderecoEntrega(request.getParameter("enderecoEntrega"));
            venda.setFrete(Double.parseDouble(request.getParameter("frete")));
            venda.setItemVendido(request.getParameter("itemVendido"));

            // Atualiza registro existente no banco
            vendasDAO.atualizar(venda);

            response.sendRedirect("atualizar_venda.jsp?msg=sucessoAtualizar");

        } catch (Exception e) {
            response.sendRedirect("atualizar_venda.jsp?msg=erroAtualizar");
        }
    }

    // =========================
    // EXCLUIR VENDA
    // =========================
    private void excluirVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            // Remove registro do banco com base no ID
            vendasDAO.excluir(id);

            response.sendRedirect("excluir_venda.jsp?msg=sucessoExcluir");

        } catch (Exception e) {
            response.sendRedirect("excluir_venda.jsp?msg=erroExcluir");
        }
    }

    // =========================
    // CONSULTAR POR ID
    // =========================
    private void consultarPorId(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            // Busca venda específica no banco
            ModeloVendas venda = vendasDAO.consultarPorId(id);

            // Envia objeto para JSP (View)
            request.setAttribute("venda", venda);

            request.getRequestDispatcher("consultar_venda.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("consultar_venda.jsp?msg=erroConsulta");
        }
    }

    // =========================
    // CONSULTAR TODOS
    // =========================
    private void consultarTodos(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
            // Recupera lista completa do banco
            List<ModeloVendas> lista = vendasDAO.consultarTodos();

            // Envia lista para JSP
            request.setAttribute("listaVendas", lista);

            request.getRequestDispatcher("consultar_venda.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("consultar_venda.jsp?msg=erroConsulta");
        }
    }
}