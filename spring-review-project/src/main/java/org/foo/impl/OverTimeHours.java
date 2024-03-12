package org.foo.impl;

import org.foo.repository.HoursRepository;
import org.springframework.stereotype.Component;

@Component
public class OverTimeHours implements HoursRepository {
    @Override
    public int getHours() {
        return 15;
    }
}
