package study.springbootjunit.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.springbootjunit.domain.Dept;
import study.springbootjunit.repository.DeptRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeptServiceImplTest {
    final List<Dept> deptList = new ArrayList<>();
    @Autowired
    DeptService deptService;

    @BeforeEach
    void setUp() {
        createDept();
    }

    private void createDept() {
        deptList.add(new Dept("ACCOUNTING", "NEW YORK"));
        deptList.add(new Dept("RESEARCH", "DALLAS"));
        deptList.add(new Dept("SALES", "CHICAGO"));
        deptList.add(new Dept("OPERATIONS", "BOSTON"));

        for (Dept dept : deptList) {
            deptService.save(dept);
        }
    }


    @Test
    @Order(1)
    public void DEPT_입력() {
        Long deptCnt = deptService.count();

        assertThat(4L).isEqualTo(deptCnt);
    }

    @Test
    @Order(2)
    public void DEPT_수정() {
        String changeName = "ACCOUNTING2";
        Optional<Dept> optDept = deptService.getDept(1);

        Dept dept = optDept.get();
        dept.setDname(changeName);
        deptService.save(dept);

        String dname = deptService.getDept(1).get().getDname();

        assertThat(changeName).isEqualTo(dname);
    }

    @Test
    @Order(3)
    public void DEPT_삭제() {
        Integer deptNo = 1;
        deptService.delete(deptNo);

        boolean result = deptService.getDept(1).isPresent();
        assertThat(false).isEqualTo(result);
    }
}