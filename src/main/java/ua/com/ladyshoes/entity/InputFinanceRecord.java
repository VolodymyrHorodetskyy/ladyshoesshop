package ua.com.ladyshoes.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class InputFinanceRecord extends IdHolder {

    @Column
    private double amount;

    @Enumerated
    private InputFinanceType type;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<FinanceReason> reasons;

    public InputFinanceRecord() {
    }

    public InputFinanceRecord(double amount, InputFinanceType type) {
        this.amount = amount;
        this.type = type;
    }

    public InputFinanceRecord(double amount, InputFinanceType type, List<FinanceReason> reasons) {
        this.amount = amount;
        this.type = type;
        this.reasons = reasons;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public InputFinanceType getType() {
        return type;
    }

    public void setType(InputFinanceType type) {
        this.type = type;
    }

    public List<FinanceReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<FinanceReason> reasons) {
        this.reasons = reasons;
    }

    @Override
    public String toString() {
        return "InputFinanceRecord{" +
                "amount=" + amount +
                ", type=" + type +
                '}';
    }
}
