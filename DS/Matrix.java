import java.util.ArrayList;
import java.util.ListIterator;


public class Matrix<E> {
  private int size;
  private int edge = 0;
  private int[][] adjacency_matrix;
 
  //ArrayList<Character> adjList = new ArrayList<Character>();
  //Vertex[] adjList;
 
  
  public Matrix() {
  }
  
  public Matrix(int size) {
    this.size = size;
    adjacency_matrix = new int[size][size];
    for (int i = 0; i < size; i ++) {
      for (int j = 0; j < size; j++) {
        adjacency_matrix[i][j] = 0;
      }
    }
  }
  
   public void insertEdge(String input3, String input4) {
   
    int row= (int)input3.charAt(1) - 97;
 
    int column= (int)input4.charAt(0) - 97;
  
    
    adjacency_matrix[row][column] = 1;
    
    
  }
  
  
  

 
 
