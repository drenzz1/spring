package org.foo.impl;

import org.foo.repository.HoursRepository;
import org.springframework.stereotype.Component;

@Component
public class RegularHours implements HoursRepository {
    @Override
    public int getHours() {
        return 40;
    }
}
