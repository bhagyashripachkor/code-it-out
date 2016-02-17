import java.util.ArrayList;
import java.util.List;

public class User {
  String userName;
  List<String> friends;
  List<String> games;

  public User() {
    friends = new ArrayList<String>();
    games = new ArrayList<String>();
  }

  public void addFriend(String friend) {
    if(!friends.contains(friend))
      friends.add(friend);
  }

  public void addGame(String game) {
    if(!games.contains(game))
      games.add(game);
  }

  public List<String> getFriends() {
    return this.friends;
  }

  public List<String> getGames() {
    return this.games;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return this.userName;
  }
}
