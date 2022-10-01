package com.example.mapper;

import com.example.entities.Employee;
import com.example.model.EmployeeModel;
import com.example.model.EmployeeUpdateModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface EmployeeMapper {
    Employee mapToEntity(EmployeeModel employeeModel);
    Employee mapToEntity1(EmployeeUpdateModel employeeModel);

    EmployeeUpdateModel mapEntityToDTO (Employee employee);
}
