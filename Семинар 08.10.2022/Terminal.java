import java.math.BigDecimal;
import java.util.Scanner;


public class Terminal {
    private Transport_card transport_card;
    public Transport_card createTransport_card() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Номер карты: ");
        String id = scanner.nextLine();
        System.out.println(id);

        while (id == null || "".equals(id)) {
            System.out.println("Выведите номер карты: ");
            id = scanner.nextLine();
        }

        System.out.println("Выведите сумму депозита: ");
        BigDecimal amount = scanner.nextBigDecimal();
        Transport_card newTransport_card = new Transport_card(id, amount);
        scanner.close();
        this.transport_card = newTransport_card;
        return newTransport_card;

    }

    public void depositMoney(BigDecimal amount) {
        this.transport_card.deposit(amount);
    }

    public void debitMoney(BigDecimal amount) {
        this.transport_card.debit(amount);
    }

    public void requestBalance() {
        System.out.println(this.transport_card.request_Balance());
    }

    public void exit() {
        System.out.println ("Операция завершена!");
        this.transport_card = null;
    }

    public static void main(String[] args){
        Terminal terminal = new Terminal();
        terminal.createTransport_card();
        terminal.requestBalance();
        terminal.createTransport_card();
        terminal.depositMoney(new BigDecimal());
        terminal.debitMoney(new BigDecimal());
        terminal.exit();


    }


    }