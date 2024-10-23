public int countTestCases(List<Test> tests) {
    int count = 0;

    for (Test eachTest : tests) {
        count += eachTest.countTestCases();
    }
    return count;
}

// 교재 내용: 반복문의 i 변수처럼 임시로 사용하는 변수는 함수 상단이 아니라
// 사용되는 코드 근처에 선언하는 것이 가독성에 더 좋을 수 있다