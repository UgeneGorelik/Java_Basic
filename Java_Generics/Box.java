package JavaBasics;

public class Box<T> {
	
	private T obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	//bounded type parametres
	//U has to have bounds of number type
	public <U extends Number> void inspect(U u) {
		System.out.println("U:" + u);
		System.out.println("U:" + u.getClass().getName());
		
	}
	
	

}
