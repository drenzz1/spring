package org.foo.bootstrap;

import org.foo.entity.Car;
import org.foo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataGenerator implements  CommandLineRunner {
    private final CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car c1 = new Car("BMW","M3");
        Car c2 = new Car("BMW","M5");
        Car c3 = new Car("BMW","M2");
        List<Car > cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        carRepository.saveAll(cars);
    }

}
