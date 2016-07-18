package ro.teamnet.zth.appl.annotations;

import java.lang.annotation.*;

/**
 * Created by Eduard on 18.07.2016.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface MyRequestObject {
// String name();
}
