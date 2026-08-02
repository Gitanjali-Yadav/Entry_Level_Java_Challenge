package com.challenge.api.util;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Generates mock employee data used to
 * initialize the in-memory repository.
 */
@Component
public class EmployeeDataGenerator {

    public List<Employee> generateEmployees() {

        List<Employee> employees = new ArrayList<>();

        employees.add(createEmployee("John", "Doe", "Software Engineer", "john.doe@reliaquest.com", 80000, 28));

        employees.add(createEmployee("Jane", "Smith", "QA Engineer", "jane.smith@reliaquest.com", 75000, 30));

        employees.add(createEmployee("Alex", "Johnson", "DevOps Engineer", "alex.johnson@reliaquest.com", 95000, 35));

        employees.add(createEmployee("Emily", "Davis", "Product Manager", "emily.davis@reliaquest.com", 100000, 32));

        employees.add(
                createEmployee("Michael", "Brown", "Security Engineer", "michael.brown@reliaquest.com", 110000, 36));

        return employees;
    }

    private Employee createEmployee(
            String firstName, String lastName, String jobTitle, String email, Integer salary, Integer age) {

        return EmployeeImpl.builder()
                .uuid(UUID.randomUUID())
                .firstName(firstName)
                .lastName(lastName)
                .fullName(firstName + " " + lastName)
                .jobTitle(jobTitle)
                .email(email)
                .salary(salary)
                .age(age)
                .contractHireDate(Instant.now())
                .contractTerminationDate(null)
                .build();
    }
}
