package org.example.ApiCoding;

public class BankingExample {

    public static void main(String[] args) {
        System.out.println("---banking system---");
        bankaccount account=new bankaccount("newone",1000);
        System.out.println("balance is"+account.getBalance());

        Thread customer1 = new Thread(new Customer(account, "Alice", 300, "withdraw"));
        Thread customer2=new Thread(new Customer(account,"sai",400,"deposit"));
                        customer1.start();
                        customer2.start();
                        try {
                            customer1.join();
                            customer2.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
        System.out.println("final balance"+account.getBalance());
    }

    static class bankaccount {
        private int balance;
        private final String accountNumber;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public bankaccount(String accountNumber, int balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public synchronized boolean withDraw(String customer, int amount) {
            System.out.println(customer + "attempting to withdraw" + amount);

            if (balance >= amount) {
                System.out.println(customer + "current balance" + balance);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                balance -= amount;
                System.out.println("remaining amount" + balance);
                return true;

            } else {
                System.out.println("not having suffienct funds");
                return false;
            }
        }

        public synchronized void deposit(String customer, int amount) {

            System.out.println(customer + "depositing the amount" + amount);
            balance += amount;

            System.out.println("total balance" + balance);

        }
    }
static class Customer implements Runnable{
        private bankaccount account;
        private String name;
        private int amount;
        private String operation;

    public Customer(bankaccount account, String name, int amount, String operation) {
        this.account = account;
        this.name = name;
        this.amount = amount;
        this.operation = operation;
    }

    @Override
    public void run() {
        if(operation.equals("withdraw")){
            account.withDraw(name,amount);

        } else if (operation.equals("deposit")) {
            account.deposit(name,amount);

        }

    }

    }

    }

