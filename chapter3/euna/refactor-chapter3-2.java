public static final int EXPANDED_SIZE = 10;

public void add(Object element){
  if (readOnly) {
    return;
  }
  boolean isFull = checkFullStatus(element); 
  if (isFull) {
    convertNewElementsToElements();
  }
  addNewElement(element);
}

private boolean checkFullStatus(Object element) {
  int newSize = size + 1;
  return newSize > element.length;
}

private void convertNewElementsToElements() {
  Object[] newElements = new Object[elements.length + EXPANDED_SIZE];
    for (int i = 0; i < size; i++) {
      newElements[i] = elements[i];
    }
  elements = newElements;
}

private void addNewElement(Object element) {
  elements[size++] = element;
}