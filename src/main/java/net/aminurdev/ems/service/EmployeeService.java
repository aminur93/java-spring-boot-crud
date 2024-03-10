package net.aminurdev.ems.service;

import net.aminurdev.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto storeEmployee(EmployeeDto employeeDto);

    EmployeeDto edit(Long employeeId);

    List<EmployeeDto> index();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);
}
