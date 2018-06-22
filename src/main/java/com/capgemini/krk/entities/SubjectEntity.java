package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject", schema = "krkdb", catalog = "")
public class SubjectEntity {
    private int id;
    private String namePl;
    private String nameEng;
    private String code;
    private String prerequisites;
    private List<CourseEntity> courses;
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
    @Column(name = "name_PL", nullable = false, length = 255)
    public String getNamePl() {
        return namePl;
    }

    public void setNamePl(String namePl) {
        this.namePl = namePl;
    }

    @Basic
    @Column(name = "name_ENG", nullable = false, length = 255)
    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "prerequisites", nullable = false, length = 255)
    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return id == that.id &&
                Objects.equals(namePl, that.namePl) &&
                Objects.equals(nameEng, that.nameEng) &&
                Objects.equals(code, that.code) &&
                Objects.equals(prerequisites, that.prerequisites);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, namePl, nameEng, code, prerequisites);
    }

    @OneToMany(mappedBy = "subject")
    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @ManyToMany(mappedBy = "subjects")
    public List<CourseeducationeffectEntity> getCourseEducationEffects() {
        return courseEducationEffects;
    }

    public void setCourseEducationEffects(List<CourseeducationeffectEntity> courseEducationEffects) {
        this.courseEducationEffects = courseEducationEffects;
    }
}
