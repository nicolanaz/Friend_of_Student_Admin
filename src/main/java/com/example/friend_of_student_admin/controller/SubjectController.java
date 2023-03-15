package com.example.friend_of_student_admin.controller;

import com.example.friend_of_student_admin.model.Subject;
import com.example.friend_of_student_admin.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private TaskService service;

    public SubjectController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Subject> getListOfSubjects() {
        return service.getAllSubjects();
    }

    @PostMapping
    public Subject saveNewSubject(@RequestBody Subject subject) {
        return service.saveSubject(subject);
    }

    @PutMapping
    public Subject updateSubject(@RequestParam("id") int id, @RequestBody Subject subject) {
        return service.updateSubject(id, subject);
    }

    @DeleteMapping
    public void deleteSubject(@RequestParam("id") int id) {
        service.deleteAllTasksBySubject(id);
    }
}
