package springbootdeveloper.dto;

import lombok.Getter;
import springbootdeveloper.domain.Reply;

@Getter
public class ReplyResponse {
    private final String content;

    public ReplyResponse(Reply reply){
        content = reply.getContent();
    }
}
