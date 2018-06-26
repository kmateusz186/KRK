package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "coursesmodule", schema = "krkdb", catalog = "")
public class CoursesmoduleEntity {
    private int id;
    private ModuletypeEntity moduleType;
    private CoursesmoduleEntity ovModule;
    private List<CourseEntity> courses;
    private List<SemesterEntity> semesters;
    private List<CoursesmoduleEntity> ovModules;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesmoduleEntity that = (CoursesmoduleEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "module_type", referencedColumnName = "ID", nullable = false)
    public ModuletypeEntity getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuletypeEntity moduleType) {
        this.moduleType = moduleType;
    }

    @ManyToOne
    @OneToOne
    @JoinColumn(name = "ov_module", referencedColumnName = "ID")
    public CoursesmoduleEntity getOvModule() {
        return ovModule;
    }

    public void setOvModule(CoursesmoduleEntity ovModule) {
        this.ovModule = ovModule;
    }

    @ManyToMany
    @JoinTable(name = "coursesmodule_course", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "courses_module_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "ID", nullable = false))
    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @ManyToMany(mappedBy = "coursesModules")
    public List<SemesterEntity> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterEntity> semesters) {
        this.semesters = semesters;
    }

    @OneToMany(mappedBy = "ovModule")
    public List<CoursesmoduleEntity> getOvModules() {
        return ovModules;
    }

    public void setOvModules(List<CoursesmoduleEntity> ovModules) {
        this.ovModules = ovModules;
    }
}
