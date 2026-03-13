package springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootdeveloper.domain.Article;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
