package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "semester", schema = "krkdb", catalog = "")
public class SemesterEntity {
    private int id;
    private int number;
    private StudiesplanEntity studiesPlan;
    private List<CoursesmoduleEntity> coursesModules;

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
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterEntity that = (SemesterEntity) o;
        return id == that.id &&
                number == that.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number);
    }

    @ManyToOne
    @JoinColumn(name = "studies_plan", referencedColumnName = "ID", nullable = false)
    public StudiesplanEntity getStudiesPlan() {
        return studiesPlan;
    }

    public void setStudiesPlan(StudiesplanEntity studiesPlan) {
        this.studiesPlan = studiesPlan;
    }

    @ManyToMany
    @JoinTable(name = "semester_coursesmodule", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "semester_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "courses_module_ID", referencedColumnName = "ID", nullable = false))
    public List<CoursesmoduleEntity> getCoursesModules() {
        return coursesModules;
    }

    public void setCoursesModules(List<CoursesmoduleEntity> coursesModules) {
        this.coursesModules = coursesModules;
    }
}
