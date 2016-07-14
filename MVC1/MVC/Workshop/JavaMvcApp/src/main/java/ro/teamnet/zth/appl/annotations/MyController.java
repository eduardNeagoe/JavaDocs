package ro.teamnet.zth.appl.annotations;

import java.lang.annotation.*;

/**
 * Created by Eduard on 14.07.2016.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {//va spune despre clasa adnotata ca stie sa proceseze url-ri(acesta este rolul ei)
    String urlPath();//se scriu ca metode deoarece se vor apela
}
