package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "studiesprogram", schema = "krkdb", catalog = "")
public class StudiesprogramEntity {
    private int id;
    private String description;
    private EducationprogramEntity educationProgram;
    private List<EducationmoduleEntity> educationModules;

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
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudiesprogramEntity that = (StudiesprogramEntity) o;
        return id == that.id &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description);
    }

    @OneToOne
    @JoinColumn(name = "education_program", referencedColumnName = "ID", nullable = false)
    public EducationprogramEntity getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationprogramEntity educationProgram) {
        this.educationProgram = educationProgram;
    }

    @ManyToMany
    @JoinTable(name = "studiesprogram_educationmodule", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "studies_program_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "education_module_ID", referencedColumnName = "ID", nullable = false))
    public List<EducationmoduleEntity> getEducationModules() {
        return educationModules;
    }

    public void setEducationModules(List<EducationmoduleEntity> educationModules) {
        this.educationModules = educationModules;
    }
}
