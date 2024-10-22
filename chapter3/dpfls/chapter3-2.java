public void add(Object element) {
  if (!readOnly) {
    int newSize = size + 1;
    if (newSize > element.length) {
      Object[] newElements = new Object[elements.length+10];
      for (int i = 0; i < size; i++) {
        newElements[i] = elements[i];
      }
      elements = newElements;
    }
    elements[size++] = element;
  }
}