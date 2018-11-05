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
public class BST<E extends Comparable<E>> extends AbstractTree<E> {
  protected Node<E> root;
  protected int size = 0;
  
  public BST() {
      
  }

 
  @Override
  public boolean search(E e) {
    Node<E> current = root;

    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else 
        return true; 
    }

    return false;
  }

  
  @Override 
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e);
    else {
        
      Node<E> parent = null;
      Node<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false;

      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }

    size++;
    return true; 
  }
  

  protected Node<E> createNewNode(E e) {
    return new Node<>(e);
  }

  
  @Override
  public int getSize() {
    return size;
  }

  
  
  @Override
  public boolean delete(E e) {
    
    Node<E> parent = null;
    Node<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; 
    }

    if (current == null)
      return false; 
    //1
    if (current.left == null) {
        
      if (parent == null) {
        root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    
    //2
    else {
      
      Node<E> parentOfRightMost = current;
      Node<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right;
      }

      current.element = rightMost.element;

      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else

        parentOfRightMost.left = rightMost.left;     
    }

    size--;
    return true;
  }
  

  
    
  @Override 
  public void inorder() {
    inorder(root);
  }

  protected void inorder(Node<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }
  
  
   @Override
  public void postorder() {
    postorder(root);
  }

  // @param root */
  protected void postorder(Node<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }
 

  public void clear() {
    root = null;
    size = 0;
  }
}