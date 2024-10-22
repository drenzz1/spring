package org.foo.repository;

import org.foo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all Departments in the furniture department
    List<Department> findByDepartment(String department);
    //Display all departments in the health division
    List<Department>findByDivision(String division);
    List<Department>findDistinctTop3ByDivisionContains(String pattern);
    List<Department>retrieveDepartmentByDivision(String division);
    List<Department>retrieveDepartmentByDivisionContain(String pattern);

}
