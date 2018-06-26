import {Component, OnInit} from "@angular/core";
import {SubjectCardService} from '../subject-card.service';
import {ActivatedRoute} from '@angular/router';
import {Course, SubjectCard} from '../../model/course.model';

@Component({
  selector: 'app-subject-card-overview',
  templateUrl: './subject-card-overview.component.html'
})
export class SubjectCardOverviewComponent implements OnInit {

  currentSubjectcards: SubjectCard[];

  constructor(private subjectCardService: SubjectCardService, private route: ActivatedRoute) {
  }

  selectedSubjectCard: SubjectCard = {
    id: null,
    link: null,
    programContents: [],
    subject: {id: null, namePL: null, nameEng: null, code: null, prerequisites: null, courseEducationEffects: [], subjectCards: null},
    teachingTools: [],
    subjectEducationEffects: [],
    subjectKeepers: [],
    subjectPurposes: [],
  };

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
        this.subjectCardService.findByCourseId(id).subscribe(
          courses => this.currentSubjectcards = courses
        );
    });
  }

  thereAreSubjectCardsToDisplay(): boolean {
    return this.currentSubjectcards && this.currentSubjectcards.length > 0;
  }

}
