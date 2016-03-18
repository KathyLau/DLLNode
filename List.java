public interface List<T>{ 

    public boolean add( T x ); 

    public void add( int i, T newVal );

    public T remove( int i );

    public T get( int i ); 

    public T set( int i, T x ); 

    public int size(); 
}
