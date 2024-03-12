package org.foo.service;

import org.foo.repository.EmployeeRepository;
import org.foo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {
    private final HoursRepository hoursRepository;
    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository2;

    public SalaryService(HoursRepository hoursRepository, EmployeeRepository employeeRepository,@Qualifier("overTimeHours") HoursRepository hoursRepository2) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
        this.hoursRepository2 = hoursRepository2;
    }

    public int calculateRegularySalary(){
        return hoursRepository.getHours() * employeeRepository.getHouryRate();
    }
    public int calculateOverTimeSalary(){
        return hoursRepository2.getHours() * employeeRepository.getHouryRate();
    }

}
