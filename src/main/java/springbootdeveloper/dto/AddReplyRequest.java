package springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbootdeveloper.domain.Article;
import springbootdeveloper.domain.Reply;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddReplyRequest {
    private long aid;
    private String content;

    public Reply toEntity(){
        return Reply.builder().content(content).article( Article.builder().aid(aid).build() )
                .build();
    }
}
