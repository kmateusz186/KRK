package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "changesuggestion", schema = "krkdb", catalog = "")
public class ChangesuggestionEntity {
    private int id;
    private String proposition;
    private String reason;
    private EvaluatorEntity evaluator;
    private EducationprogramEntity educationProgram;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "proposition", nullable = false, length = 255)
    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    @Basic
    @Column(name = "reason", nullable = false, length = 255)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangesuggestionEntity that = (ChangesuggestionEntity) o;
        return id == that.id &&
                Objects.equals(proposition, that.proposition) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, proposition, reason);
    }

    @ManyToOne
    @JoinColumn(name = "evaluator", referencedColumnName = "ID", nullable = false)
    public EvaluatorEntity getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(EvaluatorEntity evaluator) {
        this.evaluator = evaluator;
    }

    @ManyToOne
    @JoinColumn(name = "education_program", referencedColumnName = "ID")
    public EducationprogramEntity getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationprogramEntity educationProgram) {
        this.educationProgram = educationProgram;
    }
}
