// What is the difference between the following codes?

// 가솔린 차만 사용 가능하다는 제약이 있음
public interface Vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}

// 연료 종류에 상관 없이 사용 가능
public interface Vehicle {
    double getPercentFuelRemaining();
}