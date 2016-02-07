
public class Quest {
  /**
   * @param args
   */
  public int qserialNumber;
  public String qtext;
  public String qchoice;
  public int qcorrectAns;
  public int qpoints;
  public Quest(int serialNumber, String text, String choice, int correctAns, int points) {
    qserialNumber = serialNumber;
    qtext = text;
    qchoice = choice;
    qcorrectAns = correctAns;
    qpoints = points;
  }
//  public int getSerialNumber(int serialNumber) {
//    return this.serialNumber;
//  }
//  public String getText(String text) {
//    return this.text;
//  }
//  public String getChoice(String choice) {
//    return this.choice[4];
//  }
//  public int getCorrectAnswer(int correctAnswer) {
//    return this.correctAns;
//  }
//  public int getPoints(int points) {
//    return this.points;
//  }
}
