import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     * @author Hilario Seibel Junior e Vitor do Nascimento Ramos
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("out/production/Sistema_delivery_POO/input.txt")).useLocale(Locale.US);
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in).useLocale(Locale.US);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um ponto flutuante
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um ponto flutuante e retorna este número
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }


    /**********************/
    /** MENUS DO SISTEMA **/
    /**********************/

    /**
     * Exibe o menu principal até que o usuário opte por sair do programa.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Sistema s) {
        if (s.sistemaVazio()) {
            System.out.println("** Inicializando o sistema **");
            this.cadAdmin(s);
        }

        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Login.\n" +
                "0) Sair." +
                "\n*********************\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) login(s);
            else System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }
        System.out.println("Saindo do sistema... Inté!");

    }


    /**
     * Exibe o menu do administrador até que o usuário deslogue.
     * @param a: Objeto a classe Admin.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Admin a, Sistema s) {
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar novo administrador.\n" +
                "2) Cadastrar aluno.\n" +
                "3) Cadastrar produto.\n" +
                "4) Cadastrar sala.\n" +
                "0) Logout." +
                "\n*********************\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) cadAdmin(s);
            if (op == 2) cadAluno(s);
            if (op == 3) cadProduto(s);
            if (op == 4) cadSala(s);
            if (op < 0 || op > 4) System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }
        System.out.println("Voltando para página inicial...");
    }


    /**
     * Exibe o menu do aluno até que o usuário deslogue.
     * @param a: Objeto a classe Aluno.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Aluno a, Sistema s) {
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                    "1) Fazer pedido.\n" +
                    "2) Fazer entrega.\n" +
                    "3) Meus pedidos.\n" +
                    "4) Inserir crédito.\n" +
                    "0) Logout." +
                "\n*********************\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) fazerPedido(a, s);
            if (op == 2) entregarPedido(a, s);
            if (op == 3) listarPedidos(a, s);
            if (op == 4) inserirCredito(a, s);
            if (op < 0 || op > 4) System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }
        System.out.println("Voltando para página inicial...");
    }


    /**
     * Exibe a interface de login para direcionar o usuário
     * para um menu de acordo com sua credencial dita
     * @param s : objeto da classe Sistema
     * */
    public void login(Sistema s) {
        System.out.println("\nBem vindo! Digite seus dados de login:");
        String cpf = this.lerLinha("\nCPF:");
        String senha = this.lerLinha("\nSenha:");

        Admin adm = s.getAdmin(cpf);
        if (adm != null) {
            if (adm.validarAcesso(senha)) {
                this.menu(adm, s);
            }
            else System.out.println("\nSenha inválida.");
        }
        else {
            Aluno a = s.getAluno(cpf);
            if (a != null) {
                if (a.validarAcesso(senha)) {
                    this.menu(a, s);
                }
                else System.out.println("\nSenha inválida");
            }
        }
    }


    /************************/
    /** MÈTODOS AUXILIARES **/
    /************************/

    /**método que verifica se a quantidade um produto pedido tem em estoque
     * @param qtd_pedida : quantidade solicitada do produto
     * @param produto  : código do produto requerido
     * @param s : objeto da classe Sistema
     * @return valor booleano true se o estoque tiver a quantidade pedida
     * */
    public boolean confereEstoque(int qtd_pedida, String produto, Sistema s){
        return qtd_pedida <= s.getProduto(produto).getQtd();
    }

    /**método que confere se o saldo do aluno é suficiente
     * @param a : objeto da classe Aluno
     * @param p : objeto da classe Pedido
     * @return valor booleano indicando estado do saldo (insuficiente ou suficiente)
     * */
    public boolean confereCreditoAluno(Aluno a, Pedido p){
        return a.getSaldo() >= (p.valorTotal() + 1);
    }

    /**método para ler sala em que o pedido feito será entregue
     * @param s : objeto da classe Sistema
     * @return objeto da classe Sala
     * */
    private Sala lerSala(Sistema s){
        String sala_pedido = this.lerLinha("Digite a sala: ");
         return s.getSala(sala_pedido);
    }

    /**método para ler um item que o aluno colocará no carrinho
     * @param s : objeto da classe Sistema
     * @return objeto da classe Item
     * */
    private Item lerItem(Sistema s){
        String cod_prod = this.lerLinha("\nDigite o código do produto: ");
        int qtd_prod = this.lerInteiro("\nDigite a quantidade de " + cod_prod + ": ");

        while (!confereEstoque(qtd_prod, cod_prod, s)){

            if (s.getProduto(cod_prod).getQtd() == 0){
                qtd_prod = 0;
                System.out.println("Produto em falta...");
                break;
            }

            System.out.println("\nHá em estoque " + s.getProduto(cod_prod).getQtd() + " unidades.");
            qtd_prod = this.lerInteiro("\nDigite uma nova quantidade de " + cod_prod + ": ");
        }

        if (qtd_prod > 0){
            return new Item(s.getProduto(cod_prod), qtd_prod);
        }
        return null;
    }


    /****************/
    /***  ALUNO   ***/
    /****************/
    public void fazerPedido(Aluno a, Sistema s){

        //lista de salas cadastradas
        System.out.println("\nSalas disponíveis:");
        s.listarSalas();

        //leitura da sala em que será entregue o pedido
        Sala sala_pedido = lerSala(s);

        //criação do pedido e indexação de código
        Pedido novo_pedido = new Pedido(a, sala_pedido);
        novo_pedido.setCod(s.geraCodigoPedido());

        //menu
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Inserir produto no carrinho.\n" +
                "2) Fechar pedido.\n" +
                "\n*********************\n"
                ;

        int op = this.lerInteiro(msg);

        while (op != 2){

            if (op < 1 || op > 2){
                System.out.println("Opção inválida. Tente novamente.\n");
            }

            if (op == 1){
                //lista de produtos disponíveis no estoque
                System.out.println("\n*** Produtos disponíveis ***\n");
                s.listarProdutos();

                //escolha de novo item para inserir no carrinho
                Item novo_item = lerItem(s);

                //verificação para não adicionar itens nulos no carrinho
                if (novo_item != null){
                    novo_pedido.getCarrinho().add(novo_item);
                    System.out.println(novo_item.getQtd() + "-" + novo_item.getProduto().getNome() + " adicionado ao carrinho.\n");
                }
            }
            op = this.lerInteiro(msg);
        }

        //fechar pedido
        if (confereCreditoAluno(a, novo_pedido)){
            novo_pedido.confirmar();
            s.addPedido(novo_pedido);
            System.out.println("Pedido de " + a.getNome() + " feito.\n");
        }
        else{
            System.out.println("Saldo insuficiente...");
        }
    }


    public void entregarPedido(Aluno aluno, Sistema s){
        if (s.getPedidos() != null){

            //lista de pedidos ainda não entregues e sem entregador
            System.out.println("\nPedidos disponíveis para entrega:\n");
            for (Pedido pedido : s.filtrarPedidos(true)){
                System.out.println(pedido);
            }

            //coleta do código do pedido que o entregador entregará
            String pedido_entrega = this.lerLinha("Digite o código do pedido: ");

            //conclusão de entrega
            Pedido p = s.getPedido(pedido_entrega);
            p.atribuirEntregador(aluno);
            p.marcarComoEntregue();
            aluno.inserirSaldo(0.8);
        }
        System.out.println("\nNenhum pedido cadastrado!");
    }

    public void listarPedidos(Aluno a, Sistema s){
        System.out.println("\n*** Pedidos do aluno " + a.getNome() + " - (Saldo: R$ " + a.getSaldo() + ") ***\n");
        if (s.filtrarPedidos(a) != null){
            for (Pedido pedido : s.filtrarPedidos(a)) {
                System.out.println(pedido);
                for (Item item : pedido.getCarrinho()){
                    System.out.println(item);
                }

                if (pedido.getEntregue()){
                    System.out.println("Status: Entregue");
                }
                else{
                    System.out.println("Status: Em aberto");
                }
                System.out.println("Valor total: R$" + pedido.valorTotal());
                System.out.println("===================\n");
            }
        }
        else{
            System.out.println("O aluno não tem pedidos cadastrados!\n");
        }
    }


    public void inserirCredito(Aluno a, Sistema s){
        System.out.println("\n=== inserir créditos ===\n");
        double valor = this.lerDouble("Digite o valor a ser inserido: R$ ");
        a.inserirSaldo(valor);
        System.out.println("\nCréditos adicionados com sucesso!");
        System.out.println("\nNovo saldo: R$ " + a.getSaldo());
    }




    /***************/
    /** CADASTROS **/
    /***************/

    /**
     * Lê os dados de um novo administrador e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadAdmin(Sistema s) {
        System.out.println("\n** Cadastrando um novo administrador **\n");
        String cpf = this.lerLinha("Digite o cpf: ");

        while (s.getAdmin(cpf) != null) {
            cpf = this.lerLinha("Usuário já existente. Escolha outro cpf: ");
        }

        String nome = this.lerLinha("\nDigite o nome: ");
        String senha = this.lerLinha("\nDigite a senha: ");
        String email = this.lerLinha("\nDigite o email: ");

        Admin a = new Admin(cpf, nome, senha, email);
        s.addAdmin(a);

        System.out.println("\nUsuário " + a + " criado com sucesso!\n");
    }


    public void cadAluno(Sistema s){
        System.out.println("\n** Cadastrando um novo aluno **\n");
        String cpf = this.lerLinha("Digite o cpf:  ");

        while (s.getAluno(cpf) != null){
            cpf = this.lerLinha("\nUsuário já existente. Adicione outro cpf: ");
        }

        String nome = this.lerLinha("\nDigite o nome: ");
        String senha = this.lerLinha("\nDigite a senha: ");

        Aluno a = new Aluno(cpf, nome, senha);
        s.addAluno(a);

        System.out.println("\nUsuário: " + a + " criado com sucesso!\n");
    }


    public void cadProduto(Sistema s){
        System.out.println("\n** Cadastrando um novo produto **\n");

        String nome = this.lerLinha("Digite o nome do produto: ");
        int qtd = this.lerInteiro("\nDigite a quantidade em estoque: ");
        double valorUnit = this.lerDouble("\nDigite o valor unitário do produto: ");

        Produto p = new Produto(nome, qtd, valorUnit);
        p.setCod(s.geraCodigoProduto());
        s.addProduto(p);

        System.out.println("\nProduto " + p + " criado com sucesso!\n");
    }

    public void cadSala(Sistema s){
        System.out.println("\n** Cadastrando uma nova sala **\n");

        String bloco = this.lerLinha("Digite o bloco (ex: para 904T, digite 9): ");
        String sala = this.lerLinha("\nDigite a sala (ex: para 904T, digite 04): ");
        String andar = this.lerLinha("\nDigite o andar (ex: pata 904, digite T): ");
        Sala room = new Sala(bloco, sala, andar);

        while (s.getSala(room.toString()) != null){
            System.out.println("\nSala já existente. Escolha outra sala.\n");
            bloco = this.lerLinha("Digite o bloco: ");
            sala = this.lerLinha("\nDigite a sala: ");
            andar = this.lerLinha("\nDigite o andar: ");
            room = new Sala(bloco, sala, andar);
        }

        s.addSala(room);
        System.out.print("\nSala " + room + " criada com sucesso!\n");
    }
}
