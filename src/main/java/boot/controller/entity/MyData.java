package boot.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyData {

    private List<Country> Country = new ArrayList<>();



//    public List<Country> getData(){
//        Country china= new Country("中国",new CallingCodes("CHINA"));
//        Country usa = new Country("美国",new CallingCodes("USA"));
//        Country.add(china);
//        Country.add(usa);
//        return this.Country;
//    }

}




