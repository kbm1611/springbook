package springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        title = article.getTitle();
        content = article.getContent();
    }
}
