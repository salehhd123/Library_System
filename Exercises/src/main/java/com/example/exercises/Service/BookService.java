package com.example.exercises.Service;


import com.example.exercises.Api.ApiException;
import com.example.exercises.Model.Book;
import com.example.exercises.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> get(){
        return bookRepository.findAll();
    }

    public void add(Book book){
    bookRepository.save(book);
    }

    public void update(Integer id,Book book){
        Book book1 = bookRepository.findBookById(id);
        if (book1==null){
            throw new ApiException("not found");
        }
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setCategory(book.getCategory());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(book);
    }


    public void delete(Integer id){
        Book book1 = bookRepository.findBookById(id);
        if (book1==null){
            throw new ApiException("not found");
        }
        bookRepository.delete(book1);
    }


    public List<Book> findC(String name){
        List<Book> g = bookRepository.findAllByCategory(name);
        if(g.isEmpty()){
            throw new ApiException("not found");
        }
        return g;
    }

    public List<Book> findP(){
        Integer num=300;
        List<Book> g = bookRepository.findBooksByNumberOfPagesGreaterThanEqual(num);
        if(g.isEmpty()){
            throw new ApiException("not found");
        }
        return g;
    }

    public List<Book> finda(String name){
        List<Book> g = bookRepository.findBooksByAuthor(name);
        if(g.isEmpty()){
            throw new ApiException("not found");
        }
        return g;
    }


    public Book findt(String name){
        Book book = bookRepository.findBookByTitle(name);
        if(book==null){
            throw new ApiException("not found");
        }
        return book;
    }
















}
