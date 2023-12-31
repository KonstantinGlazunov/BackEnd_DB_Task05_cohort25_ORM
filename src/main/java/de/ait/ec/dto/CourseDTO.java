package de.ait.ec.dto;

import de.ait.ec.models.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String beginDate;
    private String endDate;
    private Double price;
    private String state;

    public static CourseDTO from(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .beginDate(course.getBeginDate().toString())
                .endDate(course.getEndDate().toString())
                .price(course.getPrice())
                .state(course.getState().toString())
                .build();
    }

    public static List<CourseDTO> from(List<Course> courses) {
        return courses
                .stream()
                .map(CourseDTO::from)
                .collect(Collectors.toList());
    }
}
