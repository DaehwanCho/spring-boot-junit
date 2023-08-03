package study.springbootjunit.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.Assert;

@Getter
@Setter
@ToString
@Table(name = "dept")
@Entity
@AllArgsConstructor
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptNo;
    private String dname;
    private String loc;

    public Dept() {
    }

    public Dept(final String dname, final String loc) {
        Assert.hasText(dname, "부서명은 필수입니다.");
        Assert.hasText(loc, "부서위치는 필수입니다.");
        this.dname = dname;
        this.loc = loc;
    }
}
