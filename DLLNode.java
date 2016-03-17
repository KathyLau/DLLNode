/*
KATHY LAU
APCS2 PD10
HW12A -- We Got a Big Ol’ Convoy
03-14-2016
*/

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

    public DLLNode getPointer() { return _pointer; }

    public DLLNode getPrev() { return _prev; }

//MUTATORS --------------------------------------------------------------------------

    public String setCargo(String c){
      String old = getCargo();
      _cargo = c;
      return old;
    }


    public DLLNode setPointer (LLNode n){
      DLLNode old = getPointer();
      _pointer = n;
      return old;
    }
    
    public DDLNode setPrev (LLNode n){
      DDLNode old = getPrev();
      _prev = n;
      return old;
    }

//STRING -----------------------------------------------------------------------------

    public String toString() { return _cargo.toString();}

//MAIN METHOD--------------------------------------------------------------------------

    public static void main( String[] args ) {
      
        DLLNode<String> first = new DLLNode<String>( "cat", null );
      	//Create a new node after the first
      	first.setNext( new DLLNode<String>( "dog", null ) );
      	//Create a third node after the second
      	first.getNext().setNext( new DLLNode<String>( "cow", null ) );
      	DLLNode temp = first; 
      	
      	while( temp != null ) {
      	    System.out.println( temp );
      	    temp = temp.getNext();
    	}
      
    }//end main

  }
