package jwlee.springboot_crud.domain.service;

import jwlee.springboot_crud.domain.model.Book;
import jwlee.springboot_crud.domain.repository.BookRepository;
import jwlee.springboot_crud.domain.repository.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book bookCreate(final Book book) {

        // entity 로 형변환
        BookEntity bookEntity = new BookEntity(book.getTitle(), book.getAuthor(), book.getDescription());

        // DB 에 담아주는 .save 메서드 사용 후에 entity 에 담음
        BookEntity saved = bookRepository.save(bookEntity);

        // DB 에 저장된 애들을 model 클래스로 형변환 후 반환
        Book savedBook = new Book(saved.getId(), saved.getTitle(), saved.getAuthor(), saved.getDescription());
        return savedBook;
    }

    public List<Book> bookList() {

        // DB 에 저장되어있는 애들 entity 객체 리스트로 뽑음
        List<BookEntity> bookEntities = bookRepository.findAll();

        // 기본 모델  arrayList 객체 만들어서 반복문 돌면서 형변환
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            books.add(new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getDescription()));
        }
        return books;

/**
 *         < stream 사용 >
 *
 *         List<Book> books = bookRepository.findAll().stream()
 *                 .map(bookEntity -> new Book(
 *                         bookEntity.getId(),
 *                         bookEntity.getTitle(),
 *                         bookEntity.getAuthor(),
 *                         bookEntity.getDescription()
 *                 ))
 *                 .collect(Collectors.toList());
 *
 *         return books;
 */
    }

    public Book findBookById(final Long id) {

        // DB 에 저장되어있는 id 값으로 해당 책 정보 추출
        BookEntity bookEntity = bookRepository.findById(id)
                                    .orElseThrow(RuntimeException::new);

        // bookEntity -> book 형변환
        Book book = new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getDescription());
        return book;
    }

    public Book bookUpdate(Book book) {

        // book -> bookEntity 로 형변환
        BookEntity bookEntity = new BookEntity(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription());

        // 기존에 DB 에 저장되어있는 정보 추출
        BookEntity entity = bookRepository.findById(bookEntity.getId())
                                          .orElseThrow(RuntimeException::new);


        // 추출한 정보 수정할 값으로 set
        entity.setTitle(bookEntity.getTitle());
        entity.setAuthor(bookEntity.getAuthor());
        entity.setDescription(bookEntity.getDescription());

        // dirty checking 으로 기존의 값에 업데이트 쿼리 실행
        BookEntity saved = bookRepository.save(entity);

        Book updated = new Book(saved.getId(), saved.getTitle(), saved.getAuthor(), saved.getDescription());
        return updated;
    }

    public void bookDelete(final Long id) {

        // id 로 해당 정보 추출
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(RuntimeException::new);

        // 추출한 정보 삭제 쿼리 실행
        bookRepository.delete(bookEntity);
    }
}
