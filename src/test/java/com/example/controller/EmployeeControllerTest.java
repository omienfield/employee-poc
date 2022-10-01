package com.example.controller;

import com.example.model.EmployeeModel;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class EmployeeControllerTest {
    @Inject
    EmployeeController employeeController;

    @Test
    public void test1() {
        EmployeeModel employeeModel = new EmployeeModel();
//        when(employeeService.saveEmployee(any())).thenReturn(new Employee());
        assertEquals(employeeModel , employeeController.saveEmployee(employeeModel));
    }
}
