class TopUpBonusProgram extends BonusProgram {
    @Override
    double calculateBonus(double amount) {
        return amount * 0.00005; // 0.005% от суммы пополнений
    }
}