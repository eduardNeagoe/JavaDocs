package ro.teamnet.zth.appl.annotations;

import java.lang.annotation.*;

/**
 * Created by Eduard on 15.07.2016.
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    String name();
}
