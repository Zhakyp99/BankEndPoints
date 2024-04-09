package com.example.solidbank;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI {
    private Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    private void tryAgain() {
        System.out.println("Error, that is not a valid input, try again!");
        this.scanner.next();
    }

    public double requestClientAmount() {
        System.out.println("Type amount of money");
        double amount;
        while (true) {
            if (!this.scanner.hasNextDouble()) {
                tryAgain();
                continue;
            }
            amount = this.scanner.nextDouble();
            if (amount < 0) {
                tryAgain();
                continue;
            }
            break;
        }
        this.scanner.nextLine();
        return amount;
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        return this.scanner.nextLine();
    }

    public String requestAccountType() {
        System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
        String accountTypeName = this.scanner.nextLine();
        if (!accountTypeName.equals("CHECKING") && !accountTypeName.equals("SAVING") && !accountTypeName.equals("FIXED")) {
            System.out.println("Error, you entered wrong account type, try again!");
            return null;
        } else {
            return accountTypeName;
        }
    }
}
