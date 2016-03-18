public class DLLNode<T>
  {
    private T _cargo; //current node
    private DLLNode<T> _pointer; // points to next Node
    private DLLNode<T> _prev; // points to prev Node

//CONSTRUCTORS ----------------------------------------------------------------------

    public DLLNode(T val, DLLNode<T> prev, DLLNode<T> next){
      _cargo = val;
      _pointer = next;
      _prev = prev;
    }

//ACCESSORS -------------------------------------------------------------------------

    public  T getCargo() { return _cargo; }

    public  DLLNode<T> getNext() { return _pointer; }

    public  DLLNode<T> getPrev() { return _prev; }

//MUTATORS --------------------------------------------------------------------------

    public T setCargo(T c){
      T old = getCargo();
      _cargo = c;
      return old;
    }


    public DLLNode<T> setNext (DLLNode<T> n){
      DLLNode<T> old = getNext();
      _pointer = n;
      return old;
    }

    public DLLNode<T> setPrev (DLLNode<T> n){
      DLLNode<T> old = getPrev();
      _prev = n;
      return old;
    }

//STRING -----------------------------------------------------------------------------

    public String toString() { return _cargo.toString();}

//MAIN METHOD--------------------------------------------------------------------------

    public static void main( String[] args ) {


    }//end main

  }
