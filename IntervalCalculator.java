import java.io.*;

class Interval {
    private double start, end;
    private int total = 0, inside = 0;

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public void test(double number) {
        total++;
        if (number >= start && number <= end) inside++;
    }

    public double percentage() {
        return total == 0 ? 0 : (double) inside / total * 100;
    }

    public String toString() {
        return "[" + start + ", " + end + "]: " + percentage() + "%";
    }
}

public class IntervalCalculator {
    public static void main(String[] args) {

        try (BufferedReader intervalReader = new BufferedReader(new FileReader("intervale.dat"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("statistica.dat"))) {

            String line;
            while ((line = intervalReader.readLine()) != null) {
                String[] parts = line.split(",");
                double start = Double.parseDouble(parts[0].substring(1));
                double end = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
                Interval interval = new Interval(start, end);

                try (BufferedReader numberReader = new BufferedReader(new FileReader("numere.dat"))) {
                    while ((line = numberReader.readLine()) != null) {
                        String[] numbersArray = line.trim().split("\\s+");
                        for (String num : numbersArray) {
                            if (!num.isEmpty()) {
                                double number = Double.parseDouble(num);
                                interval.test(number);
                            }
                        }
                    }
                }
                writer.write(interval.toString());
                writer.newLine();
            }
        } catch (IOException mesajException) {
            System.out.println("Eroare la citirea sau scrierea fișierelor: " + mesajException.getMessage());
        }
    }
}
