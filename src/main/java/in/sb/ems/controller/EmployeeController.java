package in.sb.ems.controller;

import in.sb.ems.dto.EmployeeDto;
import in.sb.ems.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;


    //Add Employee Restfull APIs
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Get Employee Restfull APIs
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") long id){
        EmployeeDto employeeDto = employeeService.getEmployeeByID(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    //Get All Employee APIs
    @GetMapping
    public ResponseEntity<?> getAllEmployee(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

    //Update All Employee By ID APIs
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployeeByID(@PathVariable("id") long id,
                                                @RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto newEmployeeDto = employeeService.updateEmployeeById(id, employeeDto);
        return new ResponseEntity<>(newEmployeeDto, HttpStatus.OK);
    }
    //Delete Employee By ID APIs
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") long id){
        EmployeeDto employeeDto =employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }


    //Delete All Employee APIs
    @DeleteMapping("delete/all")
    public  ResponseEntity<?> deleteAllEmployee(){
        List<EmployeeDto> employeeDtoList = employeeService.deleteAllEmployee();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }
}
