package Services;

import Models.Form;
import com.google.gson.Gson;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PDFService {
    private static PDFService pdfService;

    public static PDFService getInstance(){
        if (pdfService == null)
            pdfService = new PDFService();
        return pdfService;
    }

    //Creates the pdf of the form object
    public byte[] createPDF(Form form) throws IOException {
        Map<String,Form> parameters = new HashMap<>();
        String fileName = "Form.pdf";

        PDDocument pdf = new PDDocument();
        PDPage pdPage = new PDPage(PDRectangle.A4);
        pdf.addPage(pdPage);

        PDPageContentStream stream = new PDPageContentStream(pdf,pdPage);
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD,24);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-52);
        stream.showText("Home Express Realty INC");
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD,18);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-82);
        stream.showText("PDF Generado: "+form.getPdfName());
        stream.endText();

        // Informaciones Generales \\
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD, 20);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-132);
        stream.showText("Informaciones Generales");
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-162);
        stream.showText("Nombre del Cliente: "+form.getName());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-192);
        stream.showText("Apellido del Cliente: "+form.getSurname());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-222);
        stream.showText("Teléfono Móvil: "+form.getPhone());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-252);
        stream.showText("Whatsapp: "+form.getWhatsapp());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(280, pdPage.getMediaBox().getHeight()-162);
        stream.showText("Email: "+form.getEmail());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(280, pdPage.getMediaBox().getHeight()-192);
        stream.showText("Residente USA: "+ (form.getResidence()?"Si":"No"));
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(280, pdPage.getMediaBox().getHeight()-222);
        stream.showText("Visado USA: "+ (form.getVisa()?"Si":"No"));
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(280, pdPage.getMediaBox().getHeight()-252);
        stream.showText("Nacionalidad: "+form.getNationality());
        stream.endText();

        // Informacion sobre inversion \\
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD, 20);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-302);
        stream.showText("Información sobre Inversión");
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-332);
        stream.showText("Monto aprox. de inversión: US$"+ form.getMoneyQuant());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-362);
        stream.showText("Financiación: "+ form.getFinanceType());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-392);
        stream.showText("Tipo de Propiedad: "+ form.getPropertyType());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-422);
        stream.showText("Cantidad de Niveles: "+ form.getFloors());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-452);
        stream.showText("Año mínimo de construcción: "+ form.getMinConstructionYear());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(345, pdPage.getMediaBox().getHeight()-332);
        stream.showText("No. de Habitaciones: "+ form.getRooms());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(345, pdPage.getMediaBox().getHeight()-362);
        stream.showText("No. de Baños: "+ form.getRooms());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(345, pdPage.getMediaBox().getHeight()-392);
        stream.showText("No. de Garajes: "+ form.getGarages());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(345, pdPage.getMediaBox().getHeight()-422);
        stream.showText("Estado de la construcción: "+ form.getConstructionState());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(345, pdPage.getMediaBox().getHeight()-452);
        stream.showText("Comunidad: "+ form.getComunity());
        stream.endText();

        // Ubicación deseada para invertir en USA \\
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD, 20);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-502);
        stream.showText("Ubicación deseada para invertir en USA");
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-532);
        stream.showText("Estado: "+ form.getState());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 16);
        stream.newLineAtOffset(280, pdPage.getMediaBox().getHeight()-532);
        stream.showText("Ciudad: "+ form.getCity());
        stream.endText();

        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        stream.newLineAtOffset(15, pdPage.getMediaBox().getHeight()-652);
        stream.showText("PDF Generado por: Osmani Díaz Frias");
        stream.endText();

        stream.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        pdf.save(baos);
        //pdf.save(fileName);
        return baos.toByteArray();
    }

    //Send the pdf to the desired email
    public void sendPDF(byte[] pdf, Form form){
        String smtpHost = "smtp.host.com"; //smtp host
        int smtpPort = 587; //TLS port needs to be auth

        String sender = "email@host.com"; //valid email from Host
        String password = "password";
        String receiver = "receiver@host.com"; // valid email from any host
        String subject = "Se ha generado un nuevo Formulario"; // email subject
        String bodyTitle = "PDF generado del cliente "+ form.getName() +" "+ form.getSurname();

        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(sender,password);
                    }
                });
        try {
            // creating message Title bodyPart
            MimeBodyPart messageTitle = new MimeBodyPart();
            messageTitle.setText(bodyTitle);

            // creating pdf bodyPart
            DataSource dataSource = new ByteArrayDataSource(pdf,"application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName(form.getPdfName());

            // creating mime multipart
            MimeMultipart fullBody = new MimeMultipart();
            fullBody.addBodyPart(messageTitle);
            fullBody.addBodyPart(pdfBodyPart);

            //set the message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(subject);
            message.setContent(fullBody);

            Transport.send(message);
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }
}
