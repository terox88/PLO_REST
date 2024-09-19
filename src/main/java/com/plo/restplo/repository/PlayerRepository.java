package com.plo.restplo.repository;

import com.plo.restplo.domain.Player;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PlayerRepository  extends ListCrudRepository<Player, Long> {
    Player save(Player player);
    void deleteById(long id);
}
