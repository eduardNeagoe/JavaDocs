package ro.teamnet.hello2;

import ro.teamnet.hello.HelloWorld;

/**
 * Created by Eduard on 05.07.2016.
 */
public class HelloWorldExtend {
    public HelloWorldExtend() {
    }
    public void extendSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        
        System.out.println("The new Hello World");
    }

}
