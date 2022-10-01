package com.example.controller;

import com.example.constants.EmployeeConstants;
import com.example.entities.Employee;
import com.example.model.EmployeeModel;
import com.example.model.EmployeeUpdateModel;
import com.example.service.EmployeeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
public class EmployeeController {

    @Inject
    EmployeeService employeeService;

    @Post(EmployeeConstants.CREATE_EMPLOYEE)
    public HttpResponse<EmployeeUpdateModel> saveEmployee(@Body @Valid EmployeeModel employee) {
        EmployeeUpdateModel response = employeeService.saveEmployee(employee);
        return HttpResponse.ok(response);
    }

    @Put(EmployeeConstants.UPDATE_EMPLOYEE)
    public HttpResponse<EmployeeUpdateModel> updateEmployee(@Body @Valid EmployeeUpdateModel employee) {
        EmployeeUpdateModel response = employeeService.updateEmployee(employee);
        return HttpResponse.ok(response);
    }

    @Get(EmployeeConstants.GET_EMPLOYEE)
    public HttpResponse<List<EmployeeUpdateModel>> getEmployees(@QueryValue String firstName, @QueryValue String lastName) {
        return HttpResponse.ok(employeeService.getEmployee(firstName, lastName));
    }

    @Delete(EmployeeConstants.DELETE_EMPLOYEE)
    public HttpResponse<String> deleteEmployee(@QueryValue @NotNull Long id) {
        employeeService.deleteEmployee(id);
        return HttpResponse.ok(EmployeeConstants.DELETE_EMPLOYEE_MESSAGE + id );
    }
}
