class SimpleBonusProgram extends BonusProgram {
    @Override
    double calculateBonus(double amount) {
        return amount * 0.01; // 1% от суммы покупок
    }
}