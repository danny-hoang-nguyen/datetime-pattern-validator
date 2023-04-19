package prod.danny;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Arrays;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    var input = Arrays.toString(args);
    if (args.length != 2) {
      System.out.println("Size: " + args.length);
      System.err.println("Invalid params: " + input);
      return;
    }
    var zone = args[0];
    var datetimeFormat = args[1];
    try {

      var format = new Date().toInstant().atZone(ZoneId.of(zone)).format(DateTimeFormatter
          .ofPattern(datetimeFormat));
      System.out.println("input -> output : " + input +" -> "+format);
    } catch (ZoneRulesException e) {
      System.err.println("Bad zoneId config : " + zone);
    } catch (IllegalArgumentException e) {
      System.err.println("Bad datetimeFormat config : " + datetimeFormat);
    }
  }
}