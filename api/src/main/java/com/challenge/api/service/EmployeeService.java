package com.challenge.api.service;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeByUuid(UUID uuid);

    EmployeeResponse createEmployee(CreateEmployeeRequest request);
}
