public class LList<T> implements List<T> {

    //instance vars
    private  DLLNode<T>  _head, _tail; //pointers to first and last nodes
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) {
	     _head = _tail = null;
	     _size = 0;  }


    //insert a node in front of first node
    public boolean add( T newVal ) {
      addLast( newVal );
	    return true; }


    //insert a node containing newVal at position index
    public void add( int index, T newVal ) {

      	if ( index < 0 || index > size() )
	         throw new IndexOutOfBoundsException();
        else if ( index == size() )
           addLast( newVal );

        DLLNode<T>  newNode = new  DLLNode<T> ( newVal, null, null ); //make new node

        if ( index == 0 )
         	   addFirst( newVal );
      	else {
            DLLNode<T> tmp = _head; //create alias to head

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
    public T remove( int index ) {

    	if ( index < 0 || index >= size() )
    	    throw new IndexOutOfBoundsException();
    	if ( index == 0 )
    	    return removeFirst();
    	else if ( index == size()-1 )
    	    return removeLast();
    	else {
    	     DLLNode<T> tmp = _head; //create alias to head

    	    //walk to node at pos - 1
    	    for( int i=0; i < index-1; i++ ) {
    		      tmp = tmp.getNext();}
    	    //check target node's cargo hold
    	    T old = tmp.getNext().getCargo();

    	    //remove target node
    	    tmp.setNext( tmp.getNext().getNext() );
    	    tmp.getNext().setPrev( tmp );

          //decrement size
    	    _size--;

    	    return old;
	}
    }


    public T get( int index ) {

      if ( index < 0 || index >= size() )
	       throw new IndexOutOfBoundsException();

       DLLNode<T> tmp = _head; //create alias to head

      //walk to desired node
    	for( int i=0; i < index; i++ )
    	    tmp = tmp.getNext();

      return tmp.getCargo();
    }


    public T set( int index, T newVal ) {

    	if ( index < 0 || index >= size() )
    	    throw new IndexOutOfBoundsException();

       DLLNode<T> tmp = _head; //create alias to head

      //walk to node at pos - 1
    	for( int i=0; i < index; i++ )
    	    tmp = tmp.getNext();

      T old = tmp.getCargo();

      //modify target node's cargo
    	tmp.setCargo( newVal );
    	return old;
    }


    //return number of nodes in list
    public int size() { return _size; }


    //insert new node before first node (prev=null, next=_head)
    public void addFirst( T newVal ) {

      _head = new  DLLNode<T> ( newVal, null, _head );

    	if ( _size == 0 )
    	    _tail = _head;

    	else
    	    _head.getNext().setPrev( _head );

    	_size++;
        }


    //insert new node after last node (prev=_last, next=null)
    public void addLast( T newVal ) {

    	_tail = new  DLLNode<T> ( newVal, _tail, null );

    	if ( _size == 0 )
    	    _head = _tail;

    	else
    	    _tail.getPrev().setNext( _tail );

    	_size++;
        }


    public T getFirst() { return _head.getCargo(); }


    public T getLast() { return _tail.getCargo(); }


    public T removeFirst() {

       T retVal = getFirst();

        if ( size() == 1 ) {
	         _head = _tail = null;}

        else {
    	    _head = _head.getNext();
    	    _head.setPrev( null );}

        _size--;

      return retVal;
    }


    public T removeLast() {

      	T retVal = getLast();

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
      List<String> test = new LList<String>();

      test.add("clinton");
      test.add("trump");
      test.add("kaisch");
      test.add("cruz");
      test.add("sander");
      test.add("rubio");

  	for( int i=0; i<5; i++ ) {
  	    int n = (int)( test.size() * Math.random() );
  	    test.add( n, "V" );
  	    System.out.println(test);
  	}

  	while( test.size() > 0 ) {
  	    int n = (int)( test.size() * Math.random() );
  	    test.remove(n);
  	    System.out.println(test);
  	}

    }

}//end class LList
