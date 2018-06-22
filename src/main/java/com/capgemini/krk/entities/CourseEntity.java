package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "krkdb", catalog = "")
public class CourseEntity {
    private int id;
    private String name;
    private int ects;
    private byte technical;
    private String code;
    private int zzuHours;
    private ClassestypeEntity classesType;
    private CoursetypeEntity courseType;
    private CoursesgroupEntity coursesGroup;
    private CourseformEntity form;
    private KindEntity kind;
    private PassingwayEntity passingWay;
    private SubjectEntity subject;
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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ects", nullable = false)
    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Basic
    @Column(name = "technical", nullable = false)
    public byte getTechnical() {
        return technical;
    }

    public void setTechnical(byte technical) {
        this.technical = technical;
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
    @Column(name = "zzu_hours", nullable = false)
    public int getZzuHours() {
        return zzuHours;
    }

    public void setZzuHours(int zzuHours) {
        this.zzuHours = zzuHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return id == that.id &&
                ects == that.ects &&
                technical == that.technical &&
                zzuHours == that.zzuHours &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, ects, technical, code, zzuHours);
    }

    @ManyToOne
    @JoinColumn(name = "classes_type", referencedColumnName = "ID", nullable = false)
    public ClassestypeEntity getClassesType() {
        return classesType;
    }

    public void setClassesType(ClassestypeEntity classesType) {
        this.classesType = classesType;
    }

    @ManyToOne
    @JoinColumn(name = "course_type", referencedColumnName = "ID", nullable = false)
    public CoursetypeEntity getCourseType() {
        return courseType;
    }

    public void setCourseType(CoursetypeEntity courseType) {
        this.courseType = courseType;
    }

    @ManyToOne
    @JoinColumn(name = "courses_group", referencedColumnName = "ID", nullable = false)
    public CoursesgroupEntity getCoursesGroup() {
        return coursesGroup;
    }

    public void setCoursesGroup(CoursesgroupEntity coursesGroup) {
        this.coursesGroup = coursesGroup;
    }

    @ManyToOne
    @JoinColumn(name = "form", referencedColumnName = "ID", nullable = false)
    public CourseformEntity getForm() {
        return form;
    }

    public void setForm(CourseformEntity form) {
        this.form = form;
    }

    @ManyToOne
    @JoinColumn(name = "kind", referencedColumnName = "ID", nullable = false)
    public KindEntity getKind() {
        return kind;
    }

    public void setKind(KindEntity kind) {
        this.kind = kind;
    }

    @ManyToOne
    @JoinColumn(name = "passing_way", referencedColumnName = "ID", nullable = false)
    public PassingwayEntity getPassingWay() {
        return passingWay;
    }

    public void setPassingWay(PassingwayEntity passingWay) {
        this.passingWay = passingWay;
    }

    @ManyToOne
    @JoinColumn(name = "subject", referencedColumnName = "ID", nullable = false)
    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    @ManyToMany(mappedBy = "courses")
    public List<CoursesmoduleEntity> getCoursesModules() {
        return coursesModules;
    }

    public void setCoursesModules(List<CoursesmoduleEntity> coursesModules) {
        this.coursesModules = coursesModules;
    }
}
