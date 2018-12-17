package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getById(long id) {
        for (Book elem : list) {
            if (elem.getId() == id) {
                return elem;
            }
        }
        return new Book();
    }

    public void updateBook(long id, long newId, String isbn, String title, String author, String publisher, String type){
        Book book1 = getById(id);
        Book book2 = getById(newId);

        if (book1 != null){
            list.remove(book1);
        }
    }

    public void deleteBook(long id){
        Book book = getById(id);
        if (book != null){
        list.remove(book);
        }
    }

}

