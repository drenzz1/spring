package org.foo.repository;

import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository {
    int getHouryRate();
}
