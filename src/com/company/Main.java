package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);

        while (true) {
            try {
                System.out.println("Счет: " + bankAccount.getAmount());
                bankAccount.withDraw(6000);
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                try {
                    bankAccount.withDraw((int) bankAccount.getAmount());
                    System.out.println("Осталось: " + bankAccount.getAmount());
                } catch (LimitException limitException) {
                    limitException.printStackTrace();
                }
                break;
            }
            Thread.sleep(1000);
        }
    }
}