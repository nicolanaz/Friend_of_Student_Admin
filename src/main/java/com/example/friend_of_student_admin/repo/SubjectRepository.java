package com.example.friend_of_student_admin.repo;

import com.example.friend_of_student_admin.model.Subject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Subject findSubjectByCourseAndProfessorAndSubjectName(int course, String professor, String subjectName);

    @Transactional
    @Modifying
    @Query("update Subject s " +
            "set s.course = :course, s.professor = :professor, s.subjectName = :subjectName " +
            "where s.id = :id")
    void updateSubject(@Param("id") int id,
                          @Param("course") int course,
                          @Param("professor") String professor,
                          @Param("subjectName") String subjectName);
}
