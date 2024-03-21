package org.foo.impl;

import org.foo.entity.Employee;
import org.foo.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository {

    @Override
    public int getHouryRate() {
        Employee employee = new Employee("Dreni","It",40);
        return employee.getHourlyRate();
    }
}
