/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author aless
 */
public class Utilities {
    public static double round(double value, int places) {
  if (places < 0) throw new IllegalArgumentException();

    int pow = (int) Math.pow(10, places);
    int removeExtra =(int) Math.round((value*pow));
    double ret  = (double)removeExtra/pow;
    return ret;
}

}
