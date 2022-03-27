package tech.getarrays.employeemanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanagement.model.Employee;

import java.util.Optional;

public interface EmployeeRepos extends JpaRepository<Employee , Long> {
    void deleteEmployeeById(Long id);

    Optional <Employee> findEmployeeById(Long id);
}
