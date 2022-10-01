package com.example.service;

import com.example.entities.Employee;
import com.example.mapper.EmployeeMapper;
import com.example.model.EmployeeModel;
import com.example.model.EmployeeUpdateModel;
import com.example.repository.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    EmployeeMapper employeeMapper;

    public EmployeeUpdateModel saveEmployee(EmployeeModel employee) {
        Employee employee1 = employeeMapper.mapToEntity(employee);
        Employee response = employeeRepository.save(employee1);
        EmployeeUpdateModel employeeUpdateModel = employeeMapper.mapEntityToDTO(response);
        return employeeUpdateModel;
    }

    public EmployeeUpdateModel updateEmployee(EmployeeUpdateModel employee) {
        Employee employee1 = employeeMapper.mapToEntity1(employee);
        Employee response = employeeRepository.update(employee1);
        return employeeMapper.mapEntityToDTO(response);
    }


    public List<EmployeeUpdateModel> getEmployee(String firstName, String lastName) {
        List<Employee> employees = employeeRepository.getEmployeebyEmloyeeName(firstName,lastName);
        List<EmployeeUpdateModel> response = new ArrayList<>();
        employees.stream().forEach(x->response.add(employeeMapper.mapEntityToDTO(x)));
        return response;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
