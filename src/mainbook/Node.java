/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainbook;

/**
 *
 * @author alisu
 * @param <E>
 */
  public class Node<E extends Comparable<E>> {

    protected E element;
    protected Node<E> left;
    protected Node<E> right;

    public Node(E e) {
      element = e;
    }
  }