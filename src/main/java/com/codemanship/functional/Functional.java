package com.codemanship.functional;

import java.util.ArrayList;
import java.util.List;


public class Functional<T> {

	private final List<T> items;
	
	public Functional(List<T> items){
		this.items = items;
	}

	public Functional<T> filter(FilteringFunction<T> question) {
		List<T> results = new ArrayList<>();
		for (T item : items) {
			if(question.apply(item)){
				results.add(item);
			}
		}
		return new Functional<>(results);
	}

	public List<T> asList() {
		return items;
	}

	public <R> Functional<R> map(MappingFunction<T, R> function) {
		List<R> results = new ArrayList<>();
		for (T item : items) {
			results.add(function.apply(item));
		}
		return new Functional<>(results);
	}

	public T reduce(T initialValue, ReducingFunction<T> reducingFunction) {
		T subtotal = initialValue;
		for (T item : items) {
			subtotal = reducingFunction.apply(item, subtotal);
		}
		return subtotal;
	}

	public static <T> Functional<T> fn(List<T> list){
		return new Functional<>(list);
	}

}
