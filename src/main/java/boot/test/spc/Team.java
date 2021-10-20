package boot.test.spc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    private String id;
    private String upper;
    private String center;
    private String lower;
    private String sum;
    private String avg;
    private String range;
}
