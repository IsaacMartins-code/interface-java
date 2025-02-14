package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.EnterpriseService;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ContractService service = new ContractService(new EnterpriseService());

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int contractNumber = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), fmt);

        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int installmentsNumber = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);
        service.processContract(contract, installmentsNumber);

        System.out.println("PARCELAS: ");
        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

    }
}
