public static int FLAGED = 4;

public List<int[]> getFlagedLine() {
  List<int[]> result = new ArrayList<int[]>();

  for (int[] line : theList) {
    if (line[0] == FLAGED) {
      result.add(line);
    }
  }
  
  return result;
}