package springbootdeveloper.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", updatable = false)
    private Long aid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @Column(name = "views", nullable = false)
    private long views = 0; // 초기값 0

    @OneToMany( mappedBy = "article", cascade = CascadeType.ALL) // 하나가 다수에게 1 : M, 삭제시 밑에 댓글들도 같이 삭제
    @ToString.Exclude // 순환참조 방지
    @Builder.Default // new 생성자 대신에 빌더로 객체 생성시 초기값 사용
    private List<Reply> replyList = new ArrayList<>();

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
