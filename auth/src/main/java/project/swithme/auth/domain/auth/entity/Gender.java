package project.swithme.auth.domain.auth.entity;

import lombok.Getter;

@Getter
public enum Gender {
    MAN,
    WOMAN;

    public Gender valueOfElseException(String name) {
        try {
            return Gender.valueOf(name);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 성별을 입력하세요");
        }
    }
}
