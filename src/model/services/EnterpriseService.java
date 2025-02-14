package model.services;

public class EnterpriseService implements OnlinePaymentService {

    public EnterpriseService() {
    }

    @Override
    public Double paymentFee(Double amount) {
        return amount + amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer month) {
        return amount + amount * 0.01 * month;
    }
}
