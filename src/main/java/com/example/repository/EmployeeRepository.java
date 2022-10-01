package com.example.repository;

import com.example.entities.Employee;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "from Employee e where e.firstName = :firstName or e.lastName = :lastName")
    public List<Employee> getEmployeebyEmloyeeName (String firstName, String lastName);
}
