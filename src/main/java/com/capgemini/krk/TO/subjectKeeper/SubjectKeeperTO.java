package com.capgemini.krk.TO.subjectKeeper;

import com.capgemini.krk.TO.subjectCard.SubjectCardTO;

import java.util.List;

public class SubjectKeeperTO {
    private int id;
    private String name;
    private String surname;
    private List<SubjectCardTO> subjectCards;

    public SubjectKeeperTO(int id, String name, String surname, List<SubjectCardTO> subjectCards) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjectCards = subjectCards;
    }

    public SubjectKeeperTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<SubjectCardTO> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectCardTO> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
