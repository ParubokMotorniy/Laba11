package Mailing;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MailSender
{
    private static final String API_KEY = "some_api_key";
    private static final String API_SECRET = "some_api_secret";

    public static boolean SendMail(MailInfo info) {
        Client user = info.victim();
        String subject = MailTextGenerator.GetInstance().GetSubject(info.mailType());
        String body = MailTextGenerator.GetInstance().GetBody(info.mailType());

        if(body != null && subject != null)
        {
            try {
                URL url = new URL("https://api.mailjet.com/v3.1/send");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                String auth = API_KEY + ":" + API_SECRET;
                String base64Auth = java.util.Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
                connection.setRequestProperty("Authorization", "Basic " + base64Auth);

                String jsonInputString = String.format(
                        "{\"Messages\":[{\"From\":{\"Email\":\"your_email@example.com\",\"Name\":\"Your Name\"},\"To\":[{\"Email\":\"%s\",\"Name\":\"%s\"}],\"Subject\":\"%s\",\"TextPart\":\"%s\"}]}",
                        user.getEmail(), user.getName(), subject, body);

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int responseCode = connection.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                connection.disconnect();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
