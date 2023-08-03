package study.springbootjunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springbootjunit.domain.Dept;
import study.springbootjunit.repository.DeptRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    public DeptServiceImpl(final DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public void save(final Dept dept) {
        deptRepository.save(dept);
    }

    @Override
    public Long count() {
        return deptRepository.count();
    }

    @Override
    public Optional<Dept> getDept(final Integer deptNo) {
        return deptRepository.findById(deptNo);
    }

    @Override
    public List<Dept> list() {
        return new ArrayList<>(deptRepository.findAll());
    }

    @Override
    public void delete(final Integer deptNo) {
        deptRepository.deleteById(deptNo);
    }
}
