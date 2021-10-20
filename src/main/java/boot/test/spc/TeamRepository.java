package boot.test.spc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, String> {

}