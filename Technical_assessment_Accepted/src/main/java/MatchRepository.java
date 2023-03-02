import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findById(Long id);

    Match save(Match match);

    void delete(Match match);
}