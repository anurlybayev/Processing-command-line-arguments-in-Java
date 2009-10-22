import ml.options.*;

/**
 * java Example2 -c [-v] [-D<detail>=<value> [...]] data1 data2
 * java Example2 -a [-v] [-check] data1 [data2] [data3]
 * java Example2 -d [-v] -k <kval> -t <tval> data1 data2 [data3] [data4]
 */

import static ml.options.Options.*;

public class Example2 {

  public static void main(String args[]) {

    Options opt = new Options(args, 2);
    
    opt.addSet("cset").addOption("c").addOption("D", true, Separator.EQUALS, Multiplicity.ZERO_OR_MORE);
    opt.addSet("aset", 1, 3).addOption("a").addOption("check", Multiplicity.ZERO_OR_ONE);
    opt.addSet("dset", 2, 4).addOption("d").addOption("k", Separator.BLANK).addOption("t", Separator.BLANK);

    opt.addOptionAllSets("v", Multiplicity.ZERO_OR_ONE);

    OptionSet set = opt.getMatchingSet();

    if (set == null) {
      // Print usage hints
      System.exit(1);
    }

    if (set.isSet("v")) {
      System.out.println("v is set");
    }

    // Normal processing

    if (set.getSetName().equals("cset")) {
      // React to the first set
      System.out.println("cset");
      for (String d : set.getData())
        System.out.println(d);
      OptionData d = set.getOption("D");
      for (int i = 0; i < d.getResultCount(); i++) {
        System.out.println("D detail " + i + " : " + d.getResultDetail(i));
        System.out.println("D value  " + i + " : " + d.getResultValue(i));
      }
    } else if (set.getSetName().equals("aset")) {
      // React to the second set
      System.out.println("aset");
      for (String d : set.getData())
        System.out.println(d);
      if (set.isSet("check")) {
        System.out.println("check is set");
      }
    } else {
      // We know it has to be the third set now
      System.out.println("dset");
      for (String d : set.getData())
        System.out.println(d);
      System.out.println(set.getOption("k").getResultValue(0));
      System.out.println(set.getOption("t").getResultValue(0));
    }

  }

}

