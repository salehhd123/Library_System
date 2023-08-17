package com.example.exercises.Service;


import com.example.exercises.Api.ApiException;
import com.example.exercises.Model.Book;
import com.example.exercises.Model.Librarian;
import com.example.exercises.Repository.LibrarianRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;


    public List<Librarian> get(){
        return librarianRepository.findAll();
    }

    public void add(Librarian librarian){
        librarianRepository.save(librarian);
    }

    public void update(Integer id,Librarian l){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian==null){
            throw new ApiException("not found");
        }
        librarian.setName(l.getName());
        librarian.setUsername(l.getUsername());
        librarian.setPassword(l.getPassword());
        librarian.setEmail(l.getEmail());
        librarianRepository.save(l);
    }


    public void delete(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian==null){
            throw new ApiException("not found");
        }
        librarianRepository.delete(librarian);
    }


    public Librarian findId(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }



    public Librarian login(String username,String password){
        Librarian librarian =librarianRepository.findLibrarianByUsernameAndPassword(username,password);
        if (librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }

    public Librarian byEmail(String email){
    Librarian librarian = librarianRepository.findLibrarianByEmail(email);
        if (librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }

}
