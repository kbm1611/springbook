package springbootdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private long views;

    public ArticleViewResponse(Article article){
        id = article.getAid();
        title = article.getTitle();
        content = article.getContent();
        createdAt = article.getCreatedAt();
        views = article.getViews();
    }
}
