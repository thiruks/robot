package com.robot.service;

import com.robot.model.Survivor;
import com.robot.util.Constant;
import com.robot.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.robot.util.Constant.S_PERCENTAGE;


@Service
public class SurvivorServiceImpl implements ISurvivorService {

    private static final Logger LOG = LoggerFactory.getLogger(SurvivorServiceImpl.class);

    @Autowired
    @Qualifier("jdbcRobot")
    private JdbcTemplate jdbcRobot;

    @Autowired
    private Helper helper;

    @Override
    public List<Survivor> getSurvivors() {
        //Jdbc call for listing all survivor.
        List<Survivor> lS = jdbcRobot.query(
                Constant.SQL_SURVIVOR_LIST, BeanPropertyRowMapper.newInstance(Survivor.class));

        LOG.info("Survivors results size: {}", lS.size());
        return (lS.isEmpty()) ? new ArrayList<>() : lS;
    }

    @Override
    public String getInfectedSurvivorsPer() {
        List<Survivor> sL = getSurvivors();
        if (!sL.isEmpty()) {
            int p = helper.getPercentage(sL, Constant.S_INFECTED);
            return p + " %";
        }
        return S_PERCENTAGE;
    }

    @Override
    public String getNonInfectedSurvivorsPer() {
        List<Survivor> sL = getSurvivors();
        if (!sL.isEmpty()) {
            int p = helper.getPercentage(sL, Constant.S_NON_INFECTED);
            return p + " %";
        }
        return S_PERCENTAGE;
    }

    @Override
    public List<Survivor> getInfectedSurvivors() {
        //Jdbc call for filtering survivor for infected.
        List<Survivor> iS = jdbcRobot.query(
                Constant.SQL_SURVIVOR_INFECTED_LIST, BeanPropertyRowMapper.newInstance(Survivor.class));

        LOG.info("Results size: {}", iS.size());
        return iS.isEmpty() ? new ArrayList<>() : iS;
    }

    @Override
    public List<Survivor> getNonInfectedSurvivors() {
        //Jdbc call for filtering survivor for non infected.
        List<Survivor> nS = jdbcRobot.query(
                Constant.SQL_SURVIVOR_NON_INFECTED_LIST, BeanPropertyRowMapper.newInstance(Survivor.class));

        LOG.info("Results size: {}", nS.size());
        return nS.isEmpty() ? new ArrayList<>() : nS;
    }
}
