package com.challenge.api.service;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import com.challenge.api.exception.EmployeeNotFoundException;
import com.challenge.api.mapper.EmployeeMapper;
import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toResponseList(employees);
    }

    @Override
    public EmployeeResponse getEmployeeByUuid(UUID uuid) {
        Employee employee = employeeRepository.findById(uuid).orElseThrow(() -> new EmployeeNotFoundException(uuid));
        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {

        Employee employee = employeeMapper.toEmployee(request);

        // Generate system-managed attributes before persisting the employee.
        employee.setUuid(UUID.randomUUID());

        employee.setFullName(request.getFirstName() + " " + request.getLastName());

        employee.setContractHireDate(Instant.now());

        employee.setContractTerminationDate(null);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toResponse(savedEmployee);
    }
}
