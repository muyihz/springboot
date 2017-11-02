package com.muou.common.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.PARAMETER)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RequsetRuleCheck {
	int ruleMask() default -1;
}
