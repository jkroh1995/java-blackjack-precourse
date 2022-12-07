package domain.user;

import java.util.ArrayList;
import java.util.List;

public class Players {

    List<Player> players;

    public Players(List<Player>players){
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }

    public List<String> getNames() {
        List<String>names  = new ArrayList<>();
        for (Player player : players) {
            names.add(player.getName());
        }
        return names;
    }
}
