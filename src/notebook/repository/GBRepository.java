package notebook.repository;

import java.util.List;
import java.util.Optional;

import notebook.model.User;


// Репозиторий, для выполнения CreateReadUpdateDelete (CRUD) операций

public interface GBRepository<T> {
    List<T> findAll();
    void saveAll(List<String> data);
    User create(T user);
    Optional<T> findById(Long id);
    Optional<T> update(Long id, T e);
    boolean deleteById(Long id);
    boolean deleteAll();
}
