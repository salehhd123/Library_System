package com.example.exercises.Controller;


import com.example.exercises.Api.ApiResponse;
import com.example.exercises.Model.Book;
import com.example.exercises.Model.Librarian;
import com.example.exercises.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/librarian/api/v1")
public class LibrarianController {
private final LibrarianService librarianService;


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(librarianService.get());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Librarian librarian){
        librarianService.add(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updated(@PathVariable Integer id,@RequestBody @Valid Librarian librarian){
        librarianService.update(id,librarian);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(Integer id){
        librarianService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    @GetMapping("/searchId/{id}")
    public ResponseEntity serachID(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianService.findId(id));
    }

    @GetMapping("/searchLogin/{username}/{password}")
    public ResponseEntity serachLogin(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(librarianService.login(username, password));
    }

    @GetMapping("/searchEmail/{email}")
    public ResponseEntity serachEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.byEmail(email));
    }










}
