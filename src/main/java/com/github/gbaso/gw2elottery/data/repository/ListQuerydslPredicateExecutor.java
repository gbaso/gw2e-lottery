package com.github.gbaso.gw2elottery.data.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

@NoRepositoryBean
public interface ListQuerydslPredicateExecutor<T> extends QuerydslPredicateExecutor<T> {

    @Override
    List<T> findAll(Predicate predicate);

    @Override
    List<T> findAll(Predicate predicate, Sort sort);

    @Override
    List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

    @Override
    List<T> findAll(OrderSpecifier<?>... orders);

}
