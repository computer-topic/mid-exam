(1)
// Check to see if the employee is eligible for full benefits
if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))

boolean isEligibleForFullBenefits = (employee.flags & HOURLY_FLAG) && (employee.age > 65)
if(isEligibleForFullBenefits) {
  ...
}

// 교재에서는 객체지향관점을 도입하여 다음과 같이 리팩토링함
// employee의 멤버변수에 직접 접근하는 것은 좋지 못한 방법이므로 클래스내에서 조건을 확인하는 메서드를 분리
// if (employee.isEligibleForFullBenefits()) {
//   ...
// }


(2)
// Returns an instance of the Responder being tested.
protected abstract Responder responderInstance();

// 교재와 같음
protected abstract Responder getResponsederBeingTested();