package de.ait.ec.dto;

import de.ait.ec.models.Course;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class NewCourseDto {


    private String title;
    private String description;
    private String beginDate;
    private String endDate;
    private Double price;

}
