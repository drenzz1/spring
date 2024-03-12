package org.foo.service;

import org.foo.repository.EmployeeRepository;
import org.foo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {
    private final HoursRepository hoursRepository;
    private final EmployeeRepository employeeRepository;

    public SalaryService(@Qualifier("overTimeHours") HoursRepository hoursRepository,  EmployeeRepository employeeRepository) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }
    public int calculateRegularySalary(){
        return hoursRepository.getHours() * employeeRepository.getHouryRate();
    }
}
