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

    public DLLNode(String val, DLLNode next){
      _cargo = val;
      _pointer = next;
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

//STRING -----------------------------------------------------------------------------

    public String toString() { return _cargo.toString();}

//MAIN METHOD--------------------------------------------------------------------------

    public static void main( String[] args ) {



      }//end main

  }
