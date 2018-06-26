package com.capgemini.krk.services.subjectCard;

import com.capgemini.krk.TO.subjectCard.SubjectCardTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardsTO;

public interface SubjectCardService {

    SubjectCardsTO findAll();

    SubjectCardTO findById(int id);

    SubjectCardsTO findByCourseId(int id);

}
