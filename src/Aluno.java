public class Aluno extends Usuario{
    private double saldo;

    /**construtor da classe Aluno
     * @param cpf : cpf do aluno criado
     * @param nome : nome do aluno
     * @param senha : senha do aluno
     * */
    public Aluno(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
        this.saldo = 0;
    }

    /**método para retornar info sobre o aluno*/
    public String toString() {
        return super.toString() + " (Saldo: R$" + String.format("%.2f", this.saldo) + ")";
    }


    /**método para inserir créditos na conta do aluno
     * @param valor : valor a ser inserido no saldo
     * */
    public void inserirSaldo(double valor){
        if (valor >= this.getSaldo()){
            this.saldo = this.getSaldo() + valor;
        }
    }

    /**método para decrementar os gastos do aluno
     * @param valor : valor a ser retirado do saldo
     * */
    public void retirarSaldo(double valor){
        this.saldo = this.getSaldo() - valor;
    }


    /**getters e setters*/
    public double getSaldo() {
        return this.saldo;
    }
}
