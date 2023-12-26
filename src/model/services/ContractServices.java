package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractServices {
    private OnlinePaymentServices onlinePaymentServices;

    public ContractServices(OnlinePaymentServices onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }

    public void processService(Contract contract,int mount){

        double basicQuota = contract.getTotalValue() / mount;

        for (int i = 0; i < mount; i++){
            LocalDate dueData = contract.getDate().plusMonths(i);
            double interest = onlinePaymentServices.interest(basicQuota,i);
            double fee = onlinePaymentServices.payments(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueData,quota));

        }

    }

    public OnlinePaymentServices getOnlinePaymentServices() {
        return onlinePaymentServices;
    }

    public void setOnlinePaymentServices(OnlinePaymentServices onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }
}
