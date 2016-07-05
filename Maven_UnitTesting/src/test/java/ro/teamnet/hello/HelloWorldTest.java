package ro.teamnet.hello;

import org.junit.Test;

/**
 * Created by Eduard on 05.07.2016.
 */
public class HelloWorldTest {

    @Test
    public  void testSayHello(){

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }


    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From test: "+helloWorld.returnHelloKey());
        assert helloWorld.returnHelloKey().equals("HelloKey");
    }

}
