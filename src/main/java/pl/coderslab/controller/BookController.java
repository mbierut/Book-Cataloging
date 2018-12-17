package pl.coderslab.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

@RestController
@RequestMapping("/books")
@ComponentScan
public class BookController {
    private MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping("/")
    @ResponseBody
    public String getBook(){
        String list = memoryBookService.getList().toString();
        return list;
    }

    @PostMapping("/")
    @ResponseBody
    public String addBook(long id, String isbn, String title, String author, String publisher, String type){
        memoryBookService.getList().add(new Book(id, isbn, title, author, publisher, type));
        return "";
    }

    @PutMapping("/{id}")
    public String updateBook(long id){
        memoryBookService.updateBook(id);
        return "";
    }


}
