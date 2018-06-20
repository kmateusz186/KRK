package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subjectcard", schema = "krkdb", catalog = "")
public class SubjectcardEntity {
    private int id;
    private String link;
    private List<ProgramcontentEntity> programContents;
    private SubjectEntity subject;
    private List<TeachingtoolEntity> teachingTools;
    private List<SubjecteducationeffectEntity> subjectEducationEffects;
    private List<SubjectkeeperEntity> subjectKeepers;
    private List<SubjectpurposeEntity> subjectPurposes;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "link", nullable = false, length = 255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectcardEntity that = (SubjectcardEntity) o;
        return id == that.id &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, link);
    }

    @OneToMany(mappedBy = "subjectCard")
    public List<ProgramcontentEntity> getProgramContents() {
        return programContents;
    }

    public void setProgramContents(List<ProgramcontentEntity> programContents) {
        this.programContents = programContents;
    }

    @ManyToOne
    @JoinColumn(name = "subject", referencedColumnName = "ID", nullable = false)
    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    @ManyToMany
    @JoinTable(name = "subjectcard_teachingtool", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "subject_card_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "teaching_tool_ID", referencedColumnName = "ID", nullable = false))
    public List<TeachingtoolEntity> getTeachingTools() {
        return teachingTools;
    }

    public void setTeachingTools(List<TeachingtoolEntity> teachingTools) {
        this.teachingTools = teachingTools;
    }

    @ManyToMany(mappedBy = "subjectCards")
    public List<SubjecteducationeffectEntity> getSubjectEducationEffects() {
        return subjectEducationEffects;
    }

    public void setSubjectEducationEffects(List<SubjecteducationeffectEntity> subjectEducationEffects) {
        this.subjectEducationEffects = subjectEducationEffects;
    }

    @ManyToMany(mappedBy = "subjectCards")
    public List<SubjectkeeperEntity> getSubjectKeepers() {
        return subjectKeepers;
    }

    public void setSubjectKeepers(List<SubjectkeeperEntity> subjectKeepers) {
        this.subjectKeepers = subjectKeepers;
    }

    @ManyToMany(mappedBy = "subjectCards")
    public List<SubjectpurposeEntity> getSubjectPurposes() {
        return subjectPurposes;
    }

    public void setSubjectPurposes(List<SubjectpurposeEntity> subjectPurposes) {
        this.subjectPurposes = subjectPurposes;
    }
}
