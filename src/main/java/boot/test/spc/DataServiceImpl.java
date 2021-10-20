package boot.test.spc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataRepository dataRepository;

    @Override
    public List<data> findByTeamId(String teamId){
        return dataRepository.findByTeamId(teamId);
    }
}
