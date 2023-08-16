package project.swithme.auth.domain.district.entity;

import project.swithme.auth.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity(name = "district")
public class District extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dong", length = 20)
    private String dong;

    @Column(name = "sigungu", length = 30)
    private String sigungu;

    protected District() {
    }

    public District(String dong, String sigungu) {
        this.dong = dong;
        this.sigungu = sigungu;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof District district)) {
            return false;
        }
        return getDong().equals(district.getDong()) && getSigungu().equals(district.getSigungu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dong, sigungu);
    }
}
