package ua.com.ladyshoes.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FinanceReason extends Audit {

    @Enumerated
    private InputFinanceType type;

    @Column
    private String reason;

    @Column
    private String note;

    @ManyToMany
    private List<InputFinanceRecord> records;

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

    public List<InputFinanceRecord> getRecords() {
        return records;
    }

    public void setRecords(List<InputFinanceRecord> records) {
        this.records = records;
    }
}
