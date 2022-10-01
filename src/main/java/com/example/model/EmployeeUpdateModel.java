package com.example.model;

import io.micronaut.context.annotation.Bean;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.convert.format.Format;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Bean
@Data
@Introspected
public class EmployeeUpdateModel {
    @NotNull
    private Integer id;
    private String firstName;
    private String lastName;
    private String Address;
    @Format("yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Format("yyyy-MM-dd")
    private LocalDate dateOfJoining;
    private BigDecimal salary;
    @Min(0)
    private Integer leaves;
}
