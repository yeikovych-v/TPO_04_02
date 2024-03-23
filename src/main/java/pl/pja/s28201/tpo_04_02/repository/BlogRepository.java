package pl.pja.s28201.tpo_04_02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import pl.pja.s28201.tpo_04_02.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    @NonNull
    List<Blog> findAll();

    @Override
    @NonNull
    Optional<Blog> findById(@NonNull Long id);

    void deleteById(@NonNull Long id);
}
