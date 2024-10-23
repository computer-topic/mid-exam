private static final int EXPANDED_SIZE = 10;

public void add(Object element) {
    if (readOnly)
        return ;
    if (isFull(element)) {
        replaceElementWithNewElements();
    }
    addNewElement(element);
}

private boolean isFull(Object element) {
    return size + 1 > element.length;
}

private void replaceElementWithNewElements() {
    Object[] newElements;

    newElements = new Object[elements.length + EXPANDED_SIZE];
    for (int i = 0; i < size; i++) {
        newElements[i] = elements[i];
    }
    elements = newElements;
}

private void addNewElement(Object element) {
    elements[size++] = element;
}