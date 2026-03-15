package springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootdeveloper.domain.Reply;
import springbootdeveloper.dto.AddReplyRequest;
import springbootdeveloper.dto.ReplyResponse;
import springbootdeveloper.service.ReplyService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/replies")
public class ReplyApiController {
    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<Reply> addArticle(@RequestBody AddReplyRequest request){
        Reply savedArticle = replyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/aid")
    public ResponseEntity<List<ReplyResponse>> findAllByArticleId(@PathVariable Long aid){
        List<ReplyResponse> replies = replyService.findAllByArticleId(aid)
                .stream()
                .map(ReplyResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(replies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReplyResponse> deleteArticle(@PathVariable long id){
        replyService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
