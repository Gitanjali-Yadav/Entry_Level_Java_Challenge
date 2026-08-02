package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import com.challenge.api.util.EmployeeDataGenerator;
import jakarta.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

/**
 * In-memory implementation of the employee repository.
 *
 * This implementation intentionally avoids a persistence layer
 * as per the assignment requirements and stores employees
 * using a thread-safe ConcurrentHashMap.
 */
@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    /**
     * Uses ConcurrentHashMap to provide efficient O(1)
     */
    private final Map<UUID, Employee> employeeDataStorage = new ConcurrentHashMap<>();

    EmployeeDataGenerator employeeDataGenerator;

    @PostConstruct
    public void initializeData() {
        employeeDataGenerator
                .generateEmployees()
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
