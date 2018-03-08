//package br.com.dxc.repository;
//
//import java.io.Serializable;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//
//import br.com.dxc.exception.ApplicationValidatorException;
//
//@NoRepositoryBean
//public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
//
//	Boolean tryAcquireLock(Long chave) throws ApplicationValidatorException;
////
////	Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave) throws ApplicationValidatorException;
////
////	Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave, Long chaveLonga) throws ApplicationValidatorException;
////
////	void acquireLock(MetodoLock metodoLock, Integer chave) throws ApplicationValidatorException;
////
////	void acquireLock(Long chave) throws ApplicationValidatorException;
////
////	void acquireLock(MetodoLock metodoLock, Integer chave, Long chaveLonga) throws ApplicationValidatorException;
//
//}