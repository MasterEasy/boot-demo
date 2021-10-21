package boot.controller.entity;

import boot.test.spc.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootTest
class MyDataTest {

    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private TeamRepository teamService;

    @Autowired
    private DataService dataService;

    @Test
    //@Transactional  https://blog.csdn.net/UtopiaOfArtoria/article/details/78087494
    public void test1() {
        String s = "0.952 0.937 0.906 0.88 0.901 0.931 0.913 0.865 0.908 0.906 0.896 0.899 0.936 0.882 0.919 0.907 0.893 0.914 0.907 0.889 0.887 0.95 0.916 0.884 0.903 0.913 0.878 0.898 0.95 0.966 0.931 0.886 0.931 0.935 0.912 0.877 0.93 0.925 0.891 0.936 0.929 0.9 0.926 0.886 0.93 0.921 0.882 0.91 0.879 0.94 0.894 0.907 0.868 0.884 0.899 0.842 0.925 0.9 0.863 0.887";
        List<String> list = Arrays.asList(s.split(" "));


        for (int i = 1; i <= list.size(); i++) {
            data d = new data();
            d.setId(i);
            d.setData(list.get(i - 1));

            int j = i;

            if (i > 12) {
                j = i - 12;
            }
            if (i > 24) {
                j = i - 24;
            }
            if (i > 36) {
                j = i - 36;
            }
            if (i > 48) {
                j = i - 48;
            }
            d.setTeamId(String.valueOf(j));
            dataRepository.save(d);

        }

        System.out.println(dataRepository.findAll());

    }

    @Test
    public void test2() {
        for (int i = 1; i <= 12; i++) {

            List<data> byTeamId = dataService.findByTeamId(String.valueOf(i));
            double sum = byTeamId.stream().map(data -> Double.valueOf(data.getData())).mapToDouble(Double::doubleValue).sum();
            OptionalDouble avg = byTeamId.stream().map(data -> Double.valueOf(data.getData())).mapToDouble(Double::doubleValue).average();
            //int sum = byTeamId.stream().map(data -> Integer.parseInt(data.getData())).mapToInt(Integer::intValue).sum();
            //AtomicReference<Integer> k = new AtomicReference<>(0);
            //k.updateAndGet(v -> v + Integer.parseInt(data.getData()));

            double max = 0;
            double min = 0;
            for (data data : byTeamId) {
                double value = Double.parseDouble(data.getData());
                if (max == 0) {
                    max = value;
                } else if (max > value) {
                    min = value;
                } else {
                    max = value;
                }
            }

            System.out.println(i + "总值===" + sum);
            System.out.println(i + "平均值===" + avg);
            System.out.println(i + "极差===" + (max - min));

            for (int k = 0; k < 12; k++) {
                Team team = new Team();
                team.setId(Integer.toString(k+1));
                team.setSum(Double.toString(sum));
                team.setAvg(String.valueOf(avg));
                team.setRange(Double.toString((max-min)));
                //save
                //teamService.save(team);
            }

        }

    }

}