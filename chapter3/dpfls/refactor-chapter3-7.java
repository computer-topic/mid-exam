(1) appendFooter(content);

footer.append(content);

(2) public boolean set(String attribute, String value)

public boolean existAttribute(String attribute);
public void setAttribute(String attribute, String value) {
    if (existAttribute(attribute)) {
        set(attribute, value);
    }
}