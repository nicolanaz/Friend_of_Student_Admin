package com.example.friend_of_student_admin.controller;


import com.example.friend_of_student_admin.model.Task;
import com.example.friend_of_student_admin.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public Task getTask(@RequestParam("id") int subjectId,
                        @RequestParam("number") int number) {
        return service.getTaskByNumber(service.getSubjectById(subjectId), number);
    }

    @PostMapping
    public Task saveNewTask(@RequestParam("id") int subjectId, @RequestBody Task task) {
        return service.saveTask(subjectId, task);
    }

    @PutMapping("/update/answer")
    public void updateAnswer(@RequestParam("id") int subjectId,
                             @RequestParam("number") int number,
                             @RequestBody String answer) {
        service.updateAnswerByNumber(subjectId, number, answer);
    }

    @PutMapping("/update/question")
    public void updateQuestion(@RequestParam("id") int subjectId,
                               @RequestParam("number") int number,
                               @RequestBody String question){
        service.updateQuestionByNumber(subjectId, number, question);
    }

    @PutMapping("/update/number")
    public void updateNumber(@RequestParam("id") int subjectId,
                             @RequestBody String question,
                             @RequestParam("number") int number) {
        service.updateNumberByQuestion(subjectId, question, number);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam("id") int subjectId,
                           @RequestParam("number") int number) {
        service.deleteTask(subjectId, number);
    }
}
