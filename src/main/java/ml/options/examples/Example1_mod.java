package ml.options.examples;

import ml.options.Options;
import ml.options.Options.Multiplicity;
import ml.options.Options.Separator;

public class Example1_mod {

  public static void main(String args[]) {

    Options opt = new Options(args, Multiplicity.ZERO_OR_ONE, 2);
    
    opt.getSet().addOption("a").addOption("log", Separator.EQUALS);

    if (!opt.check()) {
      // Print usage hints
      System.exit(1);
    }

    // Normal processing

    if (opt.getSet().isSet("a")) {
      // React to option -a
      System.out.println("a is set");
    }
    if (opt.getSet().isSet("log")) {
      // React to option -log
      String logfile = opt.getSet().getOption("log").getResultValue(0);  
      System.out.println("logfile " + logfile);
    }

    String inpfile = opt.getSet().getData().get(0);
    String outfile = opt.getSet().getData().get(1);
    System.out.println("inpfile " + inpfile);
    System.out.println("outfile " + outfile);

  }

}

