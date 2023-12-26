package model.services;

public class PayPalService implements OnlinePaymentServices{
    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;
    @Override
    public double payments(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, int mount) {
        return amount * MONTHLY_INTEREST * mount;
    }
}
