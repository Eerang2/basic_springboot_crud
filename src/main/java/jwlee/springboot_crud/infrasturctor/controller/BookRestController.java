package jwlee.springboot_crud.infrasturctor.controller;

import jwlee.springboot_crud.domain.model.Book;
import jwlee.springboot_crud.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BookRestController {

    private final BookService bookService;

    @PostMapping("/book/create")
    public Book createBook(@RequestBody final Book book) {
        Book saved = bookService.bookCreate(book);
        return saved;
    }

    @PutMapping("/book/edit")
    public Book updateBook(@RequestBody final Book book) {
        Book updated = bookService.bookUpdate(book);
        return updated;
    }
}
