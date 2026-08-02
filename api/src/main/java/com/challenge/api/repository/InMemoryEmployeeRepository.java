package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import com.challenge.api.util.EmployeeDataGenerator;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final Map<UUID, Employee> employeeDataStorage = new ConcurrentHashMap<>();

//    public InMemoryEmployeeRepository(EmployeeDataGenerator employeeDataGenerator) {
//        employeeDataGenerator
//                .generateEmployees()
//                .forEach(employee -> employeeDataStorage.put(employee.getUuid(), employee));
//    }

    EmployeeDataGenerator employeeDataGenerator;

    @PostConstruct
    public void initializeData() {
        employeeDataGenerator.generateEmployees()
                .forEach(employee -> employeeDataStorage.put(employee.getUuid(), employee));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeDataStorage.values());
    }

    @Override
    public Optional<Employee> findById(UUID uuid) {
        return Optional.ofNullable(employeeDataStorage.get(uuid));
    }

    @Override
    public Employee save(Employee employee) {
        employeeDataStorage.put(employee.getUuid(), employee);
        return employee;
    }
}
