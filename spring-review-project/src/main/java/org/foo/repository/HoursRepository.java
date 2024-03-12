package org.foo.repository;

import org.springframework.stereotype.Component;

@Component
public interface HoursRepository {
    int getHours();
}
