package boot.test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class OrderTest{
    public static void main(String[] args) {
        final String merchId = "12334";
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0,20).parallel().forEach(i->{
            orderNos.add(getYYMMDDHHNumber(merchId));
        });

        new Thread(new OrderNum()).start();
        new Thread(new OrderNum()).start();

//        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());
//
//        System.out.println("生成订单数："+orderNos.size());
//        System.out.println("过滤重复后订单数："+filterOrderNos.size());
//        System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));
    }

    /**
     * OD单号生成
     * 订单号生成规则：OD + yyMMddHHmmssSSS + 5位数(商户ID3位+随机数2位) 22位
     */
    public static String getYYMMDDHHNumber(String merchId){
        StringBuffer orderNo = new StringBuffer(new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
        //判断订单号不为空
        if(merchId != null){
            if(merchId.length()>3){
                orderNo.append(merchId.substring(0,3));
            }else {
                orderNo.append(merchId);
            }
        }
        int orderLength = orderNo.toString().length();
        String randomNum = getRandomByLength(20-orderLength);
        orderNo.append(randomNum);
        return orderNo.toString();
    }


    /** 生成指定位数的随机数 **/
    public static String getRandomByLength(int size){
        if(size>8 || size<1){
            return "";
        }
        Random ne = new Random();
        StringBuffer endNumStr = new StringBuffer("1");
        StringBuffer staNumStr = new StringBuffer("9");
        for(int i=1;i<size;i++){
            endNumStr.append("0");
            staNumStr.append("0");
        }
        int randomNum = ne.nextInt(Integer.valueOf(staNumStr.toString()))+Integer.valueOf(endNumStr.toString());
        return String.valueOf(randomNum);
    }

}

class OrderNum implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Map<String,String> map = new ConcurrentHashMap<>();
            map.put(String.valueOf(i),OrderTest.getYYMMDDHHNumber("12345"));
            Set<Map.Entry<String, String>> entries = map.entrySet();
            entries.forEach(entrie -> System.out.println(entrie.getValue()));


        }
    }
}