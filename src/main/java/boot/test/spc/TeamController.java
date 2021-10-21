package boot.test.spc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/spc")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/getSpc")
    public List<TeamVO> getSpc(){

        List<TeamVO> teamVOList = new ArrayList<>();
        teamRepository.findAll().forEach(team -> {
            TeamVO teamVO = new TeamVO();
            teamVO.setId(team.getId());
            teamVO.setUpper(Double.parseDouble(team.getUpper()));
            teamVO.setCenter(Double.parseDouble(team.getCenter()));
            teamVO.setLower(Double.parseDouble(team.getLower()));
            teamVO.setSum(Double.parseDouble(team.getSum()));
            teamVO.setAvg(Double.parseDouble(team.getAvg()));
            teamVO.setRange(Double.parseDouble(team.getRange()));
            teamVOList.add(teamVO);
        });
        return teamVOList;
    }

}


@Data
class TeamVO{

    private String id;
    private double upper;
    private double center;
    private double lower;
    private double sum;
    private double avg;
    private double range;
}
