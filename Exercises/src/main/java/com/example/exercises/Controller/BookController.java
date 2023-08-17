package com.example.exercises.Controller;


import com.example.exercises.Api.ApiResponse;
import com.example.exercises.Model.Book;
import com.example.exercises.Service.BookService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/api/v1")
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(bookService.get());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book book){
        bookService.add(book);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updated(@PathVariable Integer id,@RequestBody @Valid Book book){
        bookService.update(id,book);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(Integer id){
        bookService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    @GetMapping("/searchC/{name}")
    public ResponseEntity searchC(@PathVariable String name){
        return ResponseEntity.status(200).body(bookService.findC(name));
    }

    @GetMapping("/searchP")
    public ResponseEntity searchP(){
        return ResponseEntity.status(200).body(bookService.findP());
    }

    @GetMapping("/searchA/{name}")
    public ResponseEntity searcha(@PathVariable String name){
        return ResponseEntity.status(200).body(bookService.finda(name));
    }

    @GetMapping("/searchT/{name}")
    public ResponseEntity searcht(@PathVariable String name){
        return ResponseEntity.status(200).body(bookService.findt(name));
    }



}
