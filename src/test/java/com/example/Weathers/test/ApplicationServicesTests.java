package com.example.Weathers.test;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import com.example.Weathers.beans.WeathersPersitence;
import com.example.Weathers.beans.impl.InMemoryPersistence;
import com.example.Weathers.services.WeathersServices;
import com.example.Weathers.services.WeathersServicesException;
import com.example.Weathers.services.WeathersServicesStub;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sergio
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServicesTests {

    @Autowired
    WeathersPersitence services;

    String queryLondon;

    @Before
    public void initial() throws WeathersServicesException {
        queryLondon = services.getWeather("london");
    }

    @Test
    public void contextLoads() throws WeathersServicesException {

    }

    /**
     * concurrentQueryToPersitence Pruebas concurrentes a la peristenia de la
     * aplicacion.
     *
     * @throws WeathersServicesException
     */
    @Test
    public void concurrentQueryToPersitence() throws WeathersServicesException {
        List<Thread> threads = new ArrayList<>();
        int numThreads = 10;
        for (int i = 0; i < numThreads; i++) {
            threads.add(new ThreadTest());
        }
        for (Thread t: threads) {
            t.start();
        }
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    }

    public class ThreadTest extends Thread {

        @Override
        public void run() {
            String queryB;
            try {
                queryB = services.getWeather("london");
                Assert.assertTrue(queryLondon.equals(queryB));
            } catch (WeathersServicesException ex) {
                Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
