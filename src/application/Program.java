package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractServices;
import model.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com o número de contratos: ");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Data (00/00/0000): ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number,date,totalValue);

        System.out.println();
        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();

        ContractServices contractServices = new ContractServices(new PayPalService());

        contractServices.processService(contract,n);

        System.out.println("Parcelas: ");
        for (Installment installment: contract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
