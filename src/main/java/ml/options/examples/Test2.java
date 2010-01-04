package ml.options.examples;

import ml.options.Options;

public class Test2 {

  public static void main(String args[]) {

    Options opt = new Options(args);
    opt.getSet().addOption("a").addOption("b", Options.Separator.BLANK);

    if (!opt.check()) {
      System.out.println("Usage: java Test2 -a -b <file>\n");
      System.out.println(opt.getCheckErrors());
      System.exit(0);
    }

    System.out.println("<file> = " + opt.getSet().getOption("b").getResultValue(0));

  }

}

