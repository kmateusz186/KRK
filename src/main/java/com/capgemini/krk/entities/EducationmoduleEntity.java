package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "educationmodule", schema = "krkdb", catalog = "")
public class EducationmoduleEntity {
    private int id;
    private ModuletypeEntity moduleType;
    private EducationmoduleEntity ovModule;
    private List<StudiesprogramEntity> studiesPrograms;

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
        EducationmoduleEntity that = (EducationmoduleEntity) o;
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

    @OneToOne
    @JoinColumn(name = "ov_module", referencedColumnName = "ID")
    public EducationmoduleEntity getOvModule() {
        return ovModule;
    }

    public void setOvModule(EducationmoduleEntity ovModule) {
        this.ovModule = ovModule;
    }

    @ManyToMany(mappedBy = "educationModules")
    public List<StudiesprogramEntity> getStudiesPrograms() {
        return studiesPrograms;
    }

    public void setStudiesPrograms(List<StudiesprogramEntity> studiesPrograms) {
        this.studiesPrograms = studiesPrograms;
    }
}
