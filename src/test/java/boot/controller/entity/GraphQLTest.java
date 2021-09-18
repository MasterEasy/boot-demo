package boot.controller.entity;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

class GraphQLTest {

    @Test
    public void graphQL(){
        System.out.println(new GraphQL());
        System.out.println(JSON.parseObject(JSON.toJSONString(new GraphQL())));
    }

}