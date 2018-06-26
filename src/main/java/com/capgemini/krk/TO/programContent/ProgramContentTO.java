package com.capgemini.krk.TO.programContent;

import com.capgemini.krk.TO.classesType.ClassesTypeTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardTO;

public class ProgramContentTO {
    private int id;
    private String symbol;
    private String content;
    private int hours;
    private ClassesTypeTO classesType;
    private SubjectCardTO subjectCard;

    public ProgramContentTO(int id, String symbol, String content, int hours, ClassesTypeTO classesType, SubjectCardTO subjectCard) {
        this.id = id;
        this.symbol = symbol;
        this.content = content;
        this.hours = hours;
        this.classesType = classesType;
        this.subjectCard = subjectCard;
    }

    public ProgramContentTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public ClassesTypeTO getClassesType() {
        return classesType;
    }

    public void setClassesType(ClassesTypeTO classesType) {
        this.classesType = classesType;
    }

    public SubjectCardTO getSubjectCard() {
        return subjectCard;
    }

    public void setSubjectCard(SubjectCardTO subjectCard) {
        this.subjectCard = subjectCard;
    }
}
