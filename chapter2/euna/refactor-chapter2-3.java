public static final int FLAG = 0;
public static final int FLAGGED = 4;

public class Cell{
  // 강의안에서는 다음과 같이 클래스 내부에서 flagged임을 확인함
  // why? 클래스 내의 멤버변수는 private이기 때문에 배열에 직접 접근할 수 없음 이에 따라 클래스 내에서 isFlagged로 만들어낸 것임
  // public static final int STATUS_VALUE = 0;
  // public static final int FLAGGED = 4;
  private int[] cell;

  // public boolean isFlagged() {
  //   if (cell[STATUS_VALUE] = FLAGGED)
  //     return true;
  //   return false;
  // }
}

// 강의안에서는 addFlaggedCells
public List<Cell> getFlaggedFlag(List<Cell> checkedCells) {
  // 강의안에서는 flaggedCells
  List<Cell> cells = new ArrayList<Cell>();
  // 강의안에서는 checkedCelles가 아니라 gameBoard
  for (Cell cell : checkedCells)
    // 강의안에서는 객체 메서드를 통해 확인
    // if (cell.isFlagged())
    if (cell[FLAG] == FLAGGED)
      cells.add(cell);
  return cells;
}