package jwlee.springboot_crud.infrastructor.controller;

import jwlee.springboot_crud.domain.model.Book;
import jwlee.springboot_crud.application.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@RequiredArgsConstructor     // 빈생성자 파라미터 생성
public class BookController {

    private final BookService bookService;

    // GET, POST, PUT, DELETE 등 HTTP 요청 메서드
    // 해당 메서드마다 동작해야되는 역할들이 있다.
    @GetMapping("/book/list")
    public String list(Model model) {

        // List로 받아온 책들 담음
        List<Book> books = bookService.bookList();

        // 담은 애들 html 에서 쓸 수 있게 객체에 담아서 보내기
        model.addAttribute("books", books);


        // spring 내부에서 연결시켜주는 기본 설정으로 templates 밑부터 .html 까지 제외 가능
        // spring.mvc.view.prefix=/templates/
        // spring.mvc.view.suffix=.html
        return "book/list";
    }


    @GetMapping("/book/create")
    public String index() {
        return "book/create";
    }

    @GetMapping("/book/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        bookService.bookDelete(id);
        return ResponseEntity.ok("success");
    }

}
