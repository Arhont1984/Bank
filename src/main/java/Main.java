public class Main {
    public static void main(String[] args) {
        //Создадим дебетовую и кредитную карточки
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard(500.0);
        //Создадим для золотую карточку с кэшбэком.
        BonusProgram cashbackBonusProgram = new CashbackBonusProgram();
        DebitCard goldenDebitCard = new GoldDebitCard(cashbackBonusProgram);

        //Протестируем дебетовые и кретитные карточки
        debitCard.topUp(200.0);
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
        debitCard.pay(50.0);
        System.out.println("Баланс дебетовой карты после оплаты: " + debitCard.getBalance());

        creditCard.topUp(100.0);
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());
        creditCard.pay(600.0);
        System.out.println("Баланс кредитной карты после оплаты: " + creditCard.getBalance());
        System.out.println(creditCard.getAvailableFundsInfo());

        //Протестируем золотую карточку
        goldenDebitCard.topUp(5000);
        System.out.println("Баланс золотой дебетовой карты: " + goldenDebitCard.getBalance());

    }
}