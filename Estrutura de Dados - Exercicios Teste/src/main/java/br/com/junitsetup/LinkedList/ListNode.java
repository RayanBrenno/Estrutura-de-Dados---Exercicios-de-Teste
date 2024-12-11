package br.com.junitsetup.LinkedList;

public class ListNode<T extends Object> {

    private ListNode<T> next;
    private T value;
  
    public ListNode(T value) {
      this.value = value;
      this.next = null;
    }
  
    public ListNode<T> getNext() {
      return next;
    }
  
    public void setNext(ListNode<T> next) {
      this.next = next;
    }
  
    public T getValue() {
      return value;
    }
  
    public void setValue(T value) {
      this.value = value;
    }
  
  }