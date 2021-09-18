package boot.controller;

import boot.controller.entity.GraphQL;
import boot.controller.entity.MyData;
import boot.controller.entity.NewDate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@CrossOrigin
@RestController
@RequestMapping("/grafana")
public class ApiController {

    @GetMapping("/getDate")
    public NewDate getDate(){
        return new NewDate(new Date());
        //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @PostMapping("/getGraphQL")
    public GraphQL getGraphQL(){
        System.out.println(new MyData());
        GraphQL graphQL = new GraphQL();
        graphQL.getData();
        return new GraphQL();
    }

}

