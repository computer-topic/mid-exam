// What is the difference between the following codes?

public interface Vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}
// 내부적으로 가솔린을 사용하는 자동차임을 내포함

public interface Vehicle {
    double getPercentFuelRemaining();
}
// 전기차가 추가되어도 문제없음
