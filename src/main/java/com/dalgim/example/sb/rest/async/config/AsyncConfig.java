package com.dalgim.example.sb.rest.async.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by Mateusz Dalgiewicz on 06.06.2017.
 */
@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

}
