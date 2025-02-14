package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;

        for(int i = 1; i <= months; ++i) {

            double interest = this.paymentService.interest(basicQuota, i);
            double quota = this.paymentService.paymentFee(interest);

            LocalDate DueDate = contract.getDate().plusMonths(i);
            contract.getInstallments().add(new Installment(DueDate, quota));
        }

    }
}