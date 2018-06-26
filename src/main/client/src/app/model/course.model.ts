
export interface Course {
  id: number;
  name: string;
  ects: number;
  technical: boolean;
  code: string;
  zzuHours: number;
  classesType: ClassesType;
  courseType: CourseType;
  coursesGroup: CoursesGroup;
  courseForm: CourseForm;
  kind: Kind;
  passingWay: PassingWay;
  subject: Subject;
}

export interface ClassesType {
  id: number;
  name: string;
}

export interface CourseType {
  id: number;
  name: string;
}

export interface CoursesGroup {
  id: number;
  name: string;
  courses: Course[];
}

export interface CourseForm {
  id: number;
  name: string;
}

export interface Kind {
  id: number;
  name: string;
}

export interface PassingWay {
  id: number;
  name: string;
}

export interface Subject {
  id: number;
  namePL: string;
  nameEng: string;
  code: string;
  prerequisites: string;
  courseEducationEffects: CourseEducationEffect[];
  subjectCards: SubjectCard[];
}

export interface CourseEducationEffect {
  id: number;
  symbol: string;
  educationEffect: string;
  componentCode: string;
  areaOfKnowledge: AreaofKnowledge;
  category: EECategory;
  scienceArea: ScienceArea;
}

export interface AreaofKnowledge {
  id: number;
  name: string;
}

export interface EECategory {
  id: number;
  name: string;
}

export interface ScienceArea {
  id: number;
  name: string;
}

export interface SubjectCard {
  id: number;
  link: string;
  programContents: ProgramContent[];
  subject: Subject;
  teachingTools: TeachingTool[];
  subjectEducationEffects: SubjectEducationEffect[];
  subjectKeepers: SubjectKeeper[];
  subjectPurposes: SubjectPurpose[];
}

export interface ProgramContent {
  id: number;
  symbol: string;
  content: string;
  hours: number;
  classesType: ClassesType;
  subjectCard: SubjectCard;
}

export interface TeachingTool {
  id: number;
  symbol: string;
  tool: string;
  subjectCards: SubjectCard[];
}

export interface SubjectEducationEffect {
  id: number;
  symbol: string;
  educationEffect: string;
  courseEducationEffects: CourseEducationEffect[];
  eeCategory: EECategory;
  subjectCards: SubjectCard[];
}

export interface SubjectKeeper {
  id: number;
  name: string;
  surname: string;
  subjectCards: SubjectCard[];
}

export interface SubjectPurpose {
  id: number;
  symbol: string;
  purpose: string;
  subjectCards: SubjectCard[];
}
