package maria.hei.gestion_location.repository;

import maria.hei.gestion_location.entity.User;

import java.util.List;

public interface RepositoryInterface<T> {
    T getById(int id);
    List<T> getAll();
    T create(T user);
    User update(T model);
    void delete(int id);
}
