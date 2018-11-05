/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainbook;

public abstract class AbstractTree<E> implements Tree<E> {

 
  public void postorder() {
  }

  public void preorder() {
  }

  @Override
  public boolean isEmpty() {
    return getSize() == 0;
  }
}
