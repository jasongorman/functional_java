package com.codemanship.functional;

import java.util.ArrayList;
import java.util.List;


public class Functional<T> {

	private List<T> items;
	
	public Functional(List<T> items){
		this.items = items;
	}

	public Functional<T> filter(Question<T> question) {
		List<T> results = new ArrayList<>();
		for (T item : items) {
			if(question.test(item)){
				results.add(item);
			}
		}
		return new Functional<T>(results);
	}

	public List<T> asList() {
		return items;
	}

	public <R> Functional<R> map(MappingFunction<T, R> function) {
		List<R> results = new ArrayList<>();
		for (T item : items) {
			results.add(function.apply(item));
		}
		return new Functional<R>(results);
	}

	public <R, V> T reduce(T initialValue, Accumulator<T> accumulator) {
		T subtotal = initialValue;
		for (T item : items) {
			subtotal = accumulator.apply(item, subtotal);
		}
		return subtotal;
	}

	public static <T> Functional<T> fn(List<T> list){
		return new Functional<>(list);
	}

}
