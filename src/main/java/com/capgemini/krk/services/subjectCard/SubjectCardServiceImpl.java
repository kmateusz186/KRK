package com.capgemini.krk.services.subjectCard;

import com.capgemini.krk.TO.subjectCard.SubjectCardTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardsTO;
import com.capgemini.krk.entities.*;
import com.capgemini.krk.mappers.SubjectCardMapper;
import com.capgemini.krk.repositories.course.CourseRepository;
import com.capgemini.krk.repositories.subjectCard.SubjectCardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCardServiceImpl implements SubjectCardService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectCardRepository subjectCardRepository;

    @Override
    public SubjectCardsTO findAll() {
        List<SubjectcardEntity> subjectCards = subjectCardRepository.findAll();

        List<SubjectCardTO> subjectCardTOList = subjectCards.stream()
                    .map(SubjectCardMapper::mapToTO)
                    .collect(Collectors.toList());

        SubjectCardsTO subjectCardsTO = new SubjectCardsTO(subjectCardTOList);

        return subjectCardsTO;
    }

    @Override
    public SubjectCardsTO findByCourseId(int id) {
        CourseEntity courseEntity = courseRepository.findById(id);
        List<SubjectcardEntity> subjectCards = courseEntity.getSubject().getSubjectCards();

        List<SubjectCardTO> subjectCardTOList = subjectCards.stream()
                .map(SubjectCardMapper::mapToTO)
                .collect(Collectors.toList());

        SubjectCardsTO subjectCardsTO = new SubjectCardsTO(subjectCardTOList);

        return subjectCardsTO;
    }

    @Override
    public SubjectCardTO findById(int id) {
        SubjectcardEntity subjectCard = subjectCardRepository.findById(id);
        SubjectCardTO subjectCardTO = SubjectCardMapper.mapToTO(subjectCard);
        return subjectCardTO;
    }
}
