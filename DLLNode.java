public class DLLNode
  {
    private String _cargo; //current node
    private DLLNode _pointer; // points to next Node
    private DLLNode _prev; // points to prev Node

//CONSTRUCTORS ----------------------------------------------------------------------

    public DLLNode(){
      _cargo = "c";
      _pointer = null;
      _prev = null;
    }

    public DLLNode(String val, DLLNode next, DLLNode prev){
      _cargo = val;
      _pointer = next;
      _prev = prev;
    }

//ACCESSORS -------------------------------------------------------------------------

    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _pointer; }

    public DLLNode getPrev() { return _prev; }

//MUTATORS --------------------------------------------------------------------------

    public String setCargo(String c){
      String old = getCargo();
      _cargo = c;
      return old;
    }


    public DLLNode setNext (DLLNode n){
      DLLNode old = getNext();
      _pointer = n;
      return old;
    }
    
    public DLLNode setPrev (DLLNode n){
      DLLNode old = getPrev();
      _prev = n;
      return old;
    }

//STRING -----------------------------------------------------------------------------

    public String toString() { return _cargo.toString();}

//MAIN METHOD--------------------------------------------------------------------------

    public static void main( String[] args ) {
      
      
    }//end main

  }
