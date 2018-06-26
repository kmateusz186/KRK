package com.capgemini.krk.TO.teachingTool;

import com.capgemini.krk.TO.subjectCard.SubjectCardTO;

import java.util.List;

public class TeachingToolTO {
    private int id;
    private String symbol;
    private String tool;
    private List<SubjectCardTO> subjectCards;

    public TeachingToolTO(int id, String symbol, String tool, List<SubjectCardTO> subjectCards) {
        this.id = id;
        this.symbol = symbol;
        this.tool = tool;
        this.subjectCards = subjectCards;
    }

    public TeachingToolTO() {
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

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public List<SubjectCardTO> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectCardTO> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
