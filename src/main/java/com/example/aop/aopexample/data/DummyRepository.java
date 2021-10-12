package com.example.aop.aopexample.data;

import com.example.aop.aopexample.aspects.TrackTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class DummyRepository {

    @TrackTime
    public String getInfo() {
        return "DUMMY";
    }
}
