package tech.getarrays.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import tech.getarrays.employeemanagement.exception.UserNotFoundException;
import tech.getarrays.employeemanagement.model.Employee;
import tech.getarrays.employeemanagement.repos.EmployeeRepos;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepos employeeRepos;

    @Autowired
    public EmployeeService(EmployeeRepos employeeRepos) {
        this.employeeRepos = employeeRepos;
    }
    public  Employee addEmployee(Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepos.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepos.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepos.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepos.findEmployeeById(id).orElseThrow(()->
                new UserNotFoundException("User by id " + id + " was not fund"));
    }
    public void deleteEmployee(Long id){

        employeeRepos.deleteEmployeeById(id);
    }
}
