package ro.teamnet.zth.appl.annotations;

import java.lang.annotation.*;

/**
 * Created by Eduard on 14.07.2016.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMethod {
    String methodType() default "GET";
    String urlPath();
}
