package modelo;

import java.time.LocalDate;

public class ModeloVendas {

    private int id;
    private LocalDate dataVenda;
    private double valorTotal;
    private String formaPagamento;
    private double descontoAplicado;
    private String statusVenda;
    private double imposto;
    private String enderecoEntrega;
    private double frete;
    private String itemVendido;


    public ModeloVendas(int id, LocalDate dataVenda, double valorTotal, String formaPagamento,
                        double descontoAplicado, String statusVenda, double imposto,
                        String enderecoEntrega, double frete, String itemVendido) {

        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;

        this.descontoAplicado = descontoAplicado;

        this.statusVenda = statusVenda != null ? statusVenda : "Em Processamento";

        this.imposto = imposto;
        this.enderecoEntrega = enderecoEntrega;
        this.frete = frete;
        this.itemVendido = itemVendido;
    }


    public ModeloVendas() {

        this.id = 0;
        this.dataVenda = LocalDate.now(); 
        this.valorTotal = 0.0;
        this.formaPagamento = "";
        this.descontoAplicado = 0.0;
        this.statusVenda = "Em Processamento";
        this.imposto = 0.0;
        this.enderecoEntrega = "";
        this.frete = 0.0;
        this.itemVendido = "";
    }


    @Override
    public String toString() {

        return "Venda {" +
                "ID=" + id +
                ", Data=" + dataVenda +
                ", Valor Total=" + valorTotal +
                ", Forma Pagamento='" + formaPagamento + '\'' +
                ", Desconto=" + descontoAplicado +
                ", Status='" + statusVenda + '\'' +
                ", Imposto=" + imposto +
                ", Endereço='" + enderecoEntrega + '\'' +
                ", Frete=" + frete +
                ", Item='" + itemVendido + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
       
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
  
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }

    public void setDescontoAplicado(double descontoAplicado) {
        this.descontoAplicado = descontoAplicado;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public String getItemVendido() {
        return itemVendido;
    }

    public void setItemVendido(String itemVendido) {
        this.itemVendido = itemVendido;
    }
}
