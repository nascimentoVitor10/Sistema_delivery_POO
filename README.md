# Disciplina de POO

Este trabalho constitui em um sistema de delivery implementado por uma cantina
por meio do qual os próprios alunos podem realizar a entrega de pedidos disponíveis.

O objetivo é exercitar e fixar os conceitos de orientação a objetos vistos em sala.

Conteúdos:

* classes e objetos
  \\
  
* métodos
  \\
  
* construtores
  \\
  
* herança
  \\
  
* reescrita e sobrecarga de métodos
  \\
  
* encapsulamento
  \\
  
* arrays, ArrayLists e métodos estáticos
  \\

==============================================================================================
* # Tratamento de erros e exceções

  Em um programa é possível que erros imprevistos ocorram. Nesse caso, o erro é
  uma *exceção* ao comportamento normal do programa. Em java as exceções são tra-
  tadas como objetos. Há dois tipos em java: *checked* e *unchecked exceptions*.

      - checked exceptions : o tratamento é obrigatório
      - unchecked exceptions : não há obrigatoriedade para tratamento (não será notificada pelo compilador)

  Toda exceção é derivada do objeto Throwable.

  ![familia do Throwable](https://www.alura.com.br/apostila-java-orientacao-objetos/assets/images/excecoes/arvore_heranca_throwable.png)

 *TRY e CATCH*
  ```
  try {
      // código normal a ser executado
  }
  catch (exceção 1){
      // código de tratamento do primeiro tipo de erro
  }
  catch (exceção 2){
      // código de tratamento do segundo tipo de erro
  }
  ```

  *FINALLY*
  ```
  try {
      // código normal a ser executado
  }
  catch (exceção 1){
      // código de tratamento do primeiro tipo de erro
  }
  finally{
      // executa sempre, mesmo que nenhuma exceção não seja lançada
      // ou que o programa aborte
  }
  ```

 *TIPOS COMUNS DE EXCEÇÃO*
 
   - InputMismatchexception - leitura de dado de tipo diferente do esperado
   -  NullPointerexception - acesso a um objeto declarado, mas não instanciado
   -  NumberFormatException - string de formato que não pode ser convertida para numerp
   -  ArrayIndexOutOfBoundsException - acesso a uma posição inválida em um array
   -  ArithmeticException - execução de operação aritimética inválida (divisão por zero)
   -  IOException - classe genérica para erros de entrada e saída
   -  FileNotFoundException - acesso a um arquivo que não existe


 ```
 void sacar(double quantidade) throws IllegalArgumentException{

    if (quantidade > this.saldo + this.limite){
        throw new IllegalArgumentException();
    }
    else{
        this.saldo = this.saldo - quantidade;
    }
 }
 ```
 *throws* apenas avisa a possibilidade de um método lançar uma exceção\n
 *throw* lança uma exceção

 Com esse tratamento o método sacar() já não precisa mais retornar true ou false
 Agora usar try-catch ao invés de if-else para tratamento em um nível mais alto.

 ```
 void sacar(double quantidade) throws IllegalArgumentException{

    if (quantidade > this.saldo + this.limite){
        throw new IllegalArgumentException("saldo insuficiente.");
    }
    else{
        this.saldo = this.saldo - quantidade;
    }
 }

 ContaCorrente c = new ContaCorrente();
 try{
    c.sacar(100);
    System.out.println("Saque realizado!);
 }
 catch (IllegalArgumentException e){
    System.out.println(e.getMessage());
 }
 ```

 *criar sua própria exceção*
 ```
 public class SaldoInsuficienteException extends Exception {
    SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
 }
 ```
==============================================================================================

  
* persistência em arquivos
* classes abstratas e interfaces
* coleções e ordenação
* OO em python
