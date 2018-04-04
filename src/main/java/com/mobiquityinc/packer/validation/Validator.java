
package com.mobiquityinc.packer.validation;


@FunctionalInterface
public interface Validator<T> {

    boolean validate(T object);

}
