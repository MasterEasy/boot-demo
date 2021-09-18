package boot.controller.entity;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

class GraphQLTest {

    @Test
    public void graphQL(){
        System.out.println(new GraphQL());
        GraphQL graphQL = new GraphQL();
        graphQL.getData();
        System.out.println(JSON.parseObject(JSON.toJSONString(graphQL)));
    }

}