import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!line.equals("stop")) {

          String resourceName = line;
          line = scanner.nextLine();

          if (line.equals("stop")) {
              break;
          }
          int amount = Integer.parseInt(line);

          if (resourcesMap.containsKey(resourceName)) {
              for (  Map.Entry<String, Integer>  kv : resourcesMap.entrySet()) {
                  if (kv.getKey().equals(resourceName)) {
                      kv.setValue(kv.getValue()+ amount);
                  }
              }
          } else {
              resourcesMap.put(resourceName, amount);
          }
            line = scanner.nextLine();
        }

        for (Map.Entry<String, Integer>  kv : resourcesMap.entrySet()) {

            System.out.println(kv.getKey() + " -> " + kv.getValue());
        }

    }
}
