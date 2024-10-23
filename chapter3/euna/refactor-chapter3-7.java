(1) appendFooter(content);
// 교재에서는 content.appendFooter()로 리팩토링함
content.append(footer);
-> content가 footer인지, content에 footer를 추가하는 것인지 모호함

(2) public boolean set(String attribute, String value)
// 예시 코드
// if (set("username", "unclebob")) ...
// 이 코드를 통해 (2)의 문제점은 username과 unclebob이 같다는 것을 의미하는지, username이라는 속성에 unclebob을 설정하라는 것인지 모호해진다는 것
attribute.set(value);
-> 속성에 값을 지정한다는 의도를 드러내기 위해 속성을 클래스로 만들어 set 함수를 따로 만들어야 한다고 생각함
// 교재에서는 다음과 같이 분리하도록 추천함
// 로직을 분리하여 설정하도록 한다
// if (doesAttributeExist("username")) {
//   setAttribute("username", "unclebob");
// }