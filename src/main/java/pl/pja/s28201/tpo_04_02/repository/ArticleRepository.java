package pl.pja.s28201.tpo_04_02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import pl.pja.s28201.tpo_04_02.model.Article;
import pl.pja.s28201.tpo_04_02.model.Blog;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @NonNull
    List<Article> findAll();

    List<Article> findByBlog(Blog blog);

    @Override
    @NonNull
    Optional<Article> findById(@NonNull Long id);

    void deleteById(@NonNull Long id);
}
