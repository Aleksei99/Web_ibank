package by.ibank.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

public class History extends AbstractEntity {
    private int spentMoney;
    private Timestamp datePurchase;
    private CreditCard creditCardFrom;
    private CreditCard creditCardTo;

    public History(int spentMoney, Timestamp datePurchase) {
        this.spentMoney = spentMoney;
        this.datePurchase = datePurchase;
    }

    public History(int id, int spentMoney, Timestamp datePurchase) {
        super(id);
        this.spentMoney = spentMoney;
        this.datePurchase = datePurchase;
    }

    public History(int spentMoney, Timestamp datePurchase, CreditCard creditCardFrom, CreditCard creditCardTo) {
        this.spentMoney = spentMoney;
        this.datePurchase = datePurchase;
        this.creditCardFrom = creditCardFrom;
        this.creditCardTo = creditCardTo;
    }

    public History() {
    }

    public CreditCard getCreditCardTo() {
        return creditCardTo;
    }

    public void setCreditCardTo(CreditCard creditCardTo) {
        this.creditCardTo = creditCardTo;
    }

    public CreditCard getCreditCardFrom() {
        return creditCardFrom;
    }

    public void setCreditCardFrom(CreditCard creditCardFrom) {
        this.creditCardFrom = creditCardFrom;
    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(int spentMoney) {
        this.spentMoney = spentMoney;
    }

    public Timestamp getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Timestamp datePurchase) {
        this.datePurchase = datePurchase;
    }

    @Override
    public String toString() {
        return "by.ibank.entity.History{" +
                "spent_money=" + spentMoney +
                ", date_purchase=" + datePurchase +
                '}';
    }
}
