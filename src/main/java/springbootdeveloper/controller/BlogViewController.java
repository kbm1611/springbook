package springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springbootdeveloper.domain.Article;
import springbootdeveloper.dto.ArticleListViewResponse;
import springbootdeveloper.dto.ArticleViewResponse;
import springbootdeveloper.dto.ReplyListViewResponse;
import springbootdeveloper.service.BlogService;
import springbootdeveloper.service.ReplyService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/articles")
public class BlogViewController {

    private final BlogService blogService;
    private final ReplyService replyService;

    @GetMapping
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList"; // 글 목록을 보여주는 HTML 파일명 (확인 필요)
    }

    @GetMapping("/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        // 1. 선택한 게시글 정보 조회 (조회수 증가 포함)
        Article article = blogService.findByIdAndIncreaseViews(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        // 2. 해당 게시글에 달린 댓글 목록 가져오기 (게시글 번호 사용)
        List<ReplyListViewResponse> replies = replyService.findAllByArticleId(id).stream()
                .map(ReplyListViewResponse::new)
                .toList();
        model.addAttribute("replies", replies); // HTML의 th:each="item : ${replies}"와 연결됨

        return "article"; // 현재 작업 중인 HTML 파일명
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id == null){
            model.addAttribute("article", new ArticleViewResponse());
        }else{
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
