package com.plo.restplo.repository;

import com.plo.restplo.domain.Game;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional

public interface GameRepository extends ListCrudRepository<Game, Long> {
    List<Game> findAll();
    Optional<Game> findById(long id);
    @Override
    Game save(Game game);
    void deleteById(long id);
}
