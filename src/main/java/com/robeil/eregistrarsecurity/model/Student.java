package com.robeil.eregistrarsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @NotBlank(message = "Should not be blank")
    @Column(unique = true, nullable = false)
    private String studentNumber;

    @NotBlank(message = "Should not be blank")
    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @NotBlank(message = "Should not be blank")
    @Column(nullable = false)
    private String lastName;

    private Double cgpa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @NotBlank(message = "Should not be blank")
    @Column(nullable = false)
    private String isInternational;
}
