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
  
* tratamento de erros e exceções

  Em um programa é possível que erros imprevistos ocorram. Nesse caso, o erro é
  uma *exceção* ao comportamento normal do programa. Em java as exceções são tra-
  tadas como objetos. Há dois tipos em java: *checked* e *unchecked exceptions*.

      - checked exceptions : o tratamento é obrigatório
      - unchecked exceptions : não há obrigatoriedade para tratamento (não será notificada pelo compilador)

  Toda exceção é derivada do objeto Throwable.

  ![familia do Throwable](https://www.alura.com.br/apostila-java-orientacao-objetos/assets/images/excecoes/arvore_heranca_throwable.png)

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

  

  
* persistência em arquivos
* classes abstratas e interfaces
* coleções e ordenação
* OO em python
