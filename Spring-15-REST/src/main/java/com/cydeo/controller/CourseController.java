package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller + ResponseBody
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<CourseDTO> getAllCourses(){
        return  courseService.getCourses();
    }
    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id")Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name")String category){
        return courseService.getCoursesByCategory(category);
    }
    @PostMapping()
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
      return   courseService.createCourse(courseDTO);

    }
    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id")Long id,@RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id,courseDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id")Long id){
        courseService.deleteCourseById(id);
    }


}
