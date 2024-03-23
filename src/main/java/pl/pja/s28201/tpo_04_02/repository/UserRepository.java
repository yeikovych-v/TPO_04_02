package pl.pja.s28201.tpo_04_02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import pl.pja.s28201.tpo_04_02.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @NonNull
    List<User> findAll();

    @Override
    @NonNull
    Optional<User> findById(@NonNull Long id);

    void deleteById(@NonNull Long id);
}
