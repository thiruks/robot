package com.robot.service;



import com.robot.model.Survivor;

import java.util.List;

public interface ISurvivorService {

    public String getInfectedSurvivorsPer();

    public String getNonInfectedSurvivorsPer();

    public List<Survivor> getInfectedSurvivors();

    public List<Survivor> getNonInfectedSurvivors();

}
