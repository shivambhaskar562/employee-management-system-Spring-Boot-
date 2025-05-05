package in.sb.ems.service;

import in.sb.ems.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeByID(long id);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployeeById(long id, EmployeeDto UpdatedEmployeeDto);
    public EmployeeDto deleteEmployeeById(long id);
    public List<EmployeeDto> deleteAllEmployee();
}
