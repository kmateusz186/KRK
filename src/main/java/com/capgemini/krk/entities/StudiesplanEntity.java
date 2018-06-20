package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "studiesplan", schema = "krkdb", catalog = "")
public class StudiesplanEntity {
    private int id;
    private List<SemesterEntity> semesters;
    private EducationprogramEntity educationProgram;

    @Id
    @Column(name = "ID", nullable = false)
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
        StudiesplanEntity that = (StudiesplanEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @OneToMany(mappedBy = "studiesPlan")
    public List<SemesterEntity> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterEntity> semesters) {
        this.semesters = semesters;
    }

    @ManyToOne
    @JoinColumn(name = "education_program", referencedColumnName = "ID", nullable = false)
    public EducationprogramEntity getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationprogramEntity educationProgram) {
        this.educationProgram = educationProgram;
    }
}
