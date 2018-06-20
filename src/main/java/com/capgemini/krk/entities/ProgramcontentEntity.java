package com.capgemini.krk.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "programcontent", schema = "krkdb", catalog = "")
public class ProgramcontentEntity {
    private int id;
    private String symbol;
    private String content;
    private int hours;
    private ClassestypeEntity classesType;
    private SubjectcardEntity subjectCard;

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
    @Column(name = "content", nullable = false, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "hours", nullable = false)
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramcontentEntity that = (ProgramcontentEntity) o;
        return id == that.id &&
                hours == that.hours &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, content, hours);
    }

    @ManyToOne
    @JoinColumn(name = "classes_type", referencedColumnName = "ID", nullable = false)
    public ClassestypeEntity getClassesType() {
        return classesType;
    }

    public void setClassesType(ClassestypeEntity classesType) {
        this.classesType = classesType;
    }

    @ManyToOne
    @JoinColumn(name = "subject_card", referencedColumnName = "ID", nullable = false)
    public SubjectcardEntity getSubjectCard() {
        return subjectCard;
    }

    public void setSubjectCard(SubjectcardEntity subjectCard) {
        this.subjectCard = subjectCard;
    }
}
