import java.util.Iterator;
import java.util.NoSuchElementException;


public class LList implements List {

    //instance vars
    private DLLNode  _head, _tail; //pointers to first and last nodes
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) {
	     _head = _tail = null;
	     _size = 0;  }


    //insert a node in front of first node
    public boolean add( String newVal ) {
      addLast( newVal );
	    return true; }


    //insert a node containing newVal at position index
    public void add( int index, String newVal ) {

      	if ( index < 0 || index > size() )
	         throw new IndexOutOfBoundsException();
        else if ( index == 0 )
      	   addFirst( newVal );
        else if ( index == size() )
           addLast( newVal );
      	else {
          DLLNode  newNode = new DLLNode ( newVal, null, null ); //make new node
    	    DLLNode  tmp = _head; //create alias to head

      	    //walk to node at pos - 1
      	    for( int i=0; i < index-1; i++ )
      		    tmp = tmp.getNext();

      	    //insert new node
      	    newNode.setNext( tmp.getNext() ); //node at insertion index
      	    newNode.setPrev( tmp );
            tmp.getNext().setPrev(newNode);
      	    tmp.setNext( newNode );

      	    //increment size
      	    _size++;
      	}
          }


    //remove node at pos index, return its cargo
    public String remove( int index ) {

    	if ( index < 0 || index >= size() )
    	    throw new IndexOutOfBoundsException();
    	if ( index == 0 )
    	    return removeFirst();
    	else if ( index == size()-1 )
    	    return removeLast();
    	else {
    	    DLLNode tmp = _head; //create alias to head

    	    //walk to node at pos - 1
    	    for( int i=0; i < index-1; i++ ) {
    		      tmp = tmp.getNext();}
    	    //check target node's cargo hold
    	    String old = tmp.getNext().getCargo();

    	    //remove target node
    	    tmp.setNext( tmp.getNext().getNext() );
    	    tmp.getNext().setPrev( tmp );

          //decrement size
    	    _size--;

    	    return old;
	}
    }


    public String get( int index ) {

      if ( index < 0 || index >= size() )
	       throw new IndexOutOfBoundsException();

      DLLNode  tmp = _head; //create alias to head

      //walk to desired node
    	for( int i=0; i < index; i++ )
    	    tmp = tmp.getNext();

      return tmp.getCargo();
    }


    public String set( int index, String newVal ) {

    	if ( index < 0 || index >= size() )
    	    throw new IndexOutOfBoundsException();

      DLLNode  tmp = _head; //create alias to head

      //walk to node at pos - 1
    	for( int i=0; i < index; i++ )
    	    tmp = tmp.getNext();

      String old = tmp.getCargo();

      //modify target node's cargo
    	tmp.setCargo( newVal );
    	return old;
    }


    //return number of nodes in list
    public int size() { return _size; }


    //insert new node before first node (prev=null, next=_head)
    public void addFirst( String newVal ) {

      _head = new DLLNode ( newVal, null, _head );

    	if ( _size == 0 )
    	    _tail = _head;

    	else
    	    _head.getNext().setPrev( _head );

    	_size++;
        }


    //insert new node after last node (prev=_last, next=null)
    public void addLast( String newVal ) {

    	_tail = new DLLNode ( newVal, _tail, null );

    	if ( _size == 0 )
    	    _head = _tail;

    	else
    	    _tail.getPrev().setNext( _tail );

    	_size++;
        }


    public String getFirst() { return _head.getCargo(); }


    public String getLast() { return _tail.getCargo(); }


    public String removeFirst() {

       String retVal = getFirst();

        if ( size() == 1 ) {
	         _head = _tail = null;}

        else {
    	    _head = _head.getNext();
    	    _head.setPrev( null );}

        _size--;

      return retVal;
    }


    public String removeLast() {

      	String retVal = getLast();

      	if ( size() == 1 ) {
      	    _head = _tail = null;}

      	else {
      	    _tail = _tail.getPrev();
      	    _tail.setNext( null );}

      	_size--;

      	return retVal;
      }


    // STRINGIFY
    public String toString() {

      String retStr = "HEAD->";

      DLLNode  tmp = _head; //init tr

      while( tmp != null ) {
    	    retStr += tmp.getCargo() + "->";
    	    tmp = tmp.getNext();
    }

      retStr += "NULL";

      return retStr;
    }


  //main method for testing
    public static void main( String[] args ) {
      LList go = new LList();

    System.out.println( go );
    System.out.println( "size: " + go.size() );

    go.add("pi");
    System.out.println( go );
    System.out.println( "size: " + go.size() );

    go.add("eggsdee");
    System.out.println( go );
    System.out.println( "size: " + go.size() );

    go.add("frump");
    System.out.println( go );
    System.out.println( "size: " + go.size() );

    go.add(2, "lol");
    System.out.println( go );
    System.out.println( "pos 2: " + go.get(2) );
    System.out.println( "size: " + go.size() );

    go.remove(3);
    System.out.println( go );
    System.out.println( "size: " + go.size() );

    }

}//end class LList
