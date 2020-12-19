package com.student.student.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    String id;
    String name;
    String rollNumber;
    List<Subject> subject;
}
