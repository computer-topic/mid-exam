public static final int SIZE_STEP = 1;
public static final int ADDITIONAL_SIZE_OF_NEW_ELEMENTS = 10;

public void add(Object element) {
  if (readOnly) {
    return;
  }

  int newSize = size + SIZE_STEP;
  if (newSize > element.length) {
    createNewElements();
  }

  elements[size++] = element;
}

private void createNewElements() {
  Object[] newElements = new Object[elements.length + ADDITIONAL_SIZE_OF_NEW_ELEMENTS];
  for (int i = 0; i < size; i++) {
    newElements[i] = elements[i];
  }
  elements = newElements;
}