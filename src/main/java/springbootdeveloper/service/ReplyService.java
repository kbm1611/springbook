package springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootdeveloper.domain.Reply;
import springbootdeveloper.dto.AddReplyRequest;
import springbootdeveloper.repository.ReplyRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public Reply save(AddReplyRequest request){
        return replyRepository.save(request.toEntity());
    }

    public List<Reply> findAllByArticleId(Long aid) {
        return replyRepository.findAllByArticleAid(aid);
    }

    public void delete(long id){
        replyRepository.deleteById(id);
    }
}
