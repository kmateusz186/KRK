package com.capgemini.krk.TO.ChangeSuggestion;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.evaluator.EvaluatorTO;
import lombok.*;

public class ChangeSuggestionTO {

    private int id;

    private EvaluatorTO evaluator;

    private EducationProgramTO educationProgram;

    private String proposition;

    private String reason;

    public ChangeSuggestionTO(int id, EvaluatorTO evaluator, EducationProgramTO educationProgram, String proposition, String reason) {
        this.id = id;
        this.evaluator = evaluator;
        this.educationProgram = educationProgram;
        this.proposition = proposition;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EvaluatorTO getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(EvaluatorTO evaluator) {
        this.evaluator = evaluator;
    }

    public EducationProgramTO getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationProgramTO educationProgram) {
        this.educationProgram = educationProgram;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
