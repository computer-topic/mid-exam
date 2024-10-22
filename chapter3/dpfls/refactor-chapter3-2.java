public void add(Object element) {
    if (readOnly)
        return ;
    if (isFull(element, currentSize)) {
        elements = getNewElements(currentSize);
    }
    elements[currentSize++] = element;
}

private boolean isFull(Object element, int currentSize) {
    int newSize = currentSize + 1;
    return newSize > element.length;
}

private getNewElements(int currentSize) {
    Object[] newElements;

    newElements = new Object[elements.length + 10];
    for (int i = 0; i < currentSize; i++) {
        newElements[i] = elements[i];
    }
    return newElements;
}