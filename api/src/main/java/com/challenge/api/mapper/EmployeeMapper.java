package com.challenge.api.mapper;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeImpl toEmployee(CreateEmployeeRequest request) {
        return EmployeeImpl.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .salary(request.getSalary())
                .age(request.getAge())
                .jobTitle(request.getJobTitle())
                .email(request.getEmail())
                .build();
    }

    public EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .uuid(employee.getUuid())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .fullName(employee.getFullName())
                .salary(employee.getSalary())
                .age(employee.getAge())
                .jobTitle(employee.getJobTitle())
                .email(employee.getEmail())
                .contractHireDate(employee.getContractHireDate())
                .contractTerminationDate(employee.getContractTerminationDate())
                .build();
    }

    public List<EmployeeResponse> toResponseList(List<Employee> employees) {
        return employees.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
