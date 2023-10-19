import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        /*
        Herança
        é um tipo de associação que permite queuma classe herde todos dados e comportamentos
        de outra classe

        Definições importantes
        Vantagens:
            - reuso
            - polimorfismo

        Sintaxe:
            class A extends B

        Relação "é-um"
        Generalização/especialização
        Superclasse (classe base) / subclasse (classe derivada)
        Herança/extensão
        Herança é uma associação entre classes (e não entre objetos)

        =====================================

        UPCASTING E DOWNCASTING

        Upcasting:
            - casting da subclasse para superclasse
            - uso comum: polimorfismo

        Downcasting:
            - casting da superclasse para subclasse
            - palavra instanceof
            - uso comum: métodos que recebem parâmetros genéricos (ex: Equals)

        ======================================

        SOBREPOSIÇÃO, SUPER, ANOTAÇÃO, @OVERRIDE

        Sobreposição ou Sobrescrita:
            - é a implementação de um método de uma superclasse na subclasse
            - é fortemente recomendável usar a anotação @Override em um método sobrescrito
                - facilita a leitar e compreensão do código
                - avisamos ao compilador (boa prática)

         =======================================

         SUPER
            É possível chamar a implementação da superclasse usando a palavra super

         =======================================

         Classes e métodos FINAL
            - palavra chave: final

            Classe: Evita que seja herdada:
                public final class SavingsAccount(){}

            Método: Evita que seja sobreposto

         Por que utilizar Final?
            Segurança: dependendo das regras de negócio, é desejável garantir que uma classe
            não possa ser herdada ou método sobreposto.
                - geralmente convém acrescentar final em métodos sobrepostos, pois, sobreposições
                múltiplas podem gerar inconsistências

            Performance: Atributos de tipo de uma classe final são analisados de forma mais rápida
            em tempo de execução


         */

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING - é possível atribuir classes filhas a uma instância de classe pai
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        //DOWNCASTING - converter uma superclasse para subclasse
        // conversão não natural, necessário fazer o casting
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        // Só gera problema quando executar, pois o compilador
        // não sabe que acc3 é uma savings account, apesar de ter sido instanciada como account
//        BusinessAccount acc5 = (BusinessAccount)acc3;
        // downcasting nem sempre da certo - testar com instanceof

        if(acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        // Sobreposição
        Account conta1 = new Account(1001, "Alex", 1000.0);
        conta1.withdraw(200.0);
        System.out.println(conta1.getBalance());

        Account conta2 = new SavingsAccount(1002, "Maria", 1000.0, 0.05);
        conta2.withdraw(200.0);
        System.out.println(conta2.getBalance());

        // Sobreposição Super
        Account conta3 = new BusinessAccount(1003, "Motocenter", 1000.0, 500.0);
        conta3.withdraw(200.0);
        System.out.println(conta3.getBalance());
    }
}