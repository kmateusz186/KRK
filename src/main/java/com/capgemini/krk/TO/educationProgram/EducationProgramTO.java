package com.capgemini.krk.TO.educationProgram;

import com.capgemini.krk.TO.educationLevel.EducationLevelTO;
import com.capgemini.krk.TO.faculty.FacultyTO;
import com.capgemini.krk.TO.mode.ModeTO;
import com.capgemini.krk.TO.profile.ProfileTO;
import lombok.*;

public class EducationProgramTO {

    private int id;
    private EducationLevelTO level;
    private ProfileTO profile;
    private String course;
    private String specialization;
    private ModeTO mode;
    private String period;
    private FacultyTO faculty;

    public EducationProgramTO(int id, EducationLevelTO level, ProfileTO profile, String course, String specialization, ModeTO mode, String period, FacultyTO faculty) {
        this.id = id;
        this.level = level;
        this.profile = profile;
        this.course = course;
        this.specialization = specialization;
        this.mode = mode;
        this.period = period;
        this.faculty = faculty;
    }

    public EducationProgramTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EducationLevelTO getLevel() {
        return level;
    }

    public void setLevel(EducationLevelTO level) {
        this.level = level;
    }

    public ProfileTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileTO profile) {
        this.profile = profile;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ModeTO getMode() {
        return mode;
    }

    public void setMode(ModeTO mode) {
        this.mode = mode;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public FacultyTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyTO faculty) {
        this.faculty = faculty;
    }
}
