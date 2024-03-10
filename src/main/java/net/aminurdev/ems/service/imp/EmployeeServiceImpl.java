package net.aminurdev.ems.service.imp;

import lombok.AllArgsConstructor;
import net.aminurdev.ems.dto.EmployeeDto;
import net.aminurdev.ems.entity.Employee;
import net.aminurdev.ems.exception.ResourceNotFoundException;
import net.aminurdev.ems.mapper.EmployeeMapper;
import net.aminurdev.ems.repository.EmployeeRepository;
import net.aminurdev.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto storeEmployee(EmployeeDto employeeDto) {

        try {

            Employee employee = new Employee();

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());

            employee = employeeRepository.save(employee);

            return EmployeeMapper.mapToEmployeeDto(employee);

        } catch (Exception e) {

            throw new RuntimeException("Failed to store employee");
        }
    }

    @Override
    public EmployeeDto edit(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                                 .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> index() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        try{

            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());

            employee = employeeRepository.save(employee);

            return EmployeeMapper.mapToEmployeeDto(employee);

        }catch (Exception e){

            throw new RuntimeException("Failed to update employee");
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        try {

            employeeRepository.deleteById(employeeId);

        } catch (Exception e) {

            throw new RuntimeException("Failed to delete employee");
        }
    }
}
