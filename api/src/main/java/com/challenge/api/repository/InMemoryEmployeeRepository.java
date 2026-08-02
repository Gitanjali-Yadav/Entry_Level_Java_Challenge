package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final Map<UUID, Employee> employeeDataStorage = new ConcurrentHashMap<>();

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
