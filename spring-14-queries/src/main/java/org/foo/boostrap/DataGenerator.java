package org.foo.boostrap;

import jakarta.transaction.Transactional;
import org.foo.repository.CourseRepository;
import org.foo.repository.DepartmentRepository;
import org.foo.repository.EmployeeRepository;
import org.foo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class DataGenerator implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final RegionRepository regionRepository;

    public DataGenerator(CourseRepository courseRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, RegionRepository regionRepository) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("--------------Region Start--------------");
        System.out.println(regionRepository.findByCountry("Canada"));
        System.out.println(regionRepository.findDistinctByCountry("Canada"));
        System.out.println(regionRepository.findRegionsByCountryContains("United"));
        System.out.println(regionRepository.findRegionsByCountryContainsOrderByCountry("Asia"));
        System.out.println(regionRepository.findTopByCountry("Canada"));
        System.out.println("--------------Region End--------------");
        System.out.println("--------------------------------------");
        System.out.println("--------------Department Start--------------");
        System.out.println(departmentRepository.findByDepartment("Toys"));
        System.out.println(departmentRepository.findByDivision("Outdoors"));
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("--------------Department End--------------");
        System.out.println("--------------------------------------");
        System.out.println("--------------Employee Start--------------");
        System.out.println(employeeRepository.getEmployeeDetails());
        System.out.println(employeeRepository.getEmployeeSalary());
        employeeRepository.updateEmployeeJPQL(3);
        System.out.println("--------------Employee End--------------");
        System.out.println("--------------Course Start--------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("--------------------------------------");
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println(courseRepository.existsByName("Java Script for ALL"));
        System.out.println(courseRepository.countByCategory("Spring"));

        courseRepository.findByNameStartingWith("Scalable").forEach(System.out::println);

        System.out.println("--------------Course End--------------");


    }
}
