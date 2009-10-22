import ml.options.*;

import static ml.options.Options.*;

public class Test3 {

  private static final String SET1 = "Hugo";
  private static final String SET2 = "Hugo2";

  public static void main(String args[]) {

    Options opt = new Options(args);
    
    opt.addSet(SET1, 2, 5).addOption("a").addOption("c");
    opt.addSet(SET2, 1, 3).addOption("b");

    System.out.println(opt);

    check(opt, SET1);
    check(opt, SET2);

  }

  public static void check(Options opt, String setName) {

    System.out.println("*** Set " + setName);

    boolean result = opt.check(setName);

    System.out.println("Check result: " + result);
    System.out.println("Check result:");
    System.out.println(opt.getCheckErrors());

    for (String s : opt.getSet(setName).getData()) {
      System.out.println("Data: " + s);
    }

    for (String s : opt.getSet(setName).getUnmatched()) {
      System.out.println("Unmatched: " + s);
    }

  }

}

