package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subjectkeeper", schema = "krkdb", catalog = "")
public class SubjectkeeperEntity {
    private int id;
    private String name;
    private String surname;
    private List<SubjectcardEntity> subjectCards;

    @Id
    @Column(name = "ID", nullable = false)
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
    @Column(name = "surname", nullable = false, length = 255)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectkeeperEntity that = (SubjectkeeperEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname);
    }

    @ManyToMany
    @JoinTable(name = "subjectkeeper_subjectcard", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "subject_keeper_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "subject_card_ID", referencedColumnName = "ID", nullable = false))
    public List<SubjectcardEntity> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectcardEntity> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
