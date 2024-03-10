package net.aminurdev.ems.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.aminurdev.ems.dto.EmployeeDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private EmployeeDto data;
    private String message;
    private String status;
}
