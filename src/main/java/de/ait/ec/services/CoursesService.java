package de.ait.ec.services;

import de.ait.ec.dto.CourseDTO;
import de.ait.ec.dto.NewCourseDto;

import java.util.List;

public interface CoursesService {

    CourseDTO addCourse(NewCourseDto newCourse);

    List<CourseDTO> getCourses();
}
