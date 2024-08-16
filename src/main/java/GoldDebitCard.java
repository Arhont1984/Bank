class GoldDebitCard extends DebitCard {
    private BonusProgram bonusProgram;

    public GoldDebitCard(BonusProgram bonusProgram) {
        this.bonusProgram = bonusProgram;
    }

    @Override
    public void topUp(double amount) {
        super.topUp(amount);
        double bonus = bonusProgram.calculateBonus(amount);
        System.out.println("Бонусы за пополнение: " + bonus);
        this.balance.addAndGet(bonus);
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Доступные средства (включая бонусы): " + (getBalance() + bonusProgram.calculateBonus(getBalance()));
    }
}