package notebook.repository;

import java.util.List;
import java.util.Optional;

import notebook.model.User;


// �����������, ��� ���������� CreateReadUpdateDelete (CRUD) ��������

public interface GBRepository<T> {
    List<T> findAll();
    void saveAll(List<String> data);
    User create(T user);
    Optional<T> findById(Long id);
    Optional<T> update(Long id, T e);
    boolean deleteById(Long id);
    boolean deleteAll();
}
