package com.capgemini.krk.TO.course;

import com.capgemini.krk.TO.classesType.ClassesTypeTO;
import com.capgemini.krk.TO.courseForm.CourseFormTO;
import com.capgemini.krk.TO.courseType.CourseTypeTO;
import com.capgemini.krk.TO.coursesGroup.CoursesGroupTO;
import com.capgemini.krk.TO.kind.KindTO;
import com.capgemini.krk.TO.passingWay.PassingWayTO;
import com.capgemini.krk.TO.subject.SubjectTO;

public class CourseTO {
    private int id;
    private String name;
    private int ects;
    private byte technical;
    private String code;
    private int zzuHours;
    private ClassesTypeTO classesType;
    private CourseTypeTO courseType;
    private CoursesGroupTO coursesGroup;
    private CourseFormTO courseForm;
    private KindTO kind;
    private PassingWayTO passingWay;
    private SubjectTO subject;

    public CourseTO(int id, String name, int ects, byte technical, String code, int zzuHours, ClassesTypeTO classesType, CourseTypeTO courseType, CoursesGroupTO coursesGroup, CourseFormTO courseForm, KindTO kind, PassingWayTO passingWay, SubjectTO subject) {
        this.id = id;
        this.name = name;
        this.ects = ects;
        this.technical = technical;
        this.code = code;
        this.zzuHours = zzuHours;
        this.classesType = classesType;
        this.courseType = courseType;
        this.coursesGroup = coursesGroup;
        this.courseForm = courseForm;
        this.kind = kind;
        this.passingWay = passingWay;
        this.subject = subject;
    }

    public CourseTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public byte getTechnical() {
        return technical;
    }

    public void setTechnical(byte technical) {
        this.technical = technical;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getZzuHours() {
        return zzuHours;
    }

    public void setZzuHours(int zzuHours) {
        this.zzuHours = zzuHours;
    }

    public ClassesTypeTO getClassesType() {
        return classesType;
    }

    public void setClassesType(ClassesTypeTO classesType) {
        this.classesType = classesType;
    }

    public CourseTypeTO getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseTypeTO courseType) {
        this.courseType = courseType;
    }

    public CoursesGroupTO getCoursesGroup() {
        return coursesGroup;
    }

    public void setCoursesGroup(CoursesGroupTO coursesGroup) {
        this.coursesGroup = coursesGroup;
    }

    public CourseFormTO getCourseForm() {
        return courseForm;
    }

    public void setCourseForm(CourseFormTO courseForm) {
        this.courseForm = courseForm;
    }

    public KindTO getKind() {
        return kind;
    }

    public void setKind(KindTO kind) {
        this.kind = kind;
    }

    public PassingWayTO getPassingWay() {
        return passingWay;
    }

    public void setPassingWay(PassingWayTO passingWay) {
        this.passingWay = passingWay;
    }

    public SubjectTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectTO subject) {
        this.subject = subject;
    }
}
