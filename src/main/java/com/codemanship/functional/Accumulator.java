package com.codemanship.functional;

public interface Accumulator<T> {
	T apply(T input, T accumulator);
}
