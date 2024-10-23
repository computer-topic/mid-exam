(1) appendFooter(content);

// content에 footer를 추가한다고 해석
content.append(footer);

(2) public boolean set(String attribute, String value)

// attribute를 set하는 것과 set이 잘 되었는지 확인하는 boolean 값 반환을 동시에 하고 있음
// set과 return을 동시에 수행하지 않도록 변경

// attribute가 존재하는지 확인
public boolean existAttribute(String attribute)

// attribute set
public void set(String attribute, String value)
public void setAttribute(String value)
