package com.codemanship.functional;

public interface Question<T> {
	boolean test(T subject);
}
