package br.com.dxc.core.dao;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDAO<T, identifier extends Serializable> extends AbstractHibernateDAO<T>
		implements IGenericDAO<T> {
}