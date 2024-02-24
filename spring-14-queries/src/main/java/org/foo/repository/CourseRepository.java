package org.foo.repository;

import org.foo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByCategory(String category);

    List<Course>findByCategoryOrderByName(String category);
    boolean existsByName(String name);

    Long countByCategory(String category);

    List<Course>findByNameStartingWith(String name);

    Stream<Course>streamByCategory(String category);


}
