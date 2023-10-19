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

        Upcasting e Downcasting

        Upcasting:
            - casting da subclasse para superclasse
            - uso comum: polimorfismo

        Downcasting:
            - casting da superclasse para subclasse
            - palavra instanceof
            - uso comum: métodos que recebem parâmetros genéricos (ex: Equals)
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
    }
}