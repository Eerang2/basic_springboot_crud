package jwlee.springboot_crud.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                     // 빌드 될 때 스프링 빈 생성을 위해 엔티티 클래스 지정을 위한 어노테이션
@Table(name = "book")       // 테이블 명 지정
@Getter
@Setter
@NoArgsConstructor          // 빈생성자 생성
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_no", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String description;

    public BookEntity(Long id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }
    public BookEntity(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

}
