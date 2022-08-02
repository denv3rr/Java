import java.util.ArrayList;

class Playlist {
  public static void main(String[] args) {
    ArrayList<String> musicPlaylist = new ArrayList<String>();

    musicPlaylist.add("Aerials - SOAD");
    musicPlaylist.add("Heart Shaped Box - Nirvana");
    musicPlaylist.add("Badfish - Sublime");
    musicPlaylist.add("Zero - Smashing Pumpkins");
    musicPlaylist.add("Sunday - Sonic Youth");

    System.out.println("\n\n\nPlaylist size: " + musicPlaylist.size() + " songs\n"
        + "------------------------------------------");
    for (int i = 0; i < musicPlaylist.size(); i++) {
      String currentSong = musicPlaylist.get(i);

      System.out.println(currentSong);
    }

    System.out.println("\n\n\n------------------------------------------");

  }
}