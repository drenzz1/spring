package org.foo.bootstrap;

import org.foo.enums.Gender;
import org.foo.entity.Department;
import org.foo.entity.Employee;
import org.foo.entity.Region;
import org.foo.repository.DepartmentRepository;
import org.foo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee("Dren","Halili","just.drenzz@gmail.com", LocalDate.of(2003,3,13), Gender.MALE,60000);
        Employee e2 = new Employee("Naim","Halili","just.drenzz@gmail.com", LocalDate.of(2004,8,23), Gender.MALE,70000);
        Employee e3 = new Employee("Milaim","Halili","just.drenzz@gmail.com", LocalDate.of(2005,10,1), Gender.MALE,50000);
        Employee e4 = new Employee("Fitim","Halili","just.drenzz@gmail.com", LocalDate.of(2009,02,3), Gender.MALE,30000);
        Employee e5 = new Employee("Bekim","Halili","just.drenzz@gmail.com", LocalDate.of(2010,01,27), Gender.MALE,40000);

        Department d1 =new Department("Sports","Outdoors");
        Department d2 =new Department("Tools","Hardware");
        Department d3 =new Department("Clothing","Home");
        Department d4 =new Department("Phones","Electronics");
        Department d5 =new Department("Computers","Electronics");

        Region r1 = new Region("South Europe","Kosova");
        Region r2 = new Region("West Europe","France");
        Region r3 = new Region("East ","China");




        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e5.setRegion(r3);


        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);
        employeeRepository.save(e5);
    }
}
