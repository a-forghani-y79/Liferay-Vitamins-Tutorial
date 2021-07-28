package com.denbinger.vitamins.client.function;

import javax.annotation.Generated;

/**
 * @author jinos
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}