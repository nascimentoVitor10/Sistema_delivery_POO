public class Usuario {
    protected String cpf;
    protected String nome;
    private String senha;

    /**construtor da classe Usuario*/
    public Usuario(String cpf, String nome, String senha) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setSenha(senha);
    }

    /**método para validar acesso ao sistema*/
    public boolean validarAcesso(String s) {
        return this.senha.equals(s);
    }

    /**método para modificar senha de acesso*/
    public void alterarSenha(String atual, String nova){
        if (atual.equals(this.senha)){
            this.setSenha(nova);
        }
    }

    /**método para retornar string do objeto*/
    public String toString() {
        return this.getNome() + " - CPF: " + this.getCpf();
    }

    /*********************
     * getters e setters *
     * *******************/

    /**@return senha do usuário cadastrado no sistema */
    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String nova_senha){
        this.senha = nova_senha;
    }

    /**@return cpf do usuário */
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**@return nome do usuário */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
