package com.hu.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

/**
 * @author Lenovo
 */
@Data
@TableName(value = "demon_order")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DemonOrder extends BasePO {

    private String orderId;

    private String orderStatus;

    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>();
        Random random=new Random();
        int p= (int) (100000/100*1.4);
        int count=100000;
        for (int i = 0; i < count; i++) {
            for (int j=0;;j++){
                int r = random.nextInt(100000);
                if(r<p){
                    list.add(j);
                    break;
                }
            }
        }
        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        System.out.println(average);
    }

}
