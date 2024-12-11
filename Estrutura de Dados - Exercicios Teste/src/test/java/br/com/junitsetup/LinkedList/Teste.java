package br.com.junitsetup.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import br.com.junitsetup.LinkedList.singly.SortedSinglyLinkedList;

public class Teste {
    @Nested
  class ListContent{
    @Test
    @DisplayName("Retornar uma lista")
    public void retrieveList() {
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      list.insert(1);
      list.insert(2);
      list.insert(3);
      list.insert(4);
      list.insert(5);

      String content = list.listContent();

      assertEquals("1 -> 2 -> 3 -> 4 -> 5", content);
    }

    @Test
    @DisplayName("Retornar uma lista vazia")
    public void retrieveAnEmptyList() {
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      String content = list.listContent();

      assertEquals("Empty List", content);
    }
  }

  @Nested
  @DisplayName("Inserir")
  class Insertion {

    @Test
    @DisplayName("Inserir elementos")
    public void insertElements() {
    
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      list.insert(8);
      list.insert(5);
      list.insert(3);
      list.insert(0);
      list.insert(-6);

      String content = list.listContent();

      assertEquals("-6 -> 0 -> 3 -> 5 -> 8", content);
    }

    @Test
    @DisplayName("Inserir elementos reversamente")
    public void insertElementsReverse() {
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      list.insert(-6);
      list.insert(0);
      list.insert(3);
      list.insert(5);
      list.insert(8);

      String content = list.listContent();

      assertEquals("-6 -> 0 -> 3 -> 5 -> 8", content);
    }

    @Test
    @DisplayName("Inserir elementos aleatorios")
    public void insertAleatoryElements() {
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      list.insert(5);
      list.insert(3);
      list.insert(0);
      list.insert(8);
      list.insert(-6);

      String content = list.listContent();

      assertEquals("-6 -> 0 -> 3 -> 5 -> 8", content);
    }

  }

  @Nested
  @DisplayName("Encontrar")
  class Find {

    @Test
    @DisplayName("Encontrar um elemento existente")
    public void findAnExistingElement() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      double value = list.find(-7);

      assertEquals(-7, value);
    }

    @Test
    @DisplayName("Elemento não encontrado")
    public void doesNotFindAnElement() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      Integer value = list.find(333);

      assertNull(value);
    }

  }

  @Nested
  @DisplayName("Remover")
  class Remove {

    @Test
    @DisplayName("Remover um elemento existente")
    public void removeAnExistingElement() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      boolean removed = list.remove(5);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("-10 -> -7 -> -3 -> 2 -> 4 -> 8", content);
    }

    @Test
    @DisplayName("Remover um elemento duplicado")
    public void removeAnExistingDuplicateElement() {
      Integer[] elements = new Integer[] { 2, 5, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      boolean removed = list.remove(5);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("-10 -> -7 -> -3 -> 2 -> 4 -> 5 -> 8", content);
    }
    

    @Test
    @DisplayName("Não remover nenhum elemento")
    public void doesNotRemoveAnElement() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      boolean removed = list.remove(666);
      String content = list.listContent();

      assertFalse(removed);
      assertEquals("-10 -> -7 -> -3 -> 2 -> 4 -> 5 -> 8", content);
    }

  }

  @Nested
  @DisplayName("Limpar")
  class Clear{

    @Test
    @DisplayName("Limpar lista")
    public void clearAListWithElements() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      list.clear();
      String content = list.listContent();

      assertEquals("Empty List", content);
    }
  }

  @Nested
  @DisplayName("Navegar")
  class Navigate {

    @Test
    @DisplayName("Navegar por todos os elementos")
    public void navigateThroughAllElements() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      list.clearNavigation();

      Integer element = list.getNextElement();
      assertEquals(-10, element);

      element = list.getNextElement();
      assertEquals(-7, element);

      element = list.getNextElement();
      assertEquals(-3, element);

      element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(4, element);

      element = list.getNextElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);

      element = list.getNextElement();
      assertNull(element);
    }

    @Test
    @DisplayName("Navegar pelos elementos e reiniciar o ponteiro de navegação")
    public void navigateThroughElementsAndRestartNavigationPointer() {
      Integer[] elements = new Integer[] { 2, -7, -3, -10, 5, 8, 4 };
      SortedSinglyLinkedList<Integer> list = new SortedSinglyLinkedList<Integer>();

      for (int i = 0; i < elements.length; i++) {
        list.insert(elements[i]);
      }

      list.clearNavigation();

      Integer element = list.getNextElement();
      assertEquals(-10, element);

      element = list.getNextElement();
      assertEquals(-7, element);

      element = list.getNextElement();
      assertEquals(-3, element);

      list.clearNavigation();

      element = list.getNextElement();
      assertEquals(-10, element);

      element = list.getNextElement();
      assertEquals(-7, element);

      element = list.getNextElement();
      assertEquals(-3, element);

      element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(4, element);

      element = list.getNextElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);

      element = list.getNextElement();
      assertNull(element);
    }
  }
}
