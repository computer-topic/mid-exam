public class Cell {
  public static final int BASE = 0;
  public static final int FLAGED = 4;
  private int[] cell;

  public isFlagged() {
    this.cell[BASE] == FLAGED
  }
}

public List<Cell> getFlagedLine() {
  List<Cell> flaggedCells = new ArrayList<Cell>();

  for (Cell cell : gameBoard) {
    if (cell.isFlagged()) {
      flaggedCells.add(cell);
    }
  }
  
  return flaggedCells;
}