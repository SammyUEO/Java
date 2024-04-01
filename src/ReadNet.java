import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadNet {
	
    private static StringBuilder pageContent = new StringBuilder();

    public static void main(String[] args) {
        try {
            String countryUrl = "https://operationworld.org/locations/italy/";

            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(countryUrl).openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                pageContent.append(line).append("\n");
            }

            String country = extractCountry();
            String population = extractInfo("<th scope=\"row\">Population:</th>", "</td>");
            String evangelical = extractInfo("<th scope=\"row\">% Evangelical:</th>", "</td>");

            System.out.println("Country: " + country);
            System.out.println(population);
            System.out.println(evangelical);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractCountry() {
        String startTag = "Pray for:";
        String endTag = "</h1>";
        int startIndex = pageContent.indexOf(startTag);
        if (startIndex != -1) {
            startIndex = pageContent.indexOf(":", startIndex) + 1;
            int endIndex = pageContent.indexOf(endTag, startIndex);
            return pageContent.substring(startIndex, endIndex).trim();
        }
        return "Nu s-a găsit informație";
    }

    private static String extractInfo(String startTag, String endTag) {
        int startIndex = pageContent.indexOf(startTag);
        if (startIndex != -1) {
            startIndex = pageContent.indexOf(">", startIndex) + 1;
            int endIndex = pageContent.indexOf(endTag, startIndex);
            String content = pageContent.substring(startIndex, endIndex).trim();

            //chestii noi 

            // Eliminarea tag-urilor HTML
            content = content.replaceAll("<[^>]*>", "");

            // Înlocuirea tuturor spațiilor duble cu un singur spațiu
            content = content.replaceAll("\\s+", " ");
            return content;
        }
        return "Nu s-a găsit informație";
    }
}
