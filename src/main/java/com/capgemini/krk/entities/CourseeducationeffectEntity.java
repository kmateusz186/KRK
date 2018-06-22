package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courseeducationeffect", schema = "krkdb", catalog = "")
public class CourseeducationeffectEntity {
    private int id;
    private String symbol;
    private String educationEffect;
    private String componentCode;
    private AreaofknowledgeEntity areaOfKnowledge;
    private EecategoryEntity category;
    private EducationprogramEntity educationProgram;
    private ScienceareaEntity scienceArea;
    private List<SubjectEntity> subjects;
    private List<SubjecteducationeffectEntity> subjectEducationEffects;
    private List<SpecializationeducationeffectEntity> specializationEducationEffects;

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

    @Basic
    @Column(name = "component_code", nullable = false, length = 255)
    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseeducationeffectEntity that = (CourseeducationeffectEntity) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(educationEffect, that.educationEffect) &&
                Objects.equals(componentCode, that.componentCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, educationEffect, componentCode);
    }

    @ManyToOne
    @JoinColumn(name = "area_of_knowledge", referencedColumnName = "ID", nullable = false)
    public AreaofknowledgeEntity getAreaOfKnowledge() {
        return areaOfKnowledge;
    }

    public void setAreaOfKnowledge(AreaofknowledgeEntity areaOfKnowledge) {
        this.areaOfKnowledge = areaOfKnowledge;
    }

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "ID", nullable = false)
    public EecategoryEntity getCategory() {
        return category;
    }

    public void setCategory(EecategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "education_program", referencedColumnName = "ID", nullable = false)
    public EducationprogramEntity getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationprogramEntity educationProgram) {
        this.educationProgram = educationProgram;
    }

    @ManyToOne
    @JoinColumn(name = "science_area", referencedColumnName = "ID", nullable = false)
    public ScienceareaEntity getScienceArea() {
        return scienceArea;
    }

    public void setScienceArea(ScienceareaEntity scienceArea) {
        this.scienceArea = scienceArea;
    }

    @ManyToMany
    @JoinTable(name = "courseeducationeffect_subject", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "course_education_effect_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "subject_ID", referencedColumnName = "ID", nullable = false))
    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    @ManyToMany
    @JoinTable(name = "courseeducationeffect_subjecteducationeffect", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "course_education_effect_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "subject_education_effect_ID", referencedColumnName = "ID", nullable = false))
    public List<SubjecteducationeffectEntity> getSubjectEducationEffects() {
        return subjectEducationEffects;
    }

    public void setSubjectEducationEffects(List<SubjecteducationeffectEntity> subjectEducationEffects) {
        this.subjectEducationEffects = subjectEducationEffects;
    }

    @ManyToMany(mappedBy = "courseEducationEffects")
    public List<SpecializationeducationeffectEntity> getSpecializationEducationEffects() {
        return specializationEducationEffects;
    }

    public void setSpecializationEducationEffects(List<SpecializationeducationeffectEntity> specializationEducationEffects) {
        this.specializationEducationEffects = specializationEducationEffects;
    }
}
