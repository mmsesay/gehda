public class Main {

    public static void main(String...args) {

        System.out.println("Welcome to GEHDA Banking system");
        System.out.println("-------------------------------");

        Init_Bank T1 = new Init_Bank("Thread Bank");
        T1.start();
        T1.create("GT-BANK","1 Test Street", "+232-77-111-222", "GT");
        T1.stopThread();
        System.out.println("-------------------------------");

        Init_Bank T2 = new Init_Bank("Thread Create Account");
        T2.start();
        T2.createAccount("Tom Frank", "5 Test Street",
                "+232-76-111-121", "Savings", 100000.0F);
        T2.stopThread();
        System.out.println("-------------------------------");

        Init_Bank T3 = new Init_Bank("Thread Deposit");
        T3.start();
        T3.deposit("AC1000","Tom Frank", "Tami Dank", "78990990", 400000);
        T3.stopThread();
        System.out.println("-------------------------------");

        Init_Bank T4 = new Init_Bank("Thread Withdrawal");
        T4.start();
        T4.withdrawal("AC1000", 200000);
        T4.stopThread();
        System.out.println("-------------------------------");

    }
}
