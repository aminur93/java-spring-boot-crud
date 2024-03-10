package net.aminurdev.ems.controller;

import lombok.AllArgsConstructor;
import net.aminurdev.ems.dto.EmployeeDto;
import net.aminurdev.ems.entity.Employee;
import net.aminurdev.ems.response.EmployeeResponse;
import net.aminurdev.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build employee index endpoint
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> index() {

       List<EmployeeDto> employeeList =  employeeService.index();

        EmployeeResponse response = new EmployeeResponse();
        response.setMessage("Employees fetched successfully");
        response.setStatus("success");

        return ResponseEntity.ok(employeeList);
    }

    // Build employee store endpoint
    @PostMapping
    public ResponseEntity<EmployeeResponse> store(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto employee = employeeService.storeEmployee(employeeDto);

       EmployeeResponse response = new EmployeeResponse();
       response.setData(employee);
       response.setMessage("Employee stored successfully");
       response.setStatus("success");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Build employee edit endpoint
    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> edit(@PathVariable("id") Long employeeId) {

        EmployeeDto employee = employeeService.edit(employeeId);

        EmployeeResponse response = new EmployeeResponse();
        response.setData(employee);
        response.setMessage("Employee fetched successfully");
        response.setStatus("success");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Build employee update endpoint
    @PutMapping("{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {

        EmployeeDto employee = employeeService.updateEmployee(employeeId, employeeDto);

        EmployeeResponse response = new EmployeeResponse();
        response.setData(employee);
        response.setMessage("Employee updated successfully");
        response.setStatus("success");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Build employee delete endpoint
    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeResponse> delete(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        EmployeeResponse response = new EmployeeResponse();
        response.setMessage("Employee deleted successfully");
        response.setStatus("success");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
