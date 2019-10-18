package ua.com.ladyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class FinanceReason extends IdHolder {

    @Enumerated
    private InputFinanceType type;

    @Column
    private String reason;

    @Column
    private String note;

    public FinanceReason() {
    }

    public FinanceReason(InputFinanceType type, String reason, String note) {
        this.type = type;
        this.reason = reason;
        this.note = note;
    }

    public InputFinanceType getType() {
        return type;
    }

    public void setType(InputFinanceType type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
