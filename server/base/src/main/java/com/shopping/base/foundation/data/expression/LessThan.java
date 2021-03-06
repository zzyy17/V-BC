/*
 * Copyright 2016 - 2017 suoke & Co., Ltd.
 */
package com.shopping.base.foundation.data.expression;


import com.shopping.base.foundation.data.AbstractExpression;
import com.shopping.base.foundation.data.QueryFormHelper;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @version 1.0 created at 2017年5月26日 下午1:08:21
 *
 */
public class LessThan<Y extends Comparable<? super Y>> extends AbstractExpression {

	public LessThan(Y value) {
		super(value);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Predicate buildJpaPredicate(CriteriaBuilder cb, Root<?> root, Object expression) {
		Expression<Y> path = QueryFormHelper.getPath(root, expression.toString());
		Y num = (Y) value;
		return cb.lessThan(path, num);
	}

	@Override
	public Criteria buildMongoCriteria(Object expression) {
		String path = expression.toString();
		return Criteria.where(path).lt(value);
	}
}
