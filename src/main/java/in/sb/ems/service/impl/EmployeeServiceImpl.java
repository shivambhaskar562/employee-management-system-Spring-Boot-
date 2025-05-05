package in.sb.ems.service.impl;

import in.sb.ems.dto.EmployeeDto;
import in.sb.ems.entity.Employee;
import in.sb.ems.exceptions.ResourceNotFoundException;
import in.sb.ems.mapper.EmployeeMapper;
import in.sb.ems.repository.EmployeeRepository;
import in.sb.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByID(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with the given id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();

        //It is converting the employee to employeeDTO object
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(EmployeeMapper::mapToEmployeeDto).toList();

        //Alternative of Employee to EmployeeDTO
//        List<EmployeeDto> employeeDtoList = new ArrayList<>();
//        for (Employee emp : employeeList) {
//            employeeDtoList.add(EmployeeMapper.mapToEmployeeDto(emp));
//        }
        return employeeDtoList;
    }


    //Recheck the Logic again
    @Override
    public EmployeeDto updateEmployeeById(long id, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id: "+id)
        );

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());

        Employee updayedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updayedEmployee);


        //Another way to doing this same thing
//        boolean status = employeeRepository.existsById(id);
//        if (status) {
//            EmployeeDto oldEmployeeDto = getEmployeeByID(id);
//            updatedEmployeeDto.setId(oldEmployeeDto.getId());
//            return updatedEmployeeDto;
//        } else {
//            throw new ResourceNotFoundException("Employee is not exist with the given id: " + id);
//        }

    }

    @Override
    public EmployeeDto deleteEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id: "+id)
        );
        employeeRepository.deleteById(id);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> deleteAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        employeeRepository.deleteAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
        return employeeDtoList;
    }
}
