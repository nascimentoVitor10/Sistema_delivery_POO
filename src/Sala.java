public class Sala {
    private String bloco;
    private String sala;
    private String andar;

    /**construtor da classe Sala*/
    Sala(String b, String s, String a){
        this.setBloco(b);
        this.setSala(s);
        this.setAndar(a);
    }


    /**método para retornar string do objeto*/
    public String toString(){return this.getBloco()+this.getSala()+this.getAndar();}


    /**getters e setters*/
    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }
}
