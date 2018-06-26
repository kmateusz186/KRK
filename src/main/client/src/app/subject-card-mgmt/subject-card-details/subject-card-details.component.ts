import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {SubjectCardService} from '../subject-card.service';
import {Course, SubjectCard} from '../../model/course.model';


@Component({
  selector: 'app-subject-card-details',
  templateUrl: './subject-card-details.component.html',
  styleUrls: ['./subject-card-details.component.scss']
})
export class SubjectCardDetailsComponent implements OnInit {

  subjectCard: SubjectCard = {
    id: null,
    link: null,
    programContents: [],
    subject: {id: null, namePL: null, nameEng: null, code: null, prerequisites: null, courseEducationEffects: [], subjectCards: null},
    teachingTools: [],
    subjectEducationEffects: [],
    subjectKeepers: [],
    subjectPurposes: [],
  };

  constructor(private subjectCardService: SubjectCardService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id =+params['id'];
        this.subjectCardService.findById(id).subscribe(
          course => this.subjectCard = course
        );
    });
  }
}
