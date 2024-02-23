package org.foo.boostrap;

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

        System.out.println("--------------Employee End--------------");



    }
}
