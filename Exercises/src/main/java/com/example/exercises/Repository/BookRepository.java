package com.example.exercises.Repository;

import com.example.exercises.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    Book findBookById(Integer id);

    List<Book> findAllByCategory(String name);

    List<Book> findBooksByNumberOfPagesGreaterThanEqual(Integer number);

    List<Book> findBooksByAuthor(String name);

    Book findBookByTitle(String name);
}
