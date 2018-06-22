package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
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
    private ModeEntity mode;
    private ProfileEntity profile;
    private List<ChangesuggestionEntity> changeSuggestions;
    private List<CourseeducationeffectEntity> courseEducationEffects;
    private List<StudiesplanEntity> studiesPlans;
    private StudiesprogramEntity studiesProgram;

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
    @Column(name = "course", nullable = false, length = 255)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    @Column(name = "specialization", nullable = false, length = 255)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Basic
    @Column(name = "period", nullable = false, length = 255)
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

    @OneToMany(mappedBy = "educationProgram")
    public List<ChangesuggestionEntity> getChangeSuggestions() {
        return changeSuggestions;
    }

    public void setChangeSuggestions(List<ChangesuggestionEntity> changeSuggestions) {
        this.changeSuggestions = changeSuggestions;
    }

    @OneToMany(mappedBy = "educationProgram")
    public List<CourseeducationeffectEntity> getCourseEducationEffects() {
        return courseEducationEffects;
    }

    public void setCourseEducationEffects(List<CourseeducationeffectEntity> courseEducationEffects) {
        this.courseEducationEffects = courseEducationEffects;
    }

    @ManyToOne
    @JoinColumn(name = "faculty", referencedColumnName = "ID", nullable = false)
    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    @ManyToOne
    @JoinColumn(name = "level", referencedColumnName = "ID", nullable = false)
    public EducationlevelEntity getLevel() {
        return level;
    }

    public void setLevel(EducationlevelEntity level) {
        this.level = level;
    }

    @ManyToOne
    @JoinColumn(name = "mode", referencedColumnName = "ID", nullable = false)
    public ModeEntity getMode() {
        return mode;
    }

    public void setMode(ModeEntity mode) {
        this.mode = mode;
    }

    @ManyToOne
    @JoinColumn(name = "profile", referencedColumnName = "ID", nullable = false)
    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @OneToMany(mappedBy = "educationProgram")
    public List<StudiesplanEntity> getStudiesPlans() {
        return studiesPlans;
    }

    public void setStudiesPlans(List<StudiesplanEntity> studiesPlans) {
        this.studiesPlans = studiesPlans;
    }

    @OneToOne(mappedBy = "educationProgram")
    public StudiesprogramEntity getStudiesProgram() {
        return studiesProgram;
    }

    public void setStudiesProgram(StudiesprogramEntity studiesProgram) {
        this.studiesProgram = studiesProgram;
    }
}
