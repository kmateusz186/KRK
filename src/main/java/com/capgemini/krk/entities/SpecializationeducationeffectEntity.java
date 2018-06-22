package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "specializationeducationeffect", schema = "krkdb", catalog = "")
public class SpecializationeducationeffectEntity {
    private int id;
    private String symbol;
    private String educationEffect;
    private String componentCode;
    private AreaofknowledgeEntity areaOfKnowledge;
    private EecategoryEntity category;
    private ScienceareaEntity scienceArea;
    private List<CourseeducationeffectEntity> courseEducationEffects;

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
        SpecializationeducationeffectEntity that = (SpecializationeducationeffectEntity) o;
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
    @JoinColumn(name = "science_area", referencedColumnName = "ID", nullable = false)
    public ScienceareaEntity getScienceArea() {
        return scienceArea;
    }

    public void setScienceArea(ScienceareaEntity scienceArea) {
        this.scienceArea = scienceArea;
    }

    @ManyToMany
    @JoinTable(name = "specializationeducationeffect_courseeducationeffect", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "specialization_education_effect_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "course_education_effect_ID", referencedColumnName = "ID", nullable = false))
    public List<CourseeducationeffectEntity> getCourseEducationEffects() {
        return courseEducationEffects;
    }

    public void setCourseEducationEffects(List<CourseeducationeffectEntity> courseEducationEffects) {
        this.courseEducationEffects = courseEducationEffects;
    }
}
