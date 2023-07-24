package com.swithmeauth.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class BaseInformation {

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "deleted")
    private boolean deleted;

    /**
     * @Nullary-Constructor. JPA 기본 생성자로 createOrder 외부 패키지에서 호출하지 말 것.
     */
    public BaseInformation() {
    }

    public BaseInformation(
            Long createdBy,
            Long lastModifiedBy,
            boolean deleted
    ) {
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return createdBy.toString();
    }
}
