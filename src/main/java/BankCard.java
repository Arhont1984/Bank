import com.google.common.util.concurrent.AtomicDouble;

abstract class BankCard {
    protected AtomicDouble balance; // Баланс карты

    public BankCard() {
        this.balance = new AtomicDouble(0.0);
    }

    public boolean pay(double amount) {
// Метод для оплаты (сумма списывается с карты)
        double currentBalance = balance.get();

        if (currentBalance >= amount) {
            balance.addAndGet(-amount);
            return true;
        } else {
            return false; // Недостаточно средств
        }
    }

    public double getBalance() {
// Получение информации о балансе
        return balance.get();
    }

    public abstract String getAvailableFundsInfo();
}