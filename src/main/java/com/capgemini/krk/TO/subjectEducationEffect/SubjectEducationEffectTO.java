package com.capgemini.krk.TO.subjectEducationEffect;

import com.capgemini.krk.TO.courseEducationEffect.CourseEducationEffectTO;
import com.capgemini.krk.TO.eeCategory.EECategoryTO;

import java.util.List;

public class SubjectEducationEffectTO {

    private int id;
    private String symbol;
    private String educationEffect;
    private EECategoryTO eeCategory;
    private List<CourseEducationEffectTO> courseEducationEffects;

    public SubjectEducationEffectTO(int id, String symbol, String educationEffect, EECategoryTO eeCategory, List<CourseEducationEffectTO> courseEducationEffects) {
        this.id = id;
        this.symbol = symbol;
        this.educationEffect = educationEffect;
        this.eeCategory = eeCategory;
        this.courseEducationEffects = courseEducationEffects;
    }

    public SubjectEducationEffectTO() {
    }

    public SubjectEducationEffectTO(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
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

    public List<CourseEducationEffectTO> getCourseEducationEffects() {
        return courseEducationEffects;
    }

    public void setCourseEducationEffects(List<CourseEducationEffectTO> courseEducationEffects) {
        this.courseEducationEffects = courseEducationEffects;
    }
}
