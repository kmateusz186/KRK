package com.capgemini.krk.TO.subjectCard;

import java.util.List;

public class SubjectCardsTO {
    private List<SubjectCardTO> subjectCards;

    public SubjectCardsTO(List<SubjectCardTO> subjectCards) {
        this.subjectCards = subjectCards;
    }

    public SubjectCardsTO() {
    }

    public List<SubjectCardTO> getSubjectCards() {
        return subjectCards;
    }

    public void setSubjectCards(List<SubjectCardTO> subjectCards) {
        this.subjectCards = subjectCards;
    }
}
