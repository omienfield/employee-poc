package com.example.service;

import com.example.entities.Employee;
import com.example.model.EmployeeUpdateModel;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class EmployeeServiceTest {

    @Inject
    EmployeeService employeeService;

    @MockBean(EmployeeRepository.class)
    EmployeeRepository employeeRepository() {
        return Mockito.mock(EmployeeRepository.class);
    }

    @Inject
    EmployeeRepository employeeRepository;

    @Test
    public void t1() {
        Mockito.when(employeeRepository.getEmployeebyEmloyeeName(any(),any())).thenReturn(List.of());
        List<EmployeeUpdateModel> employeeUpdateModels = employeeService.getEmployee("omkar","");
        assertEquals(employeeUpdateModels,List.of());
    }

    @Test
    public void t2() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("omkar");
        employee.setLastName("patil");
        employees.add(employee);
        Mockito.when(employeeRepository.getEmployeebyEmloyeeName(any(),any())).thenReturn(employees);
//        Mockito.when(employeeRepository.getEmployeebyEmloyeeName("Omkar",any())).thenReturn(employees);
        List<EmployeeUpdateModel> employeeUpdateModels = employeeService.getEmployee("omkar","");
        assertEquals(employeeUpdateModels.size(),1);
    }
}
