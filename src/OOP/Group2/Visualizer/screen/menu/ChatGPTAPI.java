package OOP.Group2.Visualizer.screen.menu;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import OOP.Group2.Visualizer.graphicsElements.env;

public class ChatGPTAPI {

   public static String chatGPT(String prompt) {
       String url = env.URL;
       String apiKey = env.API_KEY;
       String model = env.MODEL;

       try {
           URL obj = new URL(url);
           HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
           connection.setRequestMethod("POST");
           connection.setRequestProperty("Authorization", "Bearer " + apiKey);
           connection.setRequestProperty("Content-Type", "application/json");

           // The request body
           String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
           connection.setDoOutput(true);
           OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
           writer.write(body);
           writer.flush();
           writer.close();

           // Response from ChatGPT
           BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           String line;

           StringBuffer response = new StringBuffer();

           while ((line = br.readLine()) != null) {
               response.append(line);
           }
           br.close();

           // calls the method to extract the message.
           return extractMessageFromJSONResponse(response.toString());

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

   public static String extractMessageFromJSONResponse(String response) {
       int start = response.indexOf("content")+ 11;

       int end = response.indexOf("\"", start);

       return response.substring(start, end);

   }

   public static void main(String[] args) {

       System.out.println(chatGPT("Hello, what is the complexity of quicksort? "));

   }
}