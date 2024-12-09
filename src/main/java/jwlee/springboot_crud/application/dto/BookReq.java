package jwlee.springboot_crud.application.dto;

import jakarta.validation.constraints.NotBlank;
import jwlee.springboot_crud.domain.model.Book;
import lombok.Builder;
import lombok.Getter;


public class BookReq {

    @Getter
    @Builder
    public static class Create {

        @NotBlank(message = "제목은 필수입니다.")
        private String title;

        @NotBlank(message = "저자은 필수입니다.")
        private String author;

        private String description;

        public Book toBook() {
            return Book.builder()
                    .title(title)
                    .author(author)
                    .description(description)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class Update {

        private Long id;

        @NotBlank(message = "제목은 필수입니다.")
        private String title;

        @NotBlank(message = "저자은 필수입니다.")
        private String author;

        private String description;

        public Book toBook() {
            return Book.builder()
                    .id(id)
                    .title(title)
                    .author(author)
                    .description(description)
                    .build();
        }
    }
}
