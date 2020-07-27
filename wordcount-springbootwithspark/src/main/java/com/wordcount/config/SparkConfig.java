package com.wordcount.config;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class SparkConfig {

    @Value("${spark.app.name}")
    private String appName;
    @Value("${spark.master}")
    private String masterUri;
    @Value("${boring.words}")
    private String boringWords;

    @Bean
    public SparkConf conf() {
        System.setProperty("hadoop.home.dir", "c:/winutils");
        Logger.getLogger("org.apache").setLevel(Level.WARN);
        return new SparkConf().setAppName(appName).setMaster(masterUri);
    }

    @Bean
    public JavaSparkContext sc() {
        return new JavaSparkContext(conf());
    }

    @Bean
    public List<String> boringWords() {
        return Stream.of(boringWords.split(",")).collect(Collectors.toList());
    }

}
