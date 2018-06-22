package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subjectpurpose", schema = "krkdb", catalog = "")
public class SubjectpurposeEntity {
    private int id;
    private String symbol;
    private String purpose;
    private List<SubjectcardEntity> subjectCards;

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
    @Column(name = "symbol", nullable = false, length = 255)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "purpose", nullable = false, length = 255)
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectpurposeEntity that = (SubjectpurposeEntity) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(purpose, that.purpose);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, purpose);
    }

    @ManyToMany
    @JoinTable(name = "subjectpurpose_subjectcard", catalog = "", schema = "krkdb", joinColumns = @JoinColumn(name = "subject_purpose_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "subject_card_ID", referencedColumnName = "ID", nullable = false))
    public List<SubjectcardEntity> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectcardEntity> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
