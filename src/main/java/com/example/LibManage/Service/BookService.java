package com.example.LibManage.Service;

import com.example.LibManage.Entity.Book;
import com.example.LibManage.Error.BookNotFoundException;
import com.example.LibManage.ISBNGenerator;
import com.example.LibManage.Repository.BookRepository;
import com.example.LibManage.Request.AddBookRequest;
import com.example.LibManage.Request.UpdateBookAvailabilityRequest;
import com.example.LibManage.Request.UpdateBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ISBNGenerator isbnGenerator;

    public boolean isBookExist(String isbn) {
        return  bookRepository.findByIsbn(isbn).isPresent();
    }

    public void addBook(AddBookRequest addBookRequest) {
        try {
            String isbn;
            do {
                isbn = isbnGenerator.generateRandomIsbn13();
            } while (isBookExist(isbn));

            Book book = new Book();
            book.setIsbn(isbn);
            book.setAuthor(addBookRequest.getAuthor());
            book.setTitle(addBookRequest.getTitle());
            book.setCategory(addBookRequest.getCategory());
            book.setAvailability(addBookRequest.getAvailability());

            bookRepository.save(book);
        } catch (Exception e){
            e.getMessage();
        }
    }

    public void deleteBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException());
        bookRepository.delete(book);
    }

    public void updateBook(UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findByIsbn(updateBookRequest.getIsbn())
                .orElseThrow(() -> new BookNotFoundException());

        book.setAuthor(updateBookRequest.getAuthor());
        book.setTitle(updateBookRequest.getTitle());
        book.setCategory(updateBookRequest.getCategory());
        book.setAvailability(updateBookRequest.getAvailability());

        bookRepository.save(book);
    }

    public void updateBookAvailability(UpdateBookAvailabilityRequest updateBookAvailabilityRequest) {
        Book book = bookRepository.findByIsbn(updateBookAvailabilityRequest.getIsbn())
                .orElseThrow(() -> new BookNotFoundException());

        book.setAvailability(!book.getAvailability());
        bookRepository.save(book);
    }
}
