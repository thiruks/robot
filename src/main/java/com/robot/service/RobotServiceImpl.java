package com.robot.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class RobotServiceImpl implements IRobotService {

    private static final Logger LOG = LoggerFactory.getLogger(RobotServiceImpl.class);

    @Override
    public String getRobots(String url, String key) throws IOException {

        String sortedRobots="";
        LOG.info("Get robots from link: {}", url);
        //Call for listing all robot.
        if (!url.trim().isEmpty()){
            HttpGet req = new HttpGet(url);
            LOG.info("Calling request: {}", req.getRequestLine());
            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(req)) {

                // Get HttpResponse Status
                if(response != null){
                    LOG.info("HttpResponse Status: {}", response.getStatusLine());

                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        // return it as a String
                        String result = EntityUtils.toString(entity);
                        LOG.info("Response result: {}", result);
                        return result; //Sorting by key is to be done.
                    }
                }
            }
        }

        return sortedRobots;
    }
}
