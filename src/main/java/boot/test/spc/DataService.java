package boot.test.spc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DataService {


    List<data> findByTeamId(String teamId);
}
