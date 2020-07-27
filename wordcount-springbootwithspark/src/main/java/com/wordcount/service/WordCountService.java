package com.wordcount.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WordCountService implements Serializable {

    private static String FILE_PATH = "wordcount-springbootwithspark/src/main/java/com/wordcount/data/";

    @Autowired
    JavaSparkContext sc;

    @Autowired
    List<String> boringWords;

    public Map<String, Long> getCount(Integer numberOfWords, String fileName) {

        JavaRDD<String> words = sc.textFile(FILE_PATH + fileName + ".txt");

        Broadcast<List<String>> boringWordsBroadcast = sc.broadcast(boringWords);

        List<Tuple2<Long, String>> countedTopWords = words
                .map(sentence -> sentence.replaceAll("[^a-zA-Z\\s]", "").toLowerCase())
                .flatMap(sentence -> Arrays.asList(sentence.split(" ")).iterator())
                .filter(sentence -> sentence.trim().length() > 0)
                .filter(word -> !boringWordsBroadcast.value().contains(word))
                .groupBy(word -> word)
                .mapValues(v -> v.spliterator().estimateSize())
                .map(x -> x.swap())
                .sortBy(t -> t._1, false, 1).take(numberOfWords);

//        stringLongJavaPairRDD.take(numberOfWords).forEach(System.out::println);
        return countedTopWords.stream().collect(Collectors.toMap(t -> t._2(), t -> t._1()));
    }

}
