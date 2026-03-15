package springbootdeveloper.dto;

import lombok.Getter;
import springbootdeveloper.domain.Reply;

import java.time.LocalDateTime;

@Getter
public class ReplyListViewResponse {
    private final Long id;
    private final String content;
    // 템플릿에서 사용하는 이름(`createdAt`)에 맞춰 필드명 수정
    private final LocalDateTime createdAt;

    public ReplyListViewResponse(Reply reply){
        this.id = reply.getRid();
        this.content = reply.getContent();
        this.createdAt = reply.getCreatedAt();
    }
}

