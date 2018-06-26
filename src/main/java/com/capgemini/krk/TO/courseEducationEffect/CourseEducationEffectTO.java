package com.capgemini.krk.TO.courseEducationEffect;

import com.capgemini.krk.TO.areaOfKnowledge.AreaOfKnowledgeTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.eeCategory.EECategoryTO;
import com.capgemini.krk.TO.scienceArea.ScienceAreaTO;
import com.capgemini.krk.TO.subjectEducationEffect.SubjectEducationEffectTO;

import java.util.List;

public class CourseEducationEffectTO {

    private int id;
    private String symbol;
    private String educationEffect;
    private String componentCode;
    private AreaOfKnowledgeTO areaOfKnowledge;
    private EECategoryTO category;
    private ScienceAreaTO scienceArea;
    private EducationProgramTO educationProgram;
    private List<SubjectEducationEffectTO> subjectEducationEffects;

    public CourseEducationEffectTO(int id, String symbol, String educationEffect, String componentCode, AreaOfKnowledgeTO areaOfKnowledge, EECategoryTO category, ScienceAreaTO scienceArea, EducationProgramTO educationProgram) {
        this.id = id;
        this.symbol = symbol;
        this.educationEffect = educationEffect;
        this.componentCode = componentCode;
        this.areaOfKnowledge = areaOfKnowledge;
        this.category = category;
        this.scienceArea = scienceArea;
        this.educationProgram = educationProgram;
    }

    public CourseEducationEffectTO(int id, String symbol, String educationEffect, String componentCode, AreaOfKnowledgeTO areaOfKnowledge, EECategoryTO category, ScienceAreaTO scienceArea) {
        this.id = id;
        this.symbol = symbol;
        this.educationEffect = educationEffect;
        this.componentCode = componentCode;
        this.areaOfKnowledge = areaOfKnowledge;
        this.category = category;
        this.scienceArea = scienceArea;
    }

    public CourseEducationEffectTO(int id, String symbol, String educationEffect, String componentCode, AreaOfKnowledgeTO areaOfKnowledge, EECategoryTO category, ScienceAreaTO scienceArea, EducationProgramTO educationProgram, List<SubjectEducationEffectTO> subjectEducationEffects) {
        this.id = id;
        this.symbol = symbol;
        this.educationEffect = educationEffect;
        this.componentCode = componentCode;
        this.areaOfKnowledge = areaOfKnowledge;
        this.category = category;
        this.scienceArea = scienceArea;
        this.educationProgram = educationProgram;
        this.subjectEducationEffects = subjectEducationEffects;
    }

    public CourseEducationEffectTO(String symbol) {
        this.symbol = symbol;
    }

    public CourseEducationEffectTO(String symbol, String educationEffect) {
        this.symbol = symbol;
        this.educationEffect = educationEffect;
    }

    public CourseEducationEffectTO(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public CourseEducationEffectTO() {
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

    public EECategoryTO getCategory() {
        return category;
    }

    public void setCategory(EECategoryTO category) {
        this.category = category;
    }

    public ScienceAreaTO getScienceArea() {
        return scienceArea;
    }

    public void setScienceArea(ScienceAreaTO scienceArea) {
        this.scienceArea = scienceArea;
    }

    public EducationProgramTO getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationProgramTO educationProgram) {
        this.educationProgram = educationProgram;
    }

    public List<SubjectEducationEffectTO> getSubjectEducationEffects() {
        return subjectEducationEffects;
    }

    public void setSubjectEducationEffects(List<SubjectEducationEffectTO> subjectEducationEffects) {
        this.subjectEducationEffects = subjectEducationEffects;
    }
}
