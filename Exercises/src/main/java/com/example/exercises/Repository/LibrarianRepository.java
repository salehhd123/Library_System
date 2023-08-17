package com.example.exercises.Repository;

import com.example.exercises.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByUsernameAndPassword(String name,String password);

    Librarian findLibrarianByEmail(String email);

}
