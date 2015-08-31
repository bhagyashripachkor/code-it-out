//GameOfLife.java
public class GameOfLife {
  private int size;
  private String currentGen[][] ,nextGen[][];
  private final int noOfGenerations;
  
  public GameOfLife() {
    size = 5;
    currentGen = new String[size][size];
    nextGen = new String[size][size];
    noOfGenerations = 4;
    initGame();
  }
  
  private void initGame() {
    for (int i = 0; i < size;i++) {
      for (int j=0; j< size; j++) {
        currentGen[i][j] = ".";
      }
    }
    currentGen[1][2] = "X";
    currentGen[2][2] = "X";
    currentGen[3][2] = "X";
  }
  
  public String toString(){
    String s = "";
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        s = s + currentGen[i][j];
      }
      s = s + "\n";
    }
    return s;
  }
  
  public void NextGen(){
    int count = 0;
    for (int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        count = getNeighbours(i,j);
        //System.out.println(i + " " + j + " " + count);
        if(count == 3) {
          nextGen[i][j] = "X";
        } else if (count == 2 && currentGen[i][j] == "X"){
          nextGen[i][j] = ".";
        }
          else {
            nextGen[i][j] = ".";
        }
      }
    }
    copy();
  }
  
  private int getNeighbours(int row, int column) {
    int count = 0;
    if (row == 0 || column == 0 || row == size - 1 || column == size - 1) {
      return 0;
    }
    for (int i = row - 1; i <= row + 1; i++) {
      for(int  j = column - 1; j <= column + 1; j++) {
        if(currentGen[i][j] == "X") {
          count++;
        }
      }
    }
    //if(currentGen[row][column] == "X") {
    //  return count--;
  //  }
    return count;
  }
  
  private void copy() {
    for (int i = 0; i< size ;i++) {
      for (int j = 0; j < size; j++) {
        currentGen[i][j] = nextGen[i][j];
      }
    }
  }
  public void advanceGen() {
    for(int i = 0; i < noOfGenerations; i++) {
      NextGen();
      System.out.println(this);
    }
   // return nextGen;
  }
}

//TestGameOfLife.java
public class TestGameOfLife {
  public static void main(String args[]){
    GameOfLife gof = new GameOfLife();
    System.out.println(gof);
    gof.advanceGen();
    //System.out.println(gof);
  }
}

