package model.services;

public interface OnlinePaymentServices {
    double payments(double amount);
    double interest(double amount,int mount);
}
