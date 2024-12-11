package br.com.junitsetup.LinkedList.interfaces;

public interface ISortedList<T extends Comparable<?>> extends IList<T> {

  public void insert(T value);

}
