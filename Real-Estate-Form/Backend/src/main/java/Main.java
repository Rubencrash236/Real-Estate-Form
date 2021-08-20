import Controllers.FormController;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;

public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.registerPlugin(new RouteOverviewPlugin("/routes"));
            javalinConfig.enableCorsForAllOrigins();
        });
        new FormController(app).applyRoutes();
        app.start(7000);
    }
}
