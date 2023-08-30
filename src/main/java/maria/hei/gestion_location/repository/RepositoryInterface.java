package maria.hei.gestion_location.repository;

import java.util.List;

public interface RepositoryInterface<T> {
    T getById(int id);
    List<T> getAll();
    T create(T user);
    void update(T model);
    void delete(int id);
}
