import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadNet {
    private String writeFilePath;
    private List<CountryInfo> countriesInfo = new ArrayList<>();

    public ReadNet(String writeFilePath) {
        this.writeFilePath = writeFilePath;
    }

    public static void main(String[] args) {
        ReadNet readNet = new ReadNet("informatii_tari.csv");
        readNet.run();
    }

    public void run() {
        process();
        write();
    }

    private void process() {
        try {
            URL address = new URL("https://operationworld.org/locations/europe/");
            try (Scanner scan = new Scanner(address.openStream())) {
                String pageContent = "";
                while (scan.hasNextLine()) {
                    pageContent += scan.nextLine() + "\n";
                }

                String country = extractInfo(pageContent, "Pray for:", "</h1>");
                String population = extractInfo(pageContent, "<th scope=\"row\">Population:</th>", "</td>");
                String evangelical = extractInfo(pageContent, "<th scope=\"row\">% Evangelical:</th>", "</td>");

                countriesInfo.add(new CountryInfo(country, population, evangelical));
            }
        } catch (IOException e) {
            System.out.println("Link invalid");
            e.printStackTrace();
        }
    }

    private static String extractInfo(String pageContent, String startTag, String endTag) {
        int startIndex = pageContent.indexOf(startTag);
        if (startIndex != -1) {
            startIndex = pageContent.indexOf(":", startIndex) + 1;
            int endIndex = pageContent.indexOf(endTag, startIndex);
            String content = pageContent.substring(startIndex, endIndex).trim();

            // Eliminarea tag-urilor HTML și alte modificări dorite
            content = content.replaceAll("<[^>]*>", "");
            content = content.replaceAll("\\s+", " ");
            return content;
        }
        return "Nu s-a găsit informație";
    }

    private void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilePath))) {
            writer.write("Country,Population,Evangelical\n");
            for (CountryInfo countryInfo : countriesInfo) {
                writer.write(countryInfo.getName() + "," + countryInfo.getPopulation() + "," + countryInfo.getEvangelicalPercent() + "\n");
            }
            System.out.println("Informatii scrise cu succes in: " + writeFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CountryInfo {
    private String name;
    private String population;
    private String evangelicalProcent;

    public CountryInfo(String name, String population, String evangelicalProcent) {
        this.name = name;
        this.population = population;
        this.evangelicalProcent = evangelicalProcent;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getEvangelicalPercent() {
        return evangelicalProcent;
    }
}
