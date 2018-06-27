create table areaofknowledge (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table changesuggestion (id integer not null auto_increment, proposition varchar(255) not null, reason varchar(255) not null, education_program integer, evaluator integer not null, primary key (id)) ENGINE=InnoDB
create table classestype (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table course (id integer not null auto_increment, code varchar(255) not null, ects integer not null, name varchar(255) not null, technical tinyint not null, zzu_hours integer not null, classes_type integer not null, course_type integer not null, courses_group integer not null, form integer not null, kind integer not null, passing_way integer not null, subject integer not null, primary key (id)) ENGINE=InnoDB
create table courseeducationeffect (id integer not null auto_increment, component_code varchar(255) not null, education_effect varchar(255) not null, symbol varchar(255) not null, area_of_knowledge integer not null, category integer not null, education_program integer not null, science_area integer not null, primary key (id)) ENGINE=InnoDB
create table courseeducationeffect_subject (course_education_effect_id integer not null, subject_id integer not null) ENGINE=InnoDB
create table courseeducationeffect_subjecteducationeffect (course_education_effect_id integer not null, subject_education_effect_id integer not null) ENGINE=InnoDB
create table courseform (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table coursesgroup (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table coursesmodule (id integer not null auto_increment, module_type integer not null, ov_module integer, primary key (id)) ENGINE=InnoDB
create table coursesmodule_course (courses_module_id integer not null, course_id integer not null) ENGINE=InnoDB
create table coursetype (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table educationlevel (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table educationmodule (id integer not null auto_increment, module_type integer not null, ov_module integer, primary key (id)) ENGINE=InnoDB
create table educationprogram (id integer not null auto_increment, course varchar(255) not null, period varchar(255) not null, specialization varchar(255) not null, faculty integer not null, level integer not null, mode integer not null, profile integer not null, primary key (id)) ENGINE=InnoDB
create table eecategory (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table evaluator (id integer not null auto_increment, name varchar(255) not null, surname varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table faculty (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table kind (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table mode (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table moduletype (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table passingway (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table profile (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table programcontent (id integer not null auto_increment, content varchar(255) not null, hours integer not null, symbol varchar(255) not null, classes_type integer not null, subject_card integer not null, primary key (id)) ENGINE=InnoDB
create table sciencearea (id integer not null auto_increment, name varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table semester (id integer not null auto_increment, number integer not null, studies_plan integer not null, primary key (id)) ENGINE=InnoDB
create table semester_coursesmodule (semester_id integer not null, courses_module_id integer not null) ENGINE=InnoDB
create table specializationeducationeffect (id integer not null auto_increment, component_code varchar(255) not null, education_effect varchar(255) not null, symbol varchar(255) not null, area_of_knowledge integer not null, category integer not null, science_area integer not null, primary key (id)) ENGINE=InnoDB
create table specializationeducationeffect_courseeducationeffect (specialization_education_effect_id integer not null, course_education_effect_id integer not null) ENGINE=InnoDB
create table studiesplan (id integer not null auto_increment, education_program integer not null, primary key (id)) ENGINE=InnoDB
create table studiesprogram (id integer not null auto_increment, description varchar(255) not null, education_program integer not null, primary key (id)) ENGINE=InnoDB
create table studiesprogram_educationmodule (studies_program_id integer not null, education_module_id integer not null) ENGINE=InnoDB
create table subject (id integer not null auto_increment, code varchar(255) not null, name_eng varchar(255) not null, name_pl varchar(255) not null, prerequisites varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table subjectcard (id integer not null auto_increment, link varchar(255) not null, subject integer not null, primary key (id)) ENGINE=InnoDB
create table subjectcard_teachingtool (subject_card_id integer not null, teaching_tool_id integer not null) ENGINE=InnoDB
create table subjecteducationeffect (id integer not null auto_increment, education_effect varchar(255) not null, symbol varchar(255) not null, category integer not null, primary key (id)) ENGINE=InnoDB
create table subjecteducationeffect_subjectcard (subject_education_effect_id integer not null, subject_card_id integer not null) ENGINE=InnoDB
create table subjectkeeper (id integer not null auto_increment, name varchar(255) not null, surname varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table subjectkeeper_subjectcard (subject_keeper_id integer not null, subject_card_id integer not null) ENGINE=InnoDB
create table subjectpurpose (id integer not null auto_increment, purpose varchar(255) not null, symbol varchar(255) not null, primary key (id)) ENGINE=InnoDB
create table subjectpurpose_subjectcard (subject_purpose_id integer not null, subject_card_id integer not null) ENGINE=InnoDB
create table teachingtool (id integer not null auto_increment, symbol varchar(255) not null, tool varchar(255) not null, primary key (id)) ENGINE=InnoDB
alter table changesuggestion add constraint FK4o494as40cn82htwxjfv6ewau foreign key (education_program) references educationprogram (id)
alter table changesuggestion add constraint FKq6iduomksmb4de55ttynxwxwo foreign key (evaluator) references evaluator (id)
alter table course add constraint FKokehlxbj1tqhgwe1f9bpc6poi foreign key (classes_type) references classestype (id)
alter table course add constraint FKn2yj41mhpw9rrrt7uph9gn59o foreign key (course_type) references coursetype (id)
alter table course add constraint FKe62r68tqxiju5oepqhytxssa3 foreign key (courses_group) references coursesgroup (id)
alter table course add constraint FKnlsh4tx4emo4rq3fu96hwis1g foreign key (form) references courseform (id)
alter table course add constraint FK3h83cj5yrlbp53wvqw38dfhmk foreign key (kind) references kind (id)
alter table course add constraint FK9dxqwtklrpmo9r4sd9vpdqk30 foreign key (passing_way) references passingway (id)
alter table course add constraint FKdimvfinquj4lh2m6se1r0vq41 foreign key (subject) references subject (id)
alter table courseeducationeffect add constraint FKq3npvej0d5ebujy31cyli31rf foreign key (area_of_knowledge) references areaofknowledge (id)
alter table courseeducationeffect add constraint FK9djwu8hnmatvkdguvy1irww3i foreign key (category) references eecategory (id)
alter table courseeducationeffect add constraint FKe1dwwcy6pv893q39ewylxy3vm foreign key (education_program) references educationprogram (id)
alter table courseeducationeffect add constraint FKenaiagmuqj63qert2dbdvsnf2 foreign key (science_area) references sciencearea (id)
alter table courseeducationeffect_subject add constraint FKgd5aguknlimn8fyiu4ql3xb7u foreign key (subject_id) references subject (id)
alter table courseeducationeffect_subject add constraint FKoc62lsppbexkqb5yl02rv6261 foreign key (course_education_effect_id) references courseeducationeffect (id)
alter table courseeducationeffect_subjecteducationeffect add constraint FKrjpty1xh0t3egta2j6jjc3h9f foreign key (subject_education_effect_id) references subjecteducationeffect (id)
alter table courseeducationeffect_subjecteducationeffect add constraint FK63h56undoi88bne1ouwrca0pm foreign key (course_education_effect_id) references courseeducationeffect (id)
alter table coursesmodule add constraint FKjthon0dsc7fw7asinmyaxhyj6 foreign key (module_type) references moduletype (id)
alter table coursesmodule add constraint FKewmbbr6o6a0849u7nsnuafc8j foreign key (ov_module) references coursesmodule (id)
alter table coursesmodule_course add constraint FKllpwuf29ivetqqp5j555vhpqg foreign key (course_id) references course (id)
alter table coursesmodule_course add constraint FKrd2e3h9wpwc1aq9jdsv5vxi5b foreign key (courses_module_id) references coursesmodule (id)
alter table educationmodule add constraint FKjh8ddy8jyhnt0ubvq5cuw2ua5 foreign key (module_type) references moduletype (id)
alter table educationmodule add constraint FK5lu57ghr6negojuh70s2khxtr foreign key (ov_module) references educationmodule (id)
alter table educationprogram add constraint FKnp69ujhfk4b37xv75k8e1wl0c foreign key (faculty) references faculty (id)
alter table educationprogram add constraint FKqcpq2w24we1gtwsh6bltx8jpq foreign key (level) references educationlevel (id)
alter table educationprogram add constraint FKcsd0sdf65q3lopn33j0cbxcr2 foreign key (mode) references mode (id)
alter table educationprogram add constraint FK3nnnwixcj8jxhrk6s1rccda7n foreign key (profile) references profile (id)
alter table programcontent add constraint FKha7bjbmmtgwaj9lugv7cayp1l foreign key (classes_type) references classestype (id)
alter table programcontent add constraint FKbplvlxglkwxsp9ckleqnvpwvs foreign key (subject_card) references subjectcard (id)
alter table semester add constraint FKq2ql92c61l72op05331ou3a9o foreign key (studies_plan) references studiesplan (id)
alter table semester_coursesmodule add constraint FKh6gcrugiu94h9cv28xvfpf4v7 foreign key (courses_module_id) references coursesmodule (id)
alter table semester_coursesmodule add constraint FK1mk62q3oq8j30pkkojsd4owdt foreign key (semester_id) references semester (id)
alter table specializationeducationeffect add constraint FKm2ftd3b4xi0j1ckigagtcyp2j foreign key (area_of_knowledge) references areaofknowledge (id)
alter table specializationeducationeffect add constraint FK4jl26vgx3garvi767mcwqc1er foreign key (category) references eecategory (id)
alter table specializationeducationeffect add constraint FK9j8ba03uuigs9133omxxlm3pm foreign key (science_area) references sciencearea (id)
alter table specializationeducationeffect_courseeducationeffect add constraint FK757fog81x3tufxfkmixnmh4p7 foreign key (course_education_effect_id) references courseeducationeffect (id)
alter table specializationeducationeffect_courseeducationeffect add constraint FKfgbdue1ttq0an276y5uno2r8r foreign key (specialization_education_effect_id) references specializationeducationeffect (id)
alter table studiesplan add constraint FKg0dwp8dfh5ux328c5ukymi27d foreign key (education_program) references educationprogram (id)
alter table studiesprogram add constraint FK9lwl80h0fhosak197x9d2j1fx foreign key (education_program) references educationprogram (id)
alter table studiesprogram_educationmodule add constraint FKbe5vawodx3o4g5c8564slsbju foreign key (education_module_id) references educationmodule (id)
alter table studiesprogram_educationmodule add constraint FK9d7tk3cnnip622752k62yp59 foreign key (studies_program_id) references studiesprogram (id)
alter table subjectcard add constraint FKn1r0soep5g4ohs3gkunq0s8md foreign key (subject) references subject (id)
alter table subjectcard_teachingtool add constraint FKdo8dyc4yx68ibolq4i9yp23n4 foreign key (teaching_tool_id) references teachingtool (id)
alter table subjectcard_teachingtool add constraint FK5g41kipus61ljhn4x56od35jf foreign key (subject_card_id) references subjectcard (id)
alter table subjecteducationeffect add constraint FKk44jha95fsulu879j3q0m12jg foreign key (category) references eecategory (id)
alter table subjecteducationeffect_subjectcard add constraint FK4x6i7b5s6ofosq5xydfrv8b6h foreign key (subject_card_id) references subjectcard (id)
alter table subjecteducationeffect_subjectcard add constraint FKpiu2ydxbmk2w14owhwoiuiwte foreign key (subject_education_effect_id) references subjecteducationeffect (id)
alter table subjectkeeper_subjectcard add constraint FKefm0vul9vxsqd6owsg23o5vfo foreign key (subject_card_id) references subjectcard (id)
alter table subjectkeeper_subjectcard add constraint FKgpe8ce0x84mluhsncb0eyin6t foreign key (subject_keeper_id) references subjectkeeper (id)
alter table subjectpurpose_subjectcard add constraint FKmx0c79n35obpo175veke4nyj2 foreign key (subject_card_id) references subjectcard (id)
alter table subjectpurpose_subjectcard add constraint FKb8v76mnx0aux0709m6gu22d1x foreign key (subject_purpose_id) references subjectpurpose (id)
