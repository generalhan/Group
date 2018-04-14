package com.common.datamodel;
/**
 * 
 * @author zwl
 *
 * @param <T>
 */
public class TBean<T> {

	Object object;
	 T value;
	 
	 public TBean(){}

	public TBean(Object object,T value)
	{
		this.object=object;
		 this.value=value;
	}

	public Object getObject() {
		return object;
	}

	public T getValue() {
		return value;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	 
	public void setValue(T value) {
		this.value = value;
	}
}
