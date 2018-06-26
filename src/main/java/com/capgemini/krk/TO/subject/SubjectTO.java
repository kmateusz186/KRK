package com.capgemini.krk.TO.subject;

import com.capgemini.krk.TO.courseEducationEffect.CourseEducationEffectTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardTO;

import java.util.List;

public class SubjectTO {
    private int id;
    private String namePL;
    private String nameEng;
    private String code;
    private String prerequisites;
    private List<CourseEducationEffectTO> courseEducationEffects;
    private List<SubjectCardTO> subjectCards;

    public SubjectTO(int id, String namePL, String nameEng, String code, String prerequisites, List<CourseEducationEffectTO> courseEducationEffects) {
        this.id = id;
        this.namePL = namePL;
        this.nameEng = nameEng;
        this.code = code;
        this.prerequisites = prerequisites;
        this.courseEducationEffects = courseEducationEffects;
    }

    public SubjectTO(int id) {
        this.id = id;
    }

    public SubjectTO(List<CourseEducationEffectTO> courseEducationEffects, List<SubjectCardTO> subjectCards) {
        this.courseEducationEffects = courseEducationEffects;
        this.subjectCards = subjectCards;
    }

    public SubjectTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<CourseEducationEffectTO> getCourseEducationEffects() {
        return courseEducationEffects;
    }

    public void setCourseEducationEffects(List<CourseEducationEffectTO> courseEducationEffects) {
        this.courseEducationEffects = courseEducationEffects;
    }

    public List<SubjectCardTO> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectCardTO> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
