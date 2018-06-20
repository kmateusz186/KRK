package com.capgemini.krk.TO.specializationEducationEffect;

import com.capgemini.krk.TO.areaOfKnowledge.AreaOfKnowledgeTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.eeCategory.EECategoryTO;
import com.capgemini.krk.TO.scienceArea.ScienceAreaTO;

public class SpecializationEducationEffectTO {

    private int id;
    private String symbol;
    private String educationEffect;
    private String componentCode;
    private AreaOfKnowledgeTO areaOfKnowledge;
    private EECategoryTO eeCategory;
    private ScienceAreaTO scienceArea;

    public SpecializationEducationEffectTO(int id, String symbol, String educationEffect, String componentCode, AreaOfKnowledgeTO areaOfKnowledge, EECategoryTO eeCategory, ScienceAreaTO scienceArea) {
        this.id = id;
        this.symbol = symbol;
        this.educationEffect = educationEffect;
        this.componentCode = componentCode;
        this.areaOfKnowledge = areaOfKnowledge;
        this.eeCategory = eeCategory;
        this.scienceArea = scienceArea;
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

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public AreaOfKnowledgeTO getAreaOfKnowledge() {
        return areaOfKnowledge;
    }

    public void setAreaOfKnowledge(AreaOfKnowledgeTO areaOfKnowledge) {
        this.areaOfKnowledge = areaOfKnowledge;
    }

    public EECategoryTO getEeCategory() {
        return eeCategory;
    }

    public void setEeCategory(EECategoryTO eeCategory) {
        this.eeCategory = eeCategory;
    }

    public ScienceAreaTO getScienceArea() {
        return scienceArea;
    }

    public void setScienceArea(ScienceAreaTO scienceArea) {
        this.scienceArea = scienceArea;
    }
}
