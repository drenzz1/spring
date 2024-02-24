package org.foo.repository;

import org.foo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.lang.model.util.SimpleElementVisitor6;
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
    @Query("SELECT e from Employee e where e.email = 'jhookd@booking.com'")
    Employee getEmployeeDetails();
    @Query("SELECT e.salary from Employee e where e.email='jhookd@booking.com'")
    Integer getEmployeeSalary();
    @Query("Select e from Employee e where e.email = ?1")
    Employee getEmployeeDetail(String email);
    @Query("select e from Employee e where e.email = ?1 and e.salary = ?2")
    Employee getEmployeeDetail(String email , int salary);


}
