package com.robot.util;

import com.robot.model.Survivor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.robot.util.Constant.SPILITTER_COMMA;

@Component
public class Helper {

    public List<String> getList(String s){
        List<String> res = new ArrayList<>();
        if(s != null && !s.trim().isEmpty()){
            res = Arrays.asList(s.split(SPILITTER_COMMA));
        }
        return res;
    }

    public Integer getPercentage(List<Survivor> total, String isInfected){
        List<Survivor> sS = total.stream().filter(l -> l.getIsInfected().trim().equals(isInfected)).collect(Collectors.toList());
        return sS.size() / total.size() * 100;
    }
}
