package JavaBasics;

public class OrderPair<K, V> implements Pair<K, V> {

	private K k;
	private V v;
	
	public OrderPair(K k,V v) {
		this.k=k;
		this.v=v;
	}
	
	@Override
	public K getKey() {
		return this.k;
		
	}

	@Override
	public V getValue() {
		return this.v;
	}

}
