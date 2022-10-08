import java.math.BigDecimal;


public class Transport_card {
    private String id;
    private String type; //Тип карты
    private BigDecimal balance = BigDecimal.ZERO; // Баланс карты

    public Transport_card(String id, BigDecimal balance) {
        super();
        this.id = id;
        this.balance = balance;

    }

    // Запрашиваем остаток на балансе
    public BigDecimal request_Balance() {
        return balance;
    }

    //Оплата
    /*
    public boolean pay(Transport_card toTransport_card, BigDecimal amount) {
        if(toTransport_card == null || toTransport_card.getBalance() == null || amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 {
            System.out.println("Ошибка параметра!");
            return false;
        }

        if(amount.compareTo(balance)>= 0 ) {
            System.out.println("Недостаточно средств!");
            return false;
        }

        //Видимость передачи средств на ATM - банкомат
        toTransport_card.setBalance(toTransport_card.getBalance().add(amount));

        //Сумма списания
        this.setBalance(getBalance().subtract(amount));

        System.out.println("Успешная транзакция!");
        return true;
    }
    */

    public boolean deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Ошибка оператора!");
            return false;
        }

        // Текущая карта плюс сумма
        this.setBalance(getBalance().add(amount));

        System.out.println("Средства успошно внесены!");
        return true;
    }

    public boolean debit(BigDecimal amount) {
        if (getBalance() == null || amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Ошибка оператора!");
            return false;
        }

        if (amount.compareTo(balance) >= 0) {
            System.out.println("Недостаточно средств!");
            return false;
        }

        this.setBalance(getBalance().subtract(amount));
        System.out.println("Списание прошло успешно!");
        return true;

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

