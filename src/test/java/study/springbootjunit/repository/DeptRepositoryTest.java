package study.springbootjunit.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.springbootjunit.domain.Dept;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeptRepositoryTest {
    final List<Dept> deptList = new ArrayList<>();
    @Autowired
    DeptRepository deptRepository;

    @BeforeEach
    void setUp() {
        createDept();
    }

    private void createDept() {
        deptList.add(new Dept("ACCOUNTING", "NEW YORK"));
        deptList.add(new Dept("RESEARCH", "DALLAS"));
        deptList.add(new Dept("SALES", "CHICAGO"));
        deptList.add(new Dept("OPERATIONS", "BOSTON"));
        deptRepository.saveAll(deptList);
    }


    @Test
    @Order(1)
    public void DEPT_입력() {
        Long deptCnt = deptRepository.count();

        assertThat(4L).isEqualTo(deptCnt);
    }

    @Test
    @Order(2)
    public void DEPT_수정() {
        String changeName = "ACCOUNTING2";
        Optional<Dept> optDept = deptRepository.findById(1);

        Dept dept = optDept.get();
        dept.setDname(changeName);
        deptRepository.save(dept);

        String dname = deptRepository.findById(1).get().getDname();

        assertThat(changeName).isEqualTo(dname);
    }

    @Test
    @Order(3)
    public void DEPT_삭제() {
        Integer deptNo = 1;
        Dept dept = new Dept();
        dept.setDeptNo(deptNo);
        deptRepository.delete(dept);

        boolean result = deptRepository.findById(1).isPresent();
        assertThat(false).isEqualTo(result);
    }
}