package com.boost.webapp.utility;


import com.boost.webapp.repository.entity.Default;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ServiceManager<T extends Default, ID> implements IService<T, ID> {
    /**
     * UserRepository
     * UserDetailRepository     *
     * @param t
     * @return
     */
    private final JpaRepository<T, ID> repository;

    public ServiceManager(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        t.setCreatedate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        t.forEach(x -> x.setCreatedate(System.currentTimeMillis()));
        return repository.saveAll(t);
    }

    @Override
    public T update(T t) {
        t.setUpdatedate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}