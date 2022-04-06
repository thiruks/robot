package com.robot.service;

import com.robot.model.Survivor;
import com.robot.util.Constant;
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

    @Override
    public String getInfectedSurvivorsPer() {
        int per = jdbcRobot.queryForObject(Constant.SQL_SURVIVOR_INFECTED_PER, Integer.class);
        LOG.info("Infected percentage: {}", per);
        return per + S_PERCENTAGE;
    }

    @Override
    public String getNonInfectedSurvivorsPer() {
        int per = jdbcRobot.queryForObject(Constant.SQL_SURVIVOR_NON_INFECTED_PER, Integer.class);
        LOG.info("Non Infected percentage: {}", per);
        return per + S_PERCENTAGE;
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
