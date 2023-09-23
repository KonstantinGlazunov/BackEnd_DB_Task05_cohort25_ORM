package de.ait.ec.controllers;

import de.ait.ec.dto.CourseDTO;
import de.ait.ec.dto.NewCourseDto;
import de.ait.ec.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService coursesService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO addCourse(@RequestBody NewCourseDto newCourse) {
        System.out.println("Received request with data: " + newCourse);
        return coursesService.addCourse(newCourse);
    }


    @GetMapping
    public List<CourseDTO> getCourses() {
return coursesService.getCourses();
    }

}
