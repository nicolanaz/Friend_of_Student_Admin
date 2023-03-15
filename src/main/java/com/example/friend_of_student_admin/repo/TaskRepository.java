package com.example.friend_of_student_admin.repo;

import com.example.friend_of_student_admin.model.Subject;
import com.example.friend_of_student_admin.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    Task findTaskBySubjectAndNumber(Subject subject, int number);

    Task findTaskBySubjectAndQuestion(Subject subject, String question);

    List<Task> findAllBySubject(Subject subject);

    @Transactional
    @Modifying
    @Query("update Task t set t.number = :number where t.id = :id")
    void updateNumber(@Param("id") int id,
                      @Param("number") int number);

    @Transactional
    @Modifying
    @Query("update Task t set t.question = :question where t.id = :id")
    void updateQuestion(@Param("id") int id,
                        @Param("question") String question);

    @Transactional
    @Modifying
    @Query("update Task t set t.answer = :answer where t.id = :id")
    void updateAnswer(@Param("id") int id,
                      @Param("answer") String answer);

    void deleteAllBySubject(Subject subject);

    void deleteTaskBySubject_IdAndNumber(int subjectId, int number);

}
