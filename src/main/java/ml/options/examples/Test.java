package ml.options.examples;

import ml.options.OptionData;
import ml.options.Options;
import ml.options.Options.Multiplicity;
import ml.options.Options.Separator;

public class Test {

  public static void main(String args[]) {

    Options opt = new Options(args, 2, 2);
    
    opt.getSet().addOption("a").addOption("b", Separator.EQUALS).addOption("p", Separator.BLANK);
    opt.getSet().addOption("c", true, Separator.BLANK).addOption("d", true, Separator.COLON);
    opt.getSet().addOption("D", true, Separator.EQUALS, Multiplicity.ZERO_OR_MORE);

    boolean result = opt.check();

    System.out.println(opt);

    System.out.println("Check result: " + result);
    System.out.println("Check result:");
    System.out.println(opt.getCheckErrors());

    OptionData od = opt.getSet().getOption("a");
    for (int i = 0; i < od.getResultCount(); i++) 
      System.out.println("a - " + i + " : result: " + od.getResultDetail(i) + " / " + od.getResultValue(i));

    od = opt.getSet().getOption("b");
    for (int i = 0; i < od.getResultCount(); i++) 
      System.out.println("b - " + i + " : result: " + od.getResultDetail(i) + " / " + od.getResultValue(i));

    od = opt.getSet().getOption("p");
    for (int i = 0; i < od.getResultCount(); i++) 
      System.out.println("p - " + i + " : result: " + od.getResultDetail(i) + " / " + od.getResultValue(i));

    od = opt.getSet().getOption("c");
    for (int i = 0; i < od.getResultCount(); i++) 
      System.out.println("c - " + i + " : result: " + od.getResultDetail(i) + " / " + od.getResultValue(i));

    od = opt.getSet().getOption("d");
    for (int i = 0; i < od.getResultCount(); i++) 
      System.out.println("d - " + i + " : result: " + od.getResultDetail(i) + " / " + od.getResultValue(i));

    od = opt.getSet().getOption("D");
    for (int i = 0; i < od.getResultCount(); i++) 
      System.out.println("D - " + i + " : result: " + od.getResultDetail(i) + " / " + od.getResultValue(i));

    for (String s : opt.getSet().getData()) 
      System.out.println("Data: " + s);

    for (String s : opt.getSet().getUnmatched()) 
      System.out.println("Unmatched: " + s);

  }

}

