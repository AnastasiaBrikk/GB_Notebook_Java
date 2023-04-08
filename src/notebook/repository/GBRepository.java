package notebook.repository;

import java.util.List;
import java.util.Optional;

import notebook.model.User;


// Репозиторий, для выполнения CreateReadUpdateDelete (CRUD) операций

public interface GBRepository {
    List<User> findAll();
    User create(User user);
    Optional<User> findById(Long id);
    Optional<User> update(Long id, User e);
    boolean delete(Long id);
}
