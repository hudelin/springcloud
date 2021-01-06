package com.hu.pojo.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Data
@Builder
public class StudentScoreVO {

    private String stuName;

    private String subject;

    private Integer score;

//    public static void main(String[] args) throws JsonProcessingException {
//        List<StudentScoreVO> studentScoreVOList = new ArrayList<>();
//        studentScoreVOList.add(StudentScoreVO.builder().stuName("张三").subject("语文").score(70).build());
//        studentScoreVOList.add(StudentScoreVO.builder().stuName("张三").subject("数学").score(80).build());
//        studentScoreVOList.add(StudentScoreVO.builder().stuName("张三").subject("英语").score(90).build());
//        studentScoreVOList.add(StudentScoreVO.builder().stuName("李四").subject("语文").score(60).build());
//        studentScoreVOList.add(StudentScoreVO.builder().stuName("李四").subject("数学").score(70).build());
//        studentScoreVOList.add(StudentScoreVO.builder().stuName("李四").subject("英语").score(80).build());
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Integer> studentScoreMap = new HashMap<>();
//
//        // map得每个key的和
//        studentScoreVOList.forEach(s -> studentScoreMap.merge(s.getStuName(), s.getScore(), Integer::sum));
//        // list转map，保留第一个
//        Map<String, StudentScoreVO> map1 = studentScoreVOList.stream().collect(Collectors.toMap(StudentScoreVO::getStuName, a -> a, (k1, k2) -> k1));
//        Map<String, StudentScoreVO> map2 = studentScoreVOList.stream().collect(Collectors.toMap(StudentScoreVO::getStuName, a -> a, (k1, k2) -> k2));
////        Map<String, StudentScoreVO> map3 = studentScoreVOList.stream().collect(Collectors.toMap(StudentScoreVO::getStuName, Function.identity()));
//        // 字段用，拼接成字符串
//        String string = studentScoreVOList.stream().map(StudentScoreVO::getStuName).collect(Collectors.joining(","));
//        // list分组成map
//        Map<String, List<StudentScoreVO>> map = studentScoreVOList.stream().collect(Collectors.groupingBy(StudentScoreVO::getStuName));
//        // 拿某个字段的list
//        List<String> collect = studentScoreVOList.stream().map(StudentScoreVO::getStuName).collect(Collectors.toList());
//        // 收集符合条件的
//        List<StudentScoreVO> collect1 = studentScoreVOList.stream().filter(item -> ("张三".equals(item.getStuName()))).collect(Collectors.toList());
//        // 排序
//        List<StudentScoreVO> collect2 = studentScoreVOList.stream().sorted(Comparator.comparing(StudentScoreVO::getScore)).collect(Collectors.toList());
//        studentScoreVOList.stream().sorted(Comparator.comparing(StudentScoreVO::getScore).reversed()).collect(Collectors.toList());
//        // 根据所有字段全一样去重
//        List<StudentScoreVO> collect3 = studentScoreVOList.stream().distinct().collect(Collectors.toList());
//
//        String text=" ";
//        String out = Arrays.stream(text.split(" ")).sorted(Comparator.comparingInt(String::length)).collect(Collectors.joining(" ")).toLowerCase();
//
//
//    }

}
