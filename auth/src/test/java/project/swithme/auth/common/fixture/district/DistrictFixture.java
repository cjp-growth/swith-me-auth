package project.swithme.auth.common.fixture.district;

import project.swithme.auth.domain.district.entity.District;

public final class DistrictFixture {

    private DistrictFixture() {
        throw new AssertionError("올바른 방식으로 생성자를 호출해주세요.");
    }

    public static final District sadangDistrict = new District("사당동", "서울특별시");
    public static final District sillimDistrict = new District("신림동", "서울특별시");

}
