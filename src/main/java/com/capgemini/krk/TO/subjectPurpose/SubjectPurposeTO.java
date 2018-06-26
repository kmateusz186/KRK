package com.capgemini.krk.TO.subjectPurpose;

import com.capgemini.krk.TO.subjectCard.SubjectCardTO;

import java.util.List;

public class SubjectPurposeTO {
    private int id;
    private String symbol;
    private String purpose;
    private List<SubjectCardTO> subjectCards;

    public SubjectPurposeTO(int id, String symbol, String purpose, List<SubjectCardTO> subjectCards) {
        this.id = id;
        this.symbol = symbol;
        this.purpose = purpose;
        this.subjectCards = subjectCards;
    }

    public SubjectPurposeTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<SubjectCardTO> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectCardTO> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
