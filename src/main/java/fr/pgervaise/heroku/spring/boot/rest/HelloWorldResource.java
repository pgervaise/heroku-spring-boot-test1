package fr.pgervaise.heroku.spring.boot.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pgervaise.heroku.spring.boot.service.StoreService;

/**
 * 
 * @author pgervaise
 *
 */
@RestController
@RequestMapping("/api/rest")
public class HelloWorldResource {

    @Inject
    private StoreService storeService;

    @RequestMapping("/hello")
    private MyObj sayHello() {
        return new MyObj();
    }

    public class MyObj {
        private String s1;
        private String s2;
        
        public MyObj() {
            s1 = "prop1";
            s2 = "prop2";
        }

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public String getS2() {
            return s2;
        }

        public void setS2(String s2) {
            this.s2 = s2;
        }
    }
}
