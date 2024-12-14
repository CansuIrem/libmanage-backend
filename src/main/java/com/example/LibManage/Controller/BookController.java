package com.example.LibManage.Controller;

import com.example.LibManage.Request.AddBookRequest;
import com.example.LibManage.Request.UpdateBookAvailabilityRequest;
import com.example.LibManage.Request.UpdateBookRequest;
import com.example.LibManage.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    final private BookService bookService;

    @GetMapping("/checkBook")
    public ResponseEntity<Boolean> checkBook(@RequestParam String isbn) {
        boolean response = bookService.isBookExist(isbn);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Void> addBook(@RequestBody AddBookRequest addBookRequest) {
        bookService.addBook(addBookRequest);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/deleteBook/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Void> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        bookService.updateBook(updateBookRequest);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/updateBookAvailability")
    public ResponseEntity<Void> updateBook(@RequestBody UpdateBookAvailabilityRequest updateBookAvailabilityRequest) {
        bookService.updateBookAvailability(updateBookAvailabilityRequest);

        return ResponseEntity.ok(null);
    }
}
