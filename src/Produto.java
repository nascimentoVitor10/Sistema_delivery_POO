public class Produto {
    private String nome;
    private String cod;
    private int qtd;
    private double valor;

    /**construtor da classe Produto*/
    Produto(String nome, int qtd, double valor){
        this.setNome(nome);
        this.cod = null;
        this.setQtd(qtd);
        this.setValor(valor);
    }


    /**método para retornar string do objeto*/
    public String toString() {
        return  this.getCod() +  ": " + this.getNome() + "- R$" + this.getValor();}

    /**método para atualizar estoque*/
    public void retirarDeEstoque(int qtd_pedida){
        if (qtd_pedida <= this.getQtd()){
            this.setQtd(this.getQtd() - qtd_pedida);
        }
        else{
            System.out.println("\nQuantidade insuficiente em estoque!");
        }
    }


    /**getters e setters*/
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod(){return this.cod;}

    public void setCod(String codigo){this.cod = codigo;}

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
