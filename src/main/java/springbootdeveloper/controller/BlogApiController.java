package springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootdeveloper.domain.Article;
import springbootdeveloper.dto.AddArticleRequest;
import springbootdeveloper.dto.ArticleResponse;
import springbootdeveloper.dto.UpdateArticleRequest;
import springbootdeveloper.service.BlogService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/articles")
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleResponse> deleteArticle(@PathVariable long id){
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(new ArticleResponse(updateArticle));
    }
}
