package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class JUnitTest {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("\n" + "IP:{}" + "\n")
                .append("参数:{}");

        log.info(stringBuilder.toString(), "47.208.97.207", "---");
    }

/*    public static void main(String args[]) {

        log.trace("trace level");
        log.debug("debug level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");
//        log.fatal("fatal level");
    }*/
}
