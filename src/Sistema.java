import java.util.ArrayList;

public class Sistema {
    private ArrayList<Aluno> alunos;
    private ArrayList<Admin> adms;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Sala> salas;


    /**construtor da classe Sistema*/
    public Sistema() {
        this.setAlunos(new ArrayList<>());
        this.setAdms(new ArrayList<>());
        this.setProdutos(new ArrayList<>());
        this.setPedidos(new ArrayList<>());
        this.setSalas(new ArrayList<>());
    }


    /**método para conferir se existe algum ADM cadastrado
     * @return valor booleano para indicar presença ou ausência
     * */
    public boolean sistemaVazio() {
        return this.getAdms().isEmpty();
    }


    /**métodos para adicionar um novo objeto criado em uma das
     * listas que o sistema armazena.*/
    public void addAdmin(Admin a) {
        this.getAdms().add(a);
    }

    public void addAluno(Aluno a){
        this.getAlunos().add(a);}

    public void addProduto(Produto p){
        this.getProdutos().add(p);}

    public void addPedido(Pedido p){
        this.getPedidos().add(p);}

    public void addSala(Sala s){
        this.getSalas().add(s);}


    /** métodos para pegar um objeto armazenado em uma das listas
     * que o objeto sistema armazena.
     * @param cpf : string do cpf do aluno requerido*
     * @return objeto da classe Aluno*/

    public Aluno getAluno(String cpf) {
        for(Aluno a : this.getAlunos()) {
            if (cpf.equals(a.getCpf())) return a;
        }
        return null;
    }

    /**@return objeto da classe Admin */
    public Admin getAdmin(String cpf) {
        for(Admin adm : this.getAdms()) {
            if (cpf.equals(adm.getCpf())) return adm;
        }
        return null;
    }

    /**@return objeto da classe Produto */
    public Produto getProduto(String cod){
        for(Produto p : this.getProdutos()){
            if (cod.equals((p.getCod()))){
                return p;
            }
        }
        return null;
    }

    /**@return objeto da classe Sala */
    public Sala getSala(String s){
        for (Sala sala : this.getSalas()){
            if (sala.toString().equals(s)){
                return sala;
            }
        }
        return null;
    }

    /**@return objeto da classe Sala */
    public Pedido getPedido(String p){
        for (Pedido pedido : this.getPedidos()){
            if (pedido.getCod().equals(p.toUpperCase())){
                return pedido;
            }
        }
        return null;
    }


    /**métodos para a geração automática de código de identificação*/
    public String geraCodigoPedido(){
        int numero = this.getPedidos().size() + 1;
        return "PEDIDO-" + numero;
    }

    public String geraCodigoProduto(){
        int numero = this.getProdutos().size() + 1;
        return "PROD-" + numero;
    }


    /**métodos para realizar a listagem de produtos e salas*/
    public void listarProdutos(){
        if (this.getProdutos() != null){
            for (Produto produto : this.getProdutos()){
                if (produto.getQtd() > 0){
                    System.out.println(produto);
                }
            }
        }
        else{
            System.out.println("\nnenhum produto cadastrado ainda!");
        }
    }

    public void listarSalas(){
        if (this.getSalas() != null){
            for (Sala sala : this.getSalas()){
                System.out.println(sala);
            }
        }
        else{
            System.out.println("Nenhuma sala cadastrada ainda!");
        }
    }


    /**métodos pora filtrar a lista de pedidos do sistema*/
    public ArrayList<Pedido> filtrarPedidos(boolean v){
        ArrayList<Pedido> pedidos_disponiveis = new ArrayList<>();

        if (v){
            for (Pedido pedido : this.getPedidos()){
                if (pedido.disponivel()){
                    pedidos_disponiveis.add(pedido);
                }
            }
            return pedidos_disponiveis;
        }
        return null;
    }

    public ArrayList<Pedido> filtrarPedidos(Aluno a){
        ArrayList<Pedido> pedidos_aluno = new ArrayList<>();

        for (Pedido pedido : this.getPedidos()){
            if (pedido.getCliente().equals(a)){
                pedidos_aluno.add(pedido);
            }
        }
        return pedidos_aluno;
    }


    /**getters e setters*/
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Admin> getAdms() {
        return adms;
    }

    public void setAdms(ArrayList<Admin> adms) {
        this.adms = adms;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }
}
