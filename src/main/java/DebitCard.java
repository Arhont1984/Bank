class DebitCard extends BankCard {

    public DebitCard() {
        super();
    }

    public void topUp(double amount) {
// Метод для пополнения карты
        balance.addAndGet(amount);
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Доступные средства: " + getBalance();
    }
}