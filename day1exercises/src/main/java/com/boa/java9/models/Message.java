package com.boa.java9.models;

public abstract class Message<T> {

	public abstract T send(T protocol, T info);
	
}
