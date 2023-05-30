package com.example.projectexercise.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@RestController
@RequestMapping(value = "/test")
public class Test {
    @GetMapping("/one")
    public String test(){
        return "hello word!";
    }

    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a.stream().flatMap(b->{
            return Stream.of(b.toString()+"a");
                        })
                        .collect(Collectors.toList())
        );
        System.out.println(a);
    }
    public static double EPSILON = 1e-6;
        public static double[] getIntersection(int[] start1, int[] end1, int[] start2, int[] end2) {
            double[] result = new double[2];
            int x1 = start1[0], y1 = start1[1], x2 = end1[0], y2 = end1[1];
            int x3 = start2[0], y3 = start2[1], x4 = end2[0], y4 = end2[1];
            int det = (x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1);
            if (Math.abs(det) < EPSILON) {
                // 两条线段平行或重合
                return null;
            } else {
                int lambda = ((y4 - y3) * (x4 - x1) + (x3 - x4) * (y4 - y1)) / det;
                int gamma = ((y1 - y2) * (x4 - x1) + (x2 - x1) * (y4 - y1)) / det;
                if (0 < lambda && lambda < 1 && 0 < gamma && gamma < 1) {
                    // 计算交点的坐标
                    result[0] = x1 + lambda * (x2 - x1);
                    result[1] = y1 + lambda * (y2 - y1);
                    return result;
                } else {
                    // 两条线段不相交
                    return null;
                }
            }
    }
}
