package pl.pja.s28201.tpo_04_02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import pl.pja.s28201.tpo_04_02.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @NonNull
    List<Role> findAll();

    @Override
    @NonNull
    Optional<Role> findById(@NonNull Long id);

    void deleteById(@NonNull Long id);
}
