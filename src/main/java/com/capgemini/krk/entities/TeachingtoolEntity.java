package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teachingtool", schema = "krkdb", catalog = "")
public class TeachingtoolEntity {
    private int id;
    private String symbol;
    private String tool;
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
    @Column(name = "symbol", nullable = false, length = 255)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "tool", nullable = false, length = 255)
    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachingtoolEntity that = (TeachingtoolEntity) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(tool, that.tool);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, tool);
    }

    @ManyToMany(mappedBy = "teachingTools")
    public List<SubjectcardEntity> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectcardEntity> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
