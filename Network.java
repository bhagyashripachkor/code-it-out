import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Network {
  List<User> network;

  public Network() {
    network = new ArrayList<User>();
  }

  public User getUser(String userName) {
    for(User user : network)
      if(user.getUserName().equalsIgnoreCase(userName))
        return user;
    return null;
  }

  public boolean isUserExists(String userName) {
    for(User user : network) {
      if(user.getUserName().equalsIgnoreCase(userName))
        return true;
    }
    return false;
  }

  public void createNetwork(String fileName) {
    String data = readDataFromFile(fileName);
    StringTokenizer tokens = new StringTokenizer(data, ".");
    String line;

    while(tokens.hasMoreTokens()) {
      String[] array;
      line = tokens.nextToken();
      if(line.contains(" is connected to ")) {
        array = line.split(" is connected to ");
        if(!isUserExists(array[0])) {
          User user = new User();
          user.setUserName(array[0]);
          StringTokenizer friends = new StringTokenizer(array[1], ", ");
          while(friends.hasMoreTokens()) 
            user.addFriend(friends.nextToken());
          network.add(user);
        }
      } else {
        array = line.split(" likes to play ");
        User user = getUser(array[0]);
        if(user != null) {
          StringTokenizer games = new StringTokenizer(array[1], ",");
          while(games.hasMoreTokens()) 
            user.addGame(games.nextToken().trim());
        }
      }
    }
    printNetwork();
  }

  public void printNetwork() {
    for(User user : network) {
      System.out.println("===================");
      System.out.println(user.getUserName());
      System.out.println(user.getFriends());
      System.out.println(user.getGames());
    }
  }

  public String readDataFromFile(String fileName) {
    String line = null;
    StringBuffer data = new StringBuffer();
    try {
      BufferedReader br = new BufferedReader(
              new FileReader(fileName));
      
      while((line = br.readLine())!=null) {
        data.append(line);
      }
      br.close();
    } catch(Exception ex) {
      ex.printStackTrace();
    }

    return data.toString();
  }

  public boolean removeFriend(String userName, String removeFriend) {
    if(isUserExists(userName)) {
      User user = getUser(userName);
      return user.getFriends().remove(removeFriend);
    }
    return false;
  }

  public List<String> getConnections(String userName) {
    for(User user : network)
      if(user.getUserName().equalsIgnoreCase(userName))
        return user.getFriends();
    return null;
  }

  public List<String> getGames(String userName) {
    for(User user : network)
      if(user.getUserName().equalsIgnoreCase(userName))
        return user.getGames();
    return null;
  }

  public void addConnection(String userName, String friendName) {
    for(User user : network)
      if(user.getUserName().equalsIgnoreCase(userName))
        user.addFriend(friendName);
  }

  public List<String> getCommonConnections(String userA, String userB) {
    List<String> commonFriends;

    List<String> friendsA = getConnections(userA);
    List<String> friendsB = getConnections(userB);

    if(friendsA == null || friendsB == null) {
      return null;
    } else {
      commonFriends = new ArrayList<String>();
      for(String friendA : friendsA) {
        if(friendsB.contains(friendA))
          commonFriends.add(friendA);
      }
    }
    return commonFriends;
  }

  public void addUser(String userName, List<String> games) {
    if(!isUserExists(userName)) {
      User user = new User();
      user.setUserName(userName);
      for(String game : games)
        user.addGame(game);
      network.add(user);
    } else {
      User user = getUser(userName);
      for(String game : games)
        user.addGame(game);
    }
  }
  
//  public void getPath(String userName1, String userName2) {
//    List<String> path = new ArrayList<String>();;
//    if(!isUserExists(userName1) && !isUserExists(userName2)) {
//      path.add(userName1);
//      System.out.println(path);
//      
//      
//    }
//  }

  public static void main(String[] argsp) {
    Network network = new Network();
    network.createNetwork("C:/Users/Dell/Workspaces/Eclipse IDE for Java EE Developers 422/Facebook/src/Socialnetwork.txt");
    System.out.println("*********************************************");
    List<String> friends = network.getConnections("David");
    if(friends!=null)
      System.out.println(friends);
    else
      System.out.println("User Doesnot Exists.....");

    network.addConnection("Ollie", "Debra");
    System.out.println(network.getConnections("Ollie"));
    
    System.out.println("===========================================");
    List<String> commonFriends = 
            network.getCommonConnections("Ollie", "Ron");
    if(commonFriends!=null)
      if(!commonFriends.isEmpty())
        System.out.println(commonFriends);
      else
        System.out.println("No Common Friends");
    else
      System.out.println("No Common Friends");

    List<String> games = new ArrayList<String>();
    games.add("Candy Crush");
    games.add("Candy Crush - V3");
    games.add("Candy Crush - V2");
    network.addUser("David", games);
    List<String> murthyGames = network.getGames("David");
    if(murthyGames!=null)
      System.out.println(murthyGames);
    else
      System.out.println("User Doesnot Exists.....");   

    if(network.removeFriend("Ron", "David"))
      System.out.println("Friend Removed Successfully");
    else
      System.out.println("Not a friend of user");
    System.out.println("-------------------------");
    //network.getPath("John", "Ollie");
  }
}
