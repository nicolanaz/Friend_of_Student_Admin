package com.example.friend_of_student_admin.repo;

import com.example.friend_of_student_admin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
