import {Component, OnInit} from "@angular/core";
import {EducationProgram} from '../../model/education-program.model';
import {EducationProgramService} from '../education-program.service';

@Component({
  selector: 'app-education-program-overview',
  templateUrl: './education-program-overview.component.html'
})
export class EducationProgramOverviewComponent implements OnInit {

  currentEducationPrograms: EducationProgram[];

  constructor(private educationProgramService: EducationProgramService) {
  }

  selectedEducationProgram: EducationProgram = {
    id: null,
    level: null,
    profile: null,
    course: null,
    specialization: null,
    mode: null,
    period: null,
    faculty: null,
    changeSuggestions: null,
    courseEducationEffects: null,
  };

  showEducationProgramDeleted: boolean;

  selectAndDeleteEducationProgram(educationProgram: EducationProgram) {
    this.selectedEducationProgram = educationProgram;
    this.deleteEducationProgram();
  }

  ngOnInit(): void {
    this.educationProgramService.findAll().subscribe(
      (educationPrograms) => {
        this.currentEducationPrograms = educationPrograms;
      }
    );
  }

  deleteEducationProgram(): void {
    this.educationProgramService.deleteEducationProgram(this.selectedEducationProgram.id).subscribe(
      success => {
        this.showEducationProgramDeleted = true;
        console.log('ok');
      },
      error => {
        console.log('error' + this.selectedEducationProgram);
      }
    );
  }

  thereAreEducationProgramsToDisplay(): boolean {
    return this.currentEducationPrograms && this.currentEducationPrograms.length > 0;
  }

}
