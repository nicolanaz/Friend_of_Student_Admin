package com.example.friend_of_student_admin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int number;

    @Column(columnDefinition = "TEXT")
    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    public Task(int number, String question, String answer) {
        this.number = number;
        this.question = question;
        this.answer = answer;
    }
}
