package com.challenge.api.service;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import java.util.List;
import java.util.UUID;

/**
 * Defines business operations related to employee management.
 *
 * The service layer contains business logic and acts as a bridge
 * between the controller and repository layers.
 */
public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeByUuid(UUID uuid);

    EmployeeResponse createEmployee(CreateEmployeeRequest request);
}
