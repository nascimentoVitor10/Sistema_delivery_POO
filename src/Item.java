public class Item {
    private Produto p;
    private int qtd;

    Item(Produto p, int qtd){
        this.setProduto(p);
        this.setQtd(qtd);
    }


    public String toString(){return this.p.getCod() + ": " + this.p.getNome() +
            "  (QTD: " + this.getQtd() +")";}

    public double valorTotal(){
        return this.qtd * this.p.getValor();
    }

    public Produto getProduto() {
        return p;
    }

    public void setProduto(Produto p) {
        this.p = p;
    }

    public int getQtd() {
        return this.qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
