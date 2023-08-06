package com.mongoDb.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

    @Field(name="subject_name")
    private String subjectName ;
@Field(name="marks_obtained")
    private String marksObtained ;

    public Subject(){

    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Subject(String subjectName, String marksObtained) {
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", marksObtained='" + marksObtained + '\'' +
                '}';
    }
}
