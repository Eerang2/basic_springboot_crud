package jwlee.springboot_crud.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book {

    private Long id;                // DB primary key
    private String title;           // 책 제목
    private String author;          // 책 저자
    private String description;     // 책 정보

    /**
     * 생성자
     * @param id
     * @param title
     * @param author
     * @param description
     */
    public Book(Long id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }


}
