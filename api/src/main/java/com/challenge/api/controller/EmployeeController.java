package com.challenge.api.controller;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */

/**
 * REST Controller exposing employee APIs for consumption
 * by the Employees-R-US integration as per the given task.
 *
 * The controller delegates all business logic to the service layer
 * and is responsible only for handling HTTP requests and responses.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        // retrieves all available employees
        return ResponseEntity.ok(employeeService.getAllEmployees());

        // throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    @GetMapping("/{uuid}")
    public ResponseEntity<EmployeeResponse> getEmployeeByUuid(@PathVariable UUID uuid) {
        // retrieves a single employee by UUID.
        return ResponseEntity.ok(employeeService.getEmployeeByUuid(uuid));
        // throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest request) {
        // creates a new Employee
        EmployeeResponse employee = employeeService.createEmployee(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        // throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }
}
