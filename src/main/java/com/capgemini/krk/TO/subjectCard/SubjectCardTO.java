package com.capgemini.krk.TO.subjectCard;

import com.capgemini.krk.TO.programContent.ProgramContentTO;
import com.capgemini.krk.TO.subject.SubjectTO;
import com.capgemini.krk.TO.subjectEducationEffect.SubjectEducationEffectTO;
import com.capgemini.krk.TO.subjectKeeper.SubjectKeeperTO;
import com.capgemini.krk.TO.subjectPurpose.SubjectPurposeTO;
import com.capgemini.krk.TO.teachingTool.TeachingToolTO;

import java.util.List;

public class SubjectCardTO {
    private int id;
    private String link;
    private List<ProgramContentTO> programContents;
    private SubjectTO subject;
    private List<TeachingToolTO> teachingTools;
    private List<SubjectEducationEffectTO> subjectEducationEffects;
    private List<SubjectKeeperTO> subjectKeepers;
    private List<SubjectPurposeTO> subjectPurposes;

    public SubjectCardTO(int id, String link, List<ProgramContentTO> programContents, SubjectTO subject, List<TeachingToolTO> teachingTools, List<SubjectEducationEffectTO> subjectEducationEffects, List<SubjectKeeperTO> subjectKeepers, List<SubjectPurposeTO> subjectPurposes) {
        this.id = id;
        this.link = link;
        this.programContents = programContents;
        this.subject = subject;
        this.teachingTools = teachingTools;
        this.subjectEducationEffects = subjectEducationEffects;
        this.subjectKeepers = subjectKeepers;
        this.subjectPurposes = subjectPurposes;
    }

    public SubjectCardTO(String link) {
        this.link = link;
    }

    public SubjectCardTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<ProgramContentTO> getProgramContents() {
        return programContents;
    }

    public void setProgramContents(List<ProgramContentTO> programContents) {
        this.programContents = programContents;
    }

    public SubjectTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectTO subject) {
        this.subject = subject;
    }

    public List<TeachingToolTO> getTeachingTools() {
        return teachingTools;
    }

    public void setTeachingTools(List<TeachingToolTO> teachingTools) {
        this.teachingTools = teachingTools;
    }

    public List<SubjectEducationEffectTO> getSubjectEducationEffects() {
        return subjectEducationEffects;
    }

    public void setSubjectEducationEffects(List<SubjectEducationEffectTO> subjectEducationEffects) {
        this.subjectEducationEffects = subjectEducationEffects;
    }

    public List<SubjectKeeperTO> getSubjectKeepers() {
        return subjectKeepers;
    }

    public void setSubjectKeepers(List<SubjectKeeperTO> subjectKeepers) {
        this.subjectKeepers = subjectKeepers;
    }

    public List<SubjectPurposeTO> getSubjectPurposes() {
        return subjectPurposes;
    }

    public void setSubjectPurposes(List<SubjectPurposeTO> subjectPurposes) {
        this.subjectPurposes = subjectPurposes;
    }
}
