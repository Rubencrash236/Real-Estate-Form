package Controllers;

import Models.Form;
import Services.PDFService;
import com.google.gson.Gson;
import io.javalin.Javalin;

public class FormController {
    Javalin app;
    public FormController(Javalin app) {
        this.app = app;
    }

    public void applyRoutes(){
        app.routes(() -> {
           app.post("/submit", ctx -> {
               Form form = ctx.bodyAsClass(Form.class);
               //System.out.println(new Gson().toJson(form));
               byte[] pdf = PDFService.getInstance().createPDF(form);
               PDFService.getInstance().sendPDF(pdf,form);
           });
        });
    }
}
