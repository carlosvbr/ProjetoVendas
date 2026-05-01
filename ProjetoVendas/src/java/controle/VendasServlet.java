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

    private VendasDAO vendasDAO;

    @Override
    public void init() {
        vendasDAO = new VendasDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
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
            
            response.sendRedirect("consultar_venda.jsp?msg=erroConsulta");
        }
    }
    
    private void cadastrarVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            ModeloVendas venda = new ModeloVendas();

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

            vendasDAO.inserir(venda);

            response.sendRedirect("cadastrar_venda.jsp?msg=sucessoCadastro");

        } catch (Exception e) {
            response.sendRedirect("cadastrar_venda.jsp?msg=erroCadastro");
        }
    }


    private void atualizarVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            ModeloVendas venda = new ModeloVendas();

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

            vendasDAO.atualizar(venda);

            response.sendRedirect("atualizar_venda.jsp?msg=sucessoAtualizar");

        } catch (Exception e) {
            response.sendRedirect("atualizar_venda.jsp?msg=erroAtualizar");
        }
    }

    private void excluirVenda(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            vendasDAO.excluir(id);

            response.sendRedirect("excluir_venda.jsp?msg=sucessoExcluir");

        } catch (Exception e) {
            response.sendRedirect("excluir_venda.jsp?msg=erroExcluir");
        }
    }


    private void consultarPorId(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            ModeloVendas venda = vendasDAO.consultarPorId(id);

            request.setAttribute("venda", venda);

            request.getRequestDispatcher("consultar_venda.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("consultar_venda.jsp?msg=erroConsulta");
        }
    }


    private void consultarTodos(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
 
            List<ModeloVendas> lista = vendasDAO.consultarTodos();

            request.setAttribute("listaVendas", lista);

            request.getRequestDispatcher("consultar_venda.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("consultar_venda.jsp?msg=erroConsulta");
        }
    }
}
