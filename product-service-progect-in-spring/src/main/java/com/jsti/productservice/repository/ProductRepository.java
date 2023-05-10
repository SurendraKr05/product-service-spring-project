package com.jsti.productservice.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsti.productservice.entity.Product;

@Repository
public class ProductRepository {
	@Autowired
	private SessionFactory factory;
	
	public void createProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Serializable save = session.save(product);
		System.out.println(save);
		transaction.commit();
	}
	
	public List<Product> getAllProduct(){
		String sql="from Product";
		Session session=factory.openSession();
		Query<Product> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public Product getProductById(long id) {
		Session session = factory.openSession();
		String sql="from Product where productId=:id";
		Query query = session.createQuery(sql);
		
		query.setParameter("id", id);
		Product product =(Product) query.getSingleResult();
		return product;	
	}
	
	public Integer getProductQuentiryById(long id) {
		Session session = factory.openSession();
		String sql="select quantity from Product where productId=:id";
		
		Query query = session.createQuery(sql);
		query.setParameter("id", id);
		Object qty = query.uniqueResult();
		String string=qty.toString();
		Integer quentity = Integer.parseInt(string);
		return quentity;
	}
	
	public List<Product> getProductByName(String name){
		String sql="from Product where name=:name";
		Session session =factory.openSession();
		Query<Product> query = session.createQuery(sql);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public Product deleteProductById(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql="delete from Product where productId=:id";
		Query query = session.createQuery(sql);
		query.setParameter("id", id);
		Product productById = getProductById(id);
		query.executeUpdate();
		transaction.commit();
		return productById;
	}
	
}
