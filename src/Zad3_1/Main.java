/**
 *
 *  @author Durak Mateusz S21415
 *
 */

package Zad3_1;


import java.util.*;

public class Main {



  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(
                   r -> r.startsWith("WAW")
                       )
                       .mapEvery(
                  r -> "to "+ r.replace("WAW ","").replaceAll("[0-9]+","")
                          .concat("- price in PLN: ").concat(String.valueOf(Integer.parseInt(r.replaceAll("[\\D]",""))*xrate))

                       );
  }

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
