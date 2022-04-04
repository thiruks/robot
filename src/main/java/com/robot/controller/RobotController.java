package com.robot.controller;


import com.robot.config.Properties;
import com.robot.model.Survivor;
import com.robot.service.IRobotService;
import com.robot.service.ISurvivorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/robots")
public class RobotController {

    private static final Logger LOG = LoggerFactory.getLogger(RobotController.class);

    @Autowired
    private Properties prop;

    @Autowired
    private ISurvivorService survivorService;

    @Autowired
    private IRobotService robotService;

    @GetMapping(value = "/survivors/infectedPer")
    @ResponseStatus(HttpStatus.OK)
    public String getPerInfectedSurvivors() {
        LOG.info("Requested to get percentage of infected survivors.");
        return survivorService.getInfectedSurvivorsPer();
    }

    @GetMapping(value = "/survivors/nonInfectedPer")
    @ResponseStatus(HttpStatus.OK)
    public String getPerNonInfectedSurvivors() {
        LOG.info("Requested to get percentage of non infected survivors.");
        return survivorService.getNonInfectedSurvivorsPer();
    }

    @GetMapping(value = "/survivors/infected")
    @ResponseStatus(HttpStatus.OK)
    public List<Survivor> getInfectedSurvivors() {
        LOG.info("Requested to get all infected survivors.");
        return survivorService.getInfectedSurvivors();
    }

    @GetMapping(value = "/survivors/nonInfected")
    @ResponseStatus(HttpStatus.OK)
    public List<Survivor> getNonInfectedSurvivors() {
        LOG.info("Requested to get all non infected survivors.");
        return survivorService.getNonInfectedSurvivors();
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public String getRobots() throws IOException{
        LOG.info("Requested to get all robots.");
        return robotService.getRobots(prop.getrUrl(), prop.getSortKey());
    }
}