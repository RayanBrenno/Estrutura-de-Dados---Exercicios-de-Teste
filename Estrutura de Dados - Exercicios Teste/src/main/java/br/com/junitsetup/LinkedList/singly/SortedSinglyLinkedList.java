package br.com.junitsetup.LinkedList.singly;

import br.com.junitsetup.LinkedList.ListNode;
import br.com.junitsetup.LinkedList.interfaces.ISinglyLinkedList;
import br.com.junitsetup.LinkedList.interfaces.ISortedList;

public class SortedSinglyLinkedList<T extends Comparable<T>>
    implements ISortedList<T>, ISinglyLinkedList<T> {

  ListNode<T> head;
  private ListNode<T> current;

  public SortedSinglyLinkedList() {
    this.head = null;
    this.current = null;
  }

  @Override
  public boolean remove(T value) {

    if (head == null)
      return false;

    if (head.getValue().equals(value)) {
      head = head.getNext();
      return true;
    }

    ListNode<T> current = head;
    while (current.getNext() != null && !current.getNext().getValue().equals(value)) {
      current = current.getNext();
    }
    if (current.getNext() == null)
      return false;

    current.setNext(current.getNext().getNext());
    return true;
  }

  @Override
  public T find(T value) {
    ListNode<T> current = head;

    while (current != null) {
      if (current.getValue().equals(value)) {
        return current.getValue();
      }
      current = current.getNext();
    }
    return null;
  }

  @Override
  public void clear() {
    this.head = null;
    this.current = null;
  }

  @Override
  public String listContent() {
    StringBuilder content = new StringBuilder();

    ListNode<T> current = head;

    while (current != null) {
      content.append(current.getValue().toString()).append(" -> ");
      current = current.getNext();
    }

    if (content.length() > 0)
      return content.substring(0, content.length() - 4);
    else
      return "Empty List";

  }

  @Override
  public void insert(T value) {

    ListNode<T> newNode = new ListNode<>(value);

    if (head == null) {
      head = newNode;
      return;
    }

    if (value.compareTo(head.getValue()) < 0) {
      newNode.setNext(head);
      head = newNode;
      return;
    }

    ListNode<T> current = head;
    while (current.getNext() != null && current.getNext().getValue().compareTo(value) < 0) {
      current = current.getNext();
    }

    newNode.setNext(current.getNext());
    current.setNext(newNode);

  }

  @Override
  public void clearNavigation() {
    this.current = this.head;
  }

  @Override
  public T getNextElement() {
    if (current == null)
      return null;

    T value = current.getValue();
    current = current.getNext();

    return value;
  }

}
