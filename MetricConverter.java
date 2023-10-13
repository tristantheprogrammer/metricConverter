import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to metric converter!\n");
        System.out.println("Please input your query. For example, 1 km = mile.");
        System.out.println("Enter 'exit' or '-1' to exit the program.\n");

        while (true) {
            System.out.print("Enter your conversion (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equals("-1")) {
                System.out.println("Exiting the program. See ya later!");
                break;
            }

            String[] parts = input.split("=");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Please use 'value unit = targetUnit'.");
                continue;
            }

            String sourceUnit = parts[0].trim();
            String targetUnit = parts[1].trim();

            double value;
            try {
                value = Double.parseDouble(sourceUnit.split(" ")[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please use a numeric value.");
                continue;
            }

            String source = sourceUnit.split(" ")[1];
            String target = targetUnit.split(" ")[0];

            double result = convert(value, source, target);
            if (result != -1) {
                System.out.println(value + " " + source + " = " + result + " " + target);
            }
        }
        scanner.close();
    }

    private static double convert(double value, String source, String target) {
        // Math to convert all units
        if (source.equalsIgnoreCase("km") && target.equalsIgnoreCase("mile")) {
            return value * 0.621371;
        } else if (source.equalsIgnoreCase("kg") && target.equalsIgnoreCase("lb")) {
            return value * 2.20462;
        } else if (source.equalsIgnoreCase("g") && target.equalsIgnoreCase("oz")) {
            return value * 0.035274;
        } else if (source.equalsIgnoreCase("mm") && target.equalsIgnoreCase("inch")) {
            return value * 0.0393701;
        } else {
            System.out.println("Conversion from " + source + " to " + target + " is not supported.");
            return -1;
        }
    }
}
