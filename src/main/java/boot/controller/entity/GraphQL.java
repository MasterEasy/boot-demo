package boot.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GraphQL {

    private MyData data = new MyData();


    public MyData getData(){

        List<Country> countryList = new ArrayList<>();

        Country china= new Country("中国",new CallingCodes("CHINA"));
        Country usa = new Country("美国",new CallingCodes("USA"));

        countryList.add(china);
        countryList.add(usa);

        data.setCountry(countryList);
        return this.data;
    }
}
