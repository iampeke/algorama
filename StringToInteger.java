import java.math.BigInteger;

public class StringToInteger {
  public int myAtoi(String str) {
    if (str == null) {
      return 0;
    }
    if (str.length() == 0) {
      return 0;
    }
    if (str.length() == 1 && (str.equals("-") || str.equals("+"))) {
      return 0;
    }
    
    boolean neg = false;
    str = str.trim();
    if (!str.matches("\\d+")) {
      if (str.charAt(0) == '-') {
          neg = true;
          str = str.substring(1, str.length());
          if (!Character.isDigit(str.charAt(0))) {
              return 0;
          }
      }
      if (str.charAt(0) == '+') {
          str = str.substring(1, str.length());
          if (!Character.isDigit(str.charAt(0))) {
              return 0;
          }
      }
      String[] pieces = str.split("[^\\d]");
      if (pieces.length == 0) {
          return 0;
      }
      str = pieces[0];
    }
    
    try {
      if (neg) {
          str = "-" + str;
      }
      return Integer.parseInt(str);
    } catch (Exception e) {
    	try {
    		BigInteger temp = new BigInteger(str);
    		if (temp.compareTo(BigInteger.ZERO) > 0) {
    			return Integer.MAX_VALUE;
    		} else {
    			return Integer.MIN_VALUE;
    		}
    	} catch (Exception e2) {
    		return 0;
    	}
    }
  }
}
