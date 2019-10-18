package ua.com.ladyshoes.request;

import ua.com.ladyshoes.entity.InputFinanceType;

import java.util.List;

public class AddInputFinanceRecordRequest {

    private double amount;

    private InputFinanceType type;

    private List<Long> reasonsIds;

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

    public List<Long> getReasonsIds() {
        return reasonsIds;
    }

    public void setReasonsIds(List<Long> reasonsIds) {
        this.reasonsIds = reasonsIds;
    }
}
