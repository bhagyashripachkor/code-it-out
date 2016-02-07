import java.util.Scanner;


public class Question {
  /**
   * @param args
   */
 public int qserialNumber;
 int marks = 0;
  public String qtext;
  public String qchoice;
  public int qcorrectAns;
  public int qpoints;
  public Question(int serialNumber, String text, String choice, int correctAns, int points) {
    qserialNumber = serialNumber;
    qtext = text;
    qchoice = choice;
    qcorrectAns = correctAns;
    qpoints = points;
  }
  int size = 2;
  void addQuestion(Question q) {
    this.qserialNumber= q.qserialNumber;
    this.qtext= q.qtext;
      this.qchoice = q.qchoice;
      this.qcorrectAns= q.qcorrectAns;
      this.qpoints = q.qpoints;
  }
  public void startQuiz() {
    //int y = 0;
    int ans = 0;
    int marks = 0;
    int option = 1;
    Scanner input = new Scanner(System.in);
    Scanner input1 = new Scanner (System.in);
    for (int i = 0; i < size ; i++) {
      System.out.println(qserialNumber);
      System.out.println(qtext);
      System.out.println(qchoice);
      System.out.println("enter your choice");
      ans = input.nextInt();
      if (ans == qcorrectAns) {
        System.out.println("Correct answer");
        marks = marks + qpoints;
      }
      else {
        System.out.println("Wrong answer");
      }
    }
 }
  void showReport() {
    System.out.println("You scored " + marks + "marks");
    
  }
  void printQuestion() {
    for (int i = 0 ;i < size ; i++) {
      System.out.println("---------");
      System.out.println(qserialNumber);
      System.out.println(qtext);
      System.out.println(qchoice);
      System.out.println(qcorrectAns);
      System.out.println(qpoints);
    }
  }
}
