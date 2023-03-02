import java.util.Optional;

public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {
    Optional<Match> findById(Long id);

    Match save(Match match);

    void delete(Match match);
}
