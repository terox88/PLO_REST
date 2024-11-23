package com.plo.restplo.validation;

import com.plo.restplo.domain.Hero;
import com.plo.restplo.domain.Player;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PlayersValidator {

    public boolean isNotNull (List<Player> players) {
        return players != null;
    }
    public boolean isMoreThanOne(List<Player> players) {
        return players.size() > 1;
    }
    public boolean isHaveUniqeHeros(List<Player> players) {
        Set<Hero> heroSet = new HashSet<>();
        for (Player player : players) {
            heroSet.add(player.getHero());
        }
        return heroSet.size() == players.size();
    }


}
