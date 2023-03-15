package com.example.friend_of_student_admin.service;

import com.example.friend_of_student_admin.model.Subject;
import com.example.friend_of_student_admin.model.Task;
import com.example.friend_of_student_admin.repo.SubjectRepository;
import com.example.friend_of_student_admin.repo.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {
    private SubjectRepository subjectRepository;
    private TaskRepository taskRepository;

    public TaskService(SubjectRepository subjectRepository, TaskRepository taskRepository) {
        this.subjectRepository = subjectRepository;
        this.taskRepository = taskRepository;
    }

    public Subject getSubject(int course, String professor, String subjectName) {
        return subjectRepository.findSubjectByCourseAndProfessorAndSubjectName(course, professor, subjectName);
    }

    public Subject getSubjectById(int id) {
        return subjectRepository.findById(id).get();
    }

    public Iterable<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Iterable<Task> getAllTasksBySubject(Subject subject) {
        return taskRepository.findAllBySubject(subject);
    }

    public Subject updateSubject(int id, Subject subject) {
        int course = subject.getCourse();
        String professor = subject.getProfessor();
        String subjectName = subject.getSubjectName();

        subjectRepository.updateSubject(id, course, professor, subjectName);
        return subject;
    }

    public Task saveTask(int subjectId, Task task) {
        task.setSubject(getSubjectById(subjectId));
        return taskRepository.save(task);
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    public Task getTaskByQuestion(Subject subject, String question) {
        return taskRepository.findTaskBySubjectAndQuestion(subject, question);
    }

    public Task getTaskByNumber(Subject subject, int number) {
        return taskRepository.findTaskBySubjectAndNumber(subject, number);
    }

    public void updateAnswerByNumber(int subjectId, int number, String answer) {
        int taskId = getTaskByNumber(getSubjectById(subjectId), number).getId();
        taskRepository.updateAnswer(taskId, answer);
    }

    public void updateQuestionByNumber(int subjectId, int number, String question) {
        int taskId = getTaskByNumber(getSubjectById(subjectId), number).getId();
        taskRepository.updateQuestion(taskId, question);
    }

    public void updateNumberByQuestion(int subjectId, String question, int number) {
        int taskId = getTaskByQuestion(getSubjectById(subjectId), question).getId();
        taskRepository.updateNumber(taskId, number);
    }

    @Transactional
    public void deleteTask(int subjectId, int number) {
        taskRepository.deleteTaskBySubject_IdAndNumber(subjectId, number);
    }

    @Transactional
    public void deleteAllTasksBySubject(int id) {
        Subject subject = getSubjectById(id);

        taskRepository.deleteAllBySubject(subject);
        subjectRepository.delete(subject);
    }
}
