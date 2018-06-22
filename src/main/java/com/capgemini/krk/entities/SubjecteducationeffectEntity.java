package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subjecteducationeffect", schema = "krkdb", catalog = "")
public class SubjecteducationeffectEntity {
    private int id;
    private String symbol;
    private String educationEffect;
    private List<CourseeducationeffectEntity> courseEducationEffects;
    private EecategoryEntity category;
    private List<SubjectcardEntity> subjectCards;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "symbol", nullable = false, length = 255)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "education_effect", nullable = false, length = 255)
    public String getEducationEffect() {
        return educationEffect;
    }

    public void setEducationEffect(String educationEffect) {
        this.educationEffect = educationEffect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjecteducationeffectEntity that = (SubjecteducationeffectEntity) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(educationEffect, that.educationEffect);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, educationEffect);
    }

    @ManyToMany(mappedBy = "subjectEducationEffects")
    public List<CourseeducationeffectEntity> getCourseEducationEffects() {
        return courseEducationEffects;
    }

    public void setCourseEducationEffects(List<CourseeducationeffectEntity> courseEducationEffects) {
        this.courseEducationEffects = courseEducationEffects;
    }

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "ID", nullable = false)
    public EecategoryEntity getCategory() {
        return category;
    }

    public void setCategory(EecategoryEntity category) {
        this.category = category;
    }

    @ManyToMany
    @JoinTable(name = "subjecteducationeffect_subjectcard", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "subject_education_effect_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "subject_card_ID", referencedColumnName = "ID", nullable = false))
    public List<SubjectcardEntity> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectcardEntity> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
