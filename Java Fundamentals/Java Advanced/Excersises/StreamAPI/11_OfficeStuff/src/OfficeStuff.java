import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeStuff {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([a-zA-Z]+) - ([0-9]+) - ([a-zA-Z0-9]+)");
        TreeMap<String,LinkedHashMap<String,Integer>> hold = new TreeMap<String,LinkedHashMap<String,Integer>>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            Matcher match = pattern.matcher(input);
            while (match.find()){
                String company = match.group(1);
                int amount = Integer.parseInt(match.group(2));
                String product = match.group(3);

                if (!hold.containsKey(company)){
                    hold.put(company,new LinkedHashMap<>());
                }
                if (!hold.get(company).containsKey(product)){
                    hold.get(company).put(product, amount);
                }
                else {
                    int oldValue = hold.get(company).get(product);
                    hold.get(company).put(product,(amount+oldValue));
                }

            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : hold.entrySet()) {
            System.out.print(entry.getKey()+": ");
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, Integer> in : entry.getValue().entrySet()) {
                sb.append(in.getKey());
                sb.append("-");
                sb.append(in.getValue());
                sb.append(", ");

            }
            String output = sb.toString();
            output = output.substring(0,output.length()-2);
            System.out.println(output);
        }


    }
}
