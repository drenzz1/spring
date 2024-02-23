package org.foo.repository;

import org.foo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Display all employee with email address
    List<Employee>findByEmail(String email);
    List<Employee>findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);
    List<Employee>findByFirstNameIsNot(String firstName);
    List<Employee>findByLastNameStartingWith(String lastName);
    List<Employee>findBySalaryIsGreaterThan(Long salary);
    List<Employee>findBySalaryLessThanEqual(Long salary);
    List<Employee>findByHireDateBetween(LocalDate date1,LocalDate date2);
    List<Employee>findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Long id);
    List<Employee>findDistinctTop3BySalaryLessThan(Integer salary);
    List<Employee>findByEmailIsNull();






}
