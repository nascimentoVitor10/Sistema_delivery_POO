public class Admin extends Usuario{
    private String email;

    /**construtor da classe Admin*/
    public Admin(String cpf, String nome, String senha, String email) {
        super(cpf, nome, senha);
        this.email = email;
    }

    /**método para retornar string do objeto*/
    public String toString() {
        return super.toString() + " (ADMIN)";
    }


    /**getters e setters*/
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
