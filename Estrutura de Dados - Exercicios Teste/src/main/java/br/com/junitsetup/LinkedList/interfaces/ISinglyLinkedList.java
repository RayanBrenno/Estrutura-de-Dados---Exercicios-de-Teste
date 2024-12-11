package br.com.junitsetup.LinkedList.interfaces;

public interface ISinglyLinkedList<T extends Object> extends IList<T> {

  public String listContent();

  public T getNextElement();

}
