package com.codemanship.functional;

public interface ReducingFunction<T> {
	T apply(T input, T accumulator);
}
