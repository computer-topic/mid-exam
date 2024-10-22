(1) appendFooter(content);
content.append(footer);
-> content가 footer인지, content에 footer를 추가하는 것인지 모호함

(2) public boolean set(String attribute, String value)
attribute.set(value);
-> 속성에 값을 지정한다는 의도를 드러내기 위해 속성을 클래스로 만들어 set 함수를 따로 만들어야 한다고 생각함