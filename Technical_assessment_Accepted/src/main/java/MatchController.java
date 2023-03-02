import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Optional<Match> match;
        match = matchRepository.findById(id);
        if (match.isPresent()) {
            return ResponseEntity.ok(match.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match savedMatch = matchRepository.save(match);
        return ResponseEntity.created(URI.create("/matches/" + savedMatch.getId())).body(savedMatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        Optional<Match> existingMatch = matchRepository.findById(id);
        if (existingMatch.isPresent()) {
            Match updatedMatch = existingMatch.get();
            updatedMatch.setDescription(match.getDescription());
            updatedMatch.setMatch_date(match.getMatch_date());
            updatedMatch.setMatch_time(match.getMatch_time());
            updatedMatch.setTeam_a(match.getTeam_a());
            updatedMatch.setTeam_b(match.getTeam_b());
            updatedMatch.setSport(match.getSport());
            matchRepository.save(updatedMatch);
            return ResponseEntity.ok(updatedMatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()) {
            matchRepository.delete(match.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}