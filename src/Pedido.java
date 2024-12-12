import java.util.ArrayList;

public class Pedido {
    private String cod;
    private Aluno cliente;
    private Aluno entregador;
    private Sala sala;
    private ArrayList<Item> carrinho;
    private boolean entregue;


    /**construtor da classe Pedido*/
    Pedido(Aluno cliente, Sala sala){
        this.cod = null;
        this.setCliente(cliente);
        this.setEntregador(null);
        this.setSala(sala);
        this.carrinho = new ArrayList<>();
        this.entregue = false;
    }

    /**método para retornar string do objeto*/
    public String toString(){
        return "(Código do pedido: " + this.getCod() + ")" + "\nProdutos:";
    }


    /**
     * Retorna o valor total do pedido, acessando cada
     * um dos itens que estão no carrinho do aluno.
     * */
    public double valorTotal(){
        if (this.getCarrinho() != null){
            double valor_total = 0;
            for (Item i: this.getCarrinho()){
                valor_total += i.valorTotal();
            }
            return valor_total + 1;
        }
        return 0;
    }


    /**
     * Esse método não retorna nada, apenas atribui um
     * entregador a um pedido disponível.
     * */
    public void atribuirEntregador(Aluno entregador){
        this.setEntregador(entregador);
    }


    /**
     * Retorna true se o pedido não tem entregador e ainda
     * não foi entregue para não haver confusão ao pegar um
     * pedido para entregar.
     */
    public boolean disponivel(){
        return (!this.getEntregue()) && (this.getEntregador() == null);
    }


    /**
     * Esse método define o pedido como entregue logo quando
     * um aluno entregador é atribuído ao pedido feito.
     * */
    public void marcarComoEntregue(){
        this.setEntregue(true);
    }


    /**método para confirmar a conclusão de um pedido feito*/
    public void confirmar(){
        for (Item i : this.getCarrinho()){
            i.getProduto().retirarDeEstoque(i.getQtd());
        }
        this.cliente.retirarSaldo(this.valorTotal());
    }

    /**getters e setters*/
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Aluno getCliente() {
        return cliente;
    }

    public void setCliente(Aluno cliente) {
        this.cliente = cliente;
    }

    public Aluno getEntregador() {
        return entregador;
    }

    public void setEntregador(Aluno entregador) {
        this.entregador = entregador;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public ArrayList<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Item> carrinho) {
        this.carrinho = carrinho;
    }

    public boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }
}
