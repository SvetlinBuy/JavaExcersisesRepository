import java.util.*;

public class PopulationCounterOld {

    private static class CitiesMap {
        Map<String, Integer> citiesMap = new TreeMap<>(Collections.reverseOrder());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        Map<String, CitiesMap> countriesMap = new LinkedHashMap<>();
        Map countriesTotalP = new TreeMap(Collections.reverseOrder());

        while (!data.equals("report")) {
            String cityInput = data.split("\\|")[0];
            String countryInput = data.split("\\|")[1];
            int populationInput = Integer.parseInt(data.split("\\|")[2]);
            dataCollector(countriesMap, cityInput, countryInput, populationInput);
            data = scanner.nextLine();
        }
        calculateTPCountries(countriesMap, countriesTotalP);
        printCountries(countriesTotalP, countriesMap);
    }

    private static void printCountries(Map<String, Integer> countriesTotalP, Map<String, CitiesMap> countriesMap) {


        for (Map.Entry<String, Integer> country : countriesTotalP.entrySet()) {

            String countryName = country.getKey();
            int totalP = country.getValue();

            System.out.println(countryName + " (total population: " + totalP + ")");

            printCities(countryName, countriesMap);
        }

    }

    private static void printCities(String countryName, Map<String, CitiesMap> countriesMap) {


        for (Map.Entry<String, CitiesMap> country : countriesMap.entrySet()) {

            String name = country.getKey();
            CitiesMap cities = country.getValue();

            if (name.equals(countryName)) {


                for (Map.Entry<String, Integer> city : cities.citiesMap.entrySet()) {

                    String cname = city.getKey();
                    int cpop = city.getValue();

                    System.out.println("=>" + cname + ": " + cpop);

                }


            }

        }


    }

    private static void calculateTPCountries(Map<String, CitiesMap> countriesMap, Map<String, Integer> countriesTotalP) {


        for (Map.Entry<String, CitiesMap> cn : countriesMap.entrySet()) {


            String countryName = cn.getKey();
            CitiesMap citiesMapData = cn.getValue();
            int totalP = 0;

            for (Map.Entry<String, Integer> city : citiesMapData.citiesMap.entrySet()) {

                totalP += city.getValue();

            }

            countriesTotalP.put(countryName, totalP);

        }


    }

    private static void dataCollector(Map<String, CitiesMap> countriesMap, String cityInput, String countryInput, int populationInput) {

        if (countriesMap.containsKey(countryInput)) {

            for (Map.Entry<String, CitiesMap> cntr : countriesMap.entrySet()) {

                CitiesMap cities = cntr.getValue();
                String innerCountryName = cntr.getKey();

                if (countryInput.equals(innerCountryName)) {

                    Map<String, Integer> innerCitiesMap = cities.citiesMap;

                    innerCitiesMap.put(cityInput, populationInput);
                }
            }
        } else {


            CitiesMap newCitiesMap = new CitiesMap();

            newCitiesMap.citiesMap.put(cityInput, populationInput);

            countriesMap.put(countryInput, newCitiesMap);

        }

    }

}

