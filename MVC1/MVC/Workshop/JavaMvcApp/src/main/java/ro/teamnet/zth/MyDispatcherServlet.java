package ro.teamnet.zth;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eduard on 14.07.2016.
 */
public class MyDispatcherServlet extends HttpServlet {
    //necesar sa fie global pe clasa pentru a fi vazut peste tot
    //Acesta este registrul despre care am vorbit mai jos, in init():
    Map<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
        dispatchReply("POST", req, resp);

    }

    protected void dispatchReply(String s, HttpServletRequest req, HttpServletResponse resp) {
        /*va avea 3 parti:
             Transmitere spre procesare – dispatch()
        	Transmitere raspunsului obtinut in urma procesarii catre client – reply()
        	Tratarea posibilelor erori de procesare – sendExceptionError()*/
        Object r = null;
        try {
            r = dispatch(req, resp);//in urma ei se primeste un raspuns
        } catch (Exception ex) {
            sendExceptionError(ex, req, resp);// req si resp pentru a o trimite catre client
            //poate face modificari un baza de date pentru a semnala ca a fost o eroare, de exemplu
        }


        try {
            reply(r, req, resp);//da raspunsul mai departe
        } catch (IOException e) {
            sendExceptionError(e, req, resp);
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        //este necesar sa stiu pentru fiecare controller si pentru fiecare metoda
        //care este url-ul asociat
        try {
            //cautare clase din pachet
            Iterable<Class> controllers = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
                if (controller.isAnnotationPresent(MyController.class)) {
                    //la acest moment avem radacina("/employees" sau "/departments")
                    //iau adnotarea:
                    MyController myCtrlAnnotation = (MyController) controller.getAnnotation(MyController.class);
                    //salvam radacina, care este doar o parte a cheii din HashMap
                    String controllerUrlPath = myCtrlAnnotation.urlPath();
                    Method[] controllerMethods = controller.getMethods();
                    for (Method controllerMethod : controllerMethods) {
                        if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                            MyRequestMethod myRequestMethod = controllerMethod.getAnnotation(MyRequestMethod.class);
                            String methodUrlPath = myRequestMethod.urlPath();
                            //construiesc cheia pt HashMap
                            String urlPath = controllerUrlPath + methodUrlPath;
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(myRequestMethod.methodType());
                            methodAttributes.setMethodName(controllerMethod.getName());
                            //Adaug, in sfarsit, in HashMap :)) :
                            allowedMethods.put(urlPath, methodAttributes);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.init();
    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        /*String path = req.getPathInfo();
        if(path.startsWith("/employees")){
            EmployeeController employeeController = new EmployeeController();
            String result =  employeeController.getAllEmployees();
            return result;
        }else if(path.startsWith("/departments")){
            DepartmentController departmentController = new DepartmentController();
            String result = departmentController.getAllDepartments();
            return result;
        }*/
        String path = req.getPathInfo();
        MethodAttributes methodAttributes = allowedMethods.get(path);

        if(methodAttributes == null){
            //nu putem procesa url-ul
            return "Hello";
        }


        String controllerName = methodAttributes.getControllerClass();
        String methodName = methodAttributes.getMethodName();
        try {
            Class<?> controllerClass = Class.forName(controllerName);
            Object controllerInstance = controllerClass.newInstance();
            Method method = controllerClass.getMethod(methodAttributes.getMethodName());
            Object result = method.invoke(controllerInstance);//are ca parametru obiectul de care apartine metoda
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(controllerName.equals("DepartmentController")){
            DepartmentController departmentController = new DepartmentController();
        }


        //SAU!!! mai elegant, caut intr-un registru, care va fi definit in metoda init, la ridicarea aplicatiei(vezi init)

        return "Hello";
    }

    private void reply(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().printf(r.toString());//sau cu write(r.toString())
    }

    private void sendExceptionError(Exception ex, HttpServletRequest req, HttpServletResponse resp) {

    }

}
