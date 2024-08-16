class CashbackBonusProgram extends BonusProgram {
    @Override
    double calculateBonus(double amount) {
        return amount >= 5000 ? amount * 0.05 : 0; // 5% от покупок больше 5000
    }
}