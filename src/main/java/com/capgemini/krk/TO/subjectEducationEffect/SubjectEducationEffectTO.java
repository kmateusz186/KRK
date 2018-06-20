package com.capgemini.krk.TO.subjectEducationEffect;

import com.capgemini.krk.TO.eeCategory.EECategoryTO;

public class SubjectEducationEffectTO {

    private int id;
    private String symbol;
    private String educationEffect;
    private EECategoryTO eeCategory;

    public SubjectEducationEffectTO(int id, String symbol, String educationEffect, EECategoryTO eeCategory) {
        this.id = id;
        this.symbol = symbol;
        this.educationEffect = educationEffect;
        this.eeCategory = eeCategory;
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

    public String getEducationEffect() {
        return educationEffect;
    }

    public void setEducationEffect(String educationEffect) {
        this.educationEffect = educationEffect;
    }

    public EECategoryTO getEeCategory() {
        return eeCategory;
    }

    public void setEeCategory(EECategoryTO eeCategory) {
        this.eeCategory = eeCategory;
    }
}
