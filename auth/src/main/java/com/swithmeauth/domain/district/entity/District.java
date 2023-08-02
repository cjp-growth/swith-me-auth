package com.swithmeauth.domain.district.entity;

import com.swithmeauth.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity(name = "district")
public class District extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "build_name", length = 70)
    private String buildName;

    @Column(name = "build_no1", length = 5)
    private String buildNo1;

    @Column(name = "build_no2", length = 4)
    private String buildNo2;

    @Column(name = "build_num", length = 25)
    private String buildNum;

    @Column(name = "dong", length = 20)
    private String dong;

    @Column(name = "dong_code", length = 10)
    private String dongCode;

    @Column(name = "dong_hj", length = 30)
    private String dongHj;

    @Column(name = "doro", length = 40)
    private String doro;

    @Column(name = "doro_code", length = 12)
    private String doroCode;

    @Column(name = "doro_en", length = 50)
    private String doroEn;

    @Column(name = "eupmyun", length = 20)
    private String eupmyun;

    @Column(name = "eupmyun_en", length = 25)
    private String eupmyunEn;

    @Column(name = "eupmyundong_no", length = 2)
    private String eupmyundongNo;

    @Column(name = "jibun1", length = 4)
    private String jibun1;

    @Column(name = "jibun2", length = 4)
    private String jibun2;

    @Column(name = "mount_yn", length = 1)
    private String mountYn;

    @Column(name = "multiple", length = 1)
    private String multiple;

    @Column(name = "ri", length = 20)
    private String ri;

    @Column(name = "sido", length = 25)
    private String sido;

    @Column(name = "sido_en", length = 20)
    private String sidoEn;

    @Column(name = "sigungu", length = 30)
    private String sigungu;

    @Column(name = "sigungu_en", length = 30)
    private String sigunguEn;

    @Column(name = "under_yn", length = 1)
    private String underYn;

    @Column(name = "zipcode", length = 5)
    private String zipcode;

    @Column(name = "zipcode_old", length = 7)
    private String zipcodeOld;

    @Column(name = "zipcode_seq", length = 3)
    private String zipcodeSeq;

    protected District() {
    }

    public District(Long id,
        String buildName,
        String buildNo1,
        String buildNo2,
        String buildNum,
        String dong,
        String dongCode,
        String dongHj,
        String doro,
        String doroCode,
        String doroEn,
        String eupmyun,
        String eupmyunEn,
        String eupmyundongNo,
        String jibun1,
        String jibun2,
        String mountYn,
        String multiple,
        String ri,
        String sido,
        String sidoEn,
        String sigungu,
        String sigunguEn,
        String underYn,
        String zipcode,
        String zipcodeOld,
        String zipcodeSeq
    ) {
        this.id = id;
        this.buildName = buildName;
        this.buildNo1 = buildNo1;
        this.buildNo2 = buildNo2;
        this.buildNum = buildNum;
        this.dong = dong;
        this.dongCode = dongCode;
        this.dongHj = dongHj;
        this.doro = doro;
        this.doroCode = doroCode;
        this.doroEn = doroEn;
        this.eupmyun = eupmyun;
        this.eupmyunEn = eupmyunEn;
        this.eupmyundongNo = eupmyundongNo;
        this.jibun1 = jibun1;
        this.jibun2 = jibun2;
        this.mountYn = mountYn;
        this.multiple = multiple;
        this.ri = ri;
        this.sido = sido;
        this.sidoEn = sidoEn;
        this.sigungu = sigungu;
        this.sigunguEn = sigunguEn;
        this.underYn = underYn;
        this.zipcode = zipcode;
        this.zipcodeOld = zipcodeOld;
        this.zipcodeSeq = zipcodeSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof District district)) {
            return false;
        }
        return getId().equals(district.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
