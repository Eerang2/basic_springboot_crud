package jwlee.springboot_crud.infrastructor.controller;

import jwlee.springboot_crud.domain.model.Book;
import jwlee.springboot_crud.application.service.BookService;
import jwlee.springboot_crud.application.dto.BookReq;
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
    public Book createBook(@RequestBody final BookReq.Create bookReq) {
        Book saved = bookService.bookCreate(bookReq.toBook());
        return saved;
    }

    @PutMapping("/book/edit")
    public Book updateBook(@RequestBody final BookReq.Update bookReq) {
        Book updated = bookService.bookUpdate(bookReq.toBook());
        return updated;
    }
}
