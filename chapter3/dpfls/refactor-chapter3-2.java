public void add(Object element) {
    if (readOnly)
        return ;
    if (isFull(size)) {
        elements = getNewElements(size);
    }
    elements[size++] = element;
}

private boolean isFull(int size) {
    return (size + 1 > element.length);
}

private getNewElements(int size) {
    Object[] newElements;

    newElements = new Object[elements.length + 10];
    for (int i = 0; i < size; i++) {
        newElements[i] = elements[i];
    }
    return newElements;
}