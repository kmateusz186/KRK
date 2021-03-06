
export interface ChangeSuggestion {
  id: number;
  evaluator: Evaluator;
  educationProgram: EducationProgram;
  proposition: string;
  reason: string;
}

export interface EducationProgram {
  id: number;
  level: EducationLevel;
  profile: Profile;
  course: string;
  specialization: string;
  mode: Mode;
  period: string;
  faculty: Faculty;
  changeSuggestions: ChangeSuggestion[];
  courseEducationEffects: CourseEducationEffect[];
}

export interface Evaluator {
  id: number;
  name: string;
  surname: string;
}

export interface EducationLevel {
  id: number;
  name: string;
}

export interface Profile {
  id: number;
  name: string;
}

export interface Mode {
  id: number;
  name: string;
}

export interface Faculty {
  id: number;
  name: string;
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

