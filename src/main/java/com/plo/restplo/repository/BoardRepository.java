package com.plo.restplo.repository;

import com.plo.restplo.domain.Board;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BoardRepository extends ListCrudRepository<Board,Long> {
    List<Board> findAll();
    Optional<Board> findById(long id);
    @Override
    Board save(Board board);
}
