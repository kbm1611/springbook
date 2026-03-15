package springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springbootdeveloper.domain.Article;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
    @Modifying
    @Query("update Article a set a.views = a.views + 1 where a.id = :id")
    int updateViews(@Param("id") Long id);
}
