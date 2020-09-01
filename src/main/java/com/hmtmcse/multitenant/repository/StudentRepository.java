package com.hmtmcse.multitenant.repository;

import com.hmtmcse.multitenant.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
