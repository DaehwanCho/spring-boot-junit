package study.springbootjunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springbootjunit.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
}
