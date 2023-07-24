package com.swithmeauth.auth.entity;

import com.swithmeauth.common.BaseEntity;
import com.swithmeauth.common.BaseInformation;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "login_id", nullable = false, length = 20)
    private String loginId;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "nick_name", nullable = false, length = 10)
    private String nickName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "contact", nullable = false, length = 12)
    private String contact;

    @Column(name = "birth", nullable = false, length = 10)
    private String birth;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "device_id", length = 32)
    private String deviceId;

    @Column(name = "address_detail", length = 50)
    private String addressDetail;

    @Column(name = "districtId")
    private Long districtId;

    @Embedded
    private BaseInformation baseInformation;

    public User() {
    }

    public User(
            Long userId,
            String password,
            String loginId,
            String name,
            String nickName,
            String email,
            String contact,
            String birth,
            String gender,
            String deviceId,
            String addressDetail,
            Long districtId,
            BaseInformation baseInformation
    ) {
        this.userId = userId;
        this.password = password;
        this.loginId = loginId;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.contact = contact;
        this.birth = birth;
        this.gender = gender;
        this.deviceId = deviceId;
        this.addressDetail = addressDetail;
        this.districtId = districtId;
        this.baseInformation = baseInformation;
    }
}
