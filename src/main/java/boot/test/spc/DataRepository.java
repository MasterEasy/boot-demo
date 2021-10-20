package boot.test.spc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DataRepository extends JpaRepository<data, String> {

    List<data> findByTeamId(@RequestParam("teamId") String teamId);

}