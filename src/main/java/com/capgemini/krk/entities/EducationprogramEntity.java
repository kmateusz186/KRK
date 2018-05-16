package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "educationprogram", schema = "krkdb", catalog = "")
public class EducationprogramEntity {
    private int id;
    private String course;
    private String specialization;
    private String period;
    private FacultyEntity faculty;
    private EducationlevelEntity level;
    private ProfileEntity profile;
    private ModeEntity mode;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Course", nullable = false, length = 255)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    @Column(name = "Specialization", nullable = false, length = 255)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Basic
    @Column(name = "Period", nullable = false, length = 255)
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationprogramEntity that = (EducationprogramEntity) o;
        return id == that.id &&
                Objects.equals(course, that.course) &&
                Objects.equals(specialization, that.specialization) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, course, specialization, period);
    }

    @ManyToOne
    @JoinColumn(name = "Faculty", referencedColumnName = "ID", nullable = false)
    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    @ManyToOne
    @JoinColumn(name = "Level", referencedColumnName = "ID", nullable = false)
    public EducationlevelEntity getLevel() {
        return level;
    }

    public void setLevel(EducationlevelEntity level) {
        this.level = level;
    }

    @ManyToOne
    @JoinColumn(name = "Profile", referencedColumnName = "ID", nullable = false)
    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @ManyToOne
    @JoinColumn(name = "Mode", referencedColumnName = "ID", nullable = false)
    public ModeEntity getMode() {
        return mode;
    }

    public void setMode(ModeEntity mode) {
        this.mode = mode;
    }
}
