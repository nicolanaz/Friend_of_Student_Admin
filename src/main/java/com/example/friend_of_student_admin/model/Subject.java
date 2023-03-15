package com.example.friend_of_student_admin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue
    private int id;
    private int course;
    private String professor;
    private String subjectName;
}
