package Test;

import Factory.AndaluciaFactory;

public class Test {
  public static void main(String[] args) {
    AndaluciaFactory andaluciaFactory = new AndaluciaFactory();

    System.out.println(andaluciaFactory.createElementoAndaluz("gazpacho").toString());
  }
}
