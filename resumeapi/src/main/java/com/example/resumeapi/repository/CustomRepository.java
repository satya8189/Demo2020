package com.example.resumeapi.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.resumeapi.entity.Education;

@Repository
public class CustomRepository {
	
	
	 @PersistenceContext
	   protected EntityManager entityManager;
	 
	 
	/* public List<Education> getEducationlistHql(Long id) {
		 
		 
	        Query query = this.entityManager
	                .createQuery("SELECT u FROM Education u WHERE u.userId =:userId ");
	        
	        query.setParameter("userId", id);
	        
	        List<Education> list = query.getResultList();
	        
	        return list;
	    }
	 
	 */
	 
	 public List<Education> getEducationlistWihSql(Long id) {
		 
		 
	        Query query = this.entityManager
	                .createNativeQuery("SELECT * FROM `education` WHERE `Created_Date` IN(SELECT MAX(`Created_Date`) FROM `education`)",Education.class);
	        
	       
	        
	        List<Education> list = query.getResultList();
	        
	        return list;
	    }
	 
	 public List<Education> getEducationByCriteria(Long id) {
		 
		 CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		  CriteriaQuery<Education> cq = cb.createQuery(Education.class);
		  Root<Education> item = cq.from(Education.class);
		  List<Predicate> predicates = new ArrayList<Predicate>();
		  
		  Predicate p1=cb.equal(item.get("marks"),"1");
		  predicates.add(p1);
		  
		  Predicate p2=cb.equal(item.get("user").get("firstName"),"satya");
		
		  predicates.add(p2);
		  cq.where(p2);
		  Expression<Date> accessTime = item.get("createdDate");
		//  cq.select(cb.max(accessTime));	    
		  List<Education>  list= entityManager.createQuery(cq).getResultList();
		 return list;
	 }
	 
	 
}
