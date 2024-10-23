public class ReporterListener {
    private String name; // 클래스명을 바꿨으니까 다른 속성이 존재한다면 이런식으로 정의?
    private List<Property> properties = new ArrayList<Property>();

    public void addProperty(Property property) {
        properties.add(property);
    }
}