package jwlee.springboot_crud.domain.repository;


import jwlee.springboot_crud.domain.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    // DB 관련 쿼리를 자바 메소드로 사용 가능하게끔 해주는 상속리포지토리
}
