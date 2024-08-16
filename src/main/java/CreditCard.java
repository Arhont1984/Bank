import com.google.common.util.concurrent.AtomicDouble;

class CreditCard extends BankCard {
    private AtomicDouble creditLimit; // Кредитный лимит

    public CreditCard(double creditLimitAmount) {
        super();
        this.creditLimit = new AtomicDouble(creditLimitAmount);
    }

    @Override
    public boolean pay(double amount) {
// Метод для оплаты (оплата с собственных средств и кредита)
        double currentBalance = getBalance();
        double availableCredit = creditLimit.get();

        if (currentBalance >= amount) {
            balance.addAndGet(-amount);
            return true; // Оплата с собственных средств
        } else if (currentBalance + availableCredit >= amount) {
// Оплата с кредитных средств
            double remainingAmount = amount - currentBalance; // Сумма, списываемая из кредита
            creditLimit.addAndGet(-remainingAmount);
            balance.set(0); // Обнуляем баланс, так как все собственные средства потрачены
            return true; // Оплата с кредитных средств
        } else {
            return false; // Недостаточно средств
        }
    }

    public void topUp(double amount) {
// Метод для пополнения кредитной карты
        double currentDebt = creditLimit.get();
        if (currentDebt < 0) {
// Если есть задолженность, погасим ее сначала
            double debt = Math.abs(currentDebt);
            if (amount >= debt) {
                creditLimit.addAndGet(debt); // Погашаем долг
                amount -= debt; // Уменьшаем пополнение на сумму долга
            } else {
// Если недостаточно, просто уменьшаем задолженность
                creditLimit.addAndGet(amount);
                return;
            }
        }
// После погашения долгов пополняем собственные средства
        balance.addAndGet(amount);
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Доступные средства: " + getBalance() + ", Кредитный лимит: " + creditLimit.get();
    }
}