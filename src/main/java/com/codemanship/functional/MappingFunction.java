package com.codemanship.functional;

public interface MappingFunction<T, R> {
	R apply(T input);
}
