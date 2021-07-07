package com.company;

public class BankAccount {
    double amount;

    public double getAmount() {
        return amount;
    }
    public void deposit(double sum){
        amount += sum;
    }
    public double withDraw(int sum) throws LimitException {
        if(sum > amount){
            throw new LimitException("Данная запрашиваемая сумма больше оста" +
                    "вшейся суммы, снимем оставшуюся сумму", getAmount());
        }
        amount -= sum;
        System.out.println("Снимается со счёта..." + sum);
        return amount;
    }
}
