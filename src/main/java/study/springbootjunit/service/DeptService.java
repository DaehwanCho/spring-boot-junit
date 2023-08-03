package study.springbootjunit.service;

import study.springbootjunit.domain.Dept;

import java.util.List;
import java.util.Optional;

public interface DeptService {

    void save(Dept dept);

    Long count();

    Optional<Dept> getDept(Integer deptNo);

    List<Dept> list();

    void delete(Integer deptNo);
}
