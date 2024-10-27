package com.murat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name", nullable = false, length = 40)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 40 )
    private String lastName;
    @Column(name="birth_of_date", nullable = true)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private String birthOfDate;

}
