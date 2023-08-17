package com.example.exercises.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(columnDefinition = "varchar(20)")
    private String title;

    @Column(columnDefinition = "varchar(20)")
    private String author;

    @Column(columnDefinition = "varchar(20) check(category ='academic' or category='novel' or category='mystery')")
    private String category;


    @Column(columnDefinition = "int")
    private Integer ISBN;


    @Min(value = 50 , message = "can not be less than 50!")
    private Integer numberOfPages;





}
