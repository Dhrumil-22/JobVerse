package com.DAO;

import java.util.ArrayList;  
import java.util.*;
import org.hibernate.Query; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.VO.*;

public class RegDAO {

	public void js_insert(JS_RegVO regVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(regVO);

		transaction.commit();
		session.close();
	}
	
	public void updateResume(String username, byte[] resumePic) {
	    // Open a Hibernate session and start a transaction
	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();

	    // Fetch the list of matching user records based on the username for JS_RegVO
	    Query query = session.createQuery("FROM JS_RegVO WHERE userName = :username");
	    query.setParameter("username", username);
	    List<JS_RegVO> users = query.list();  // Get a list of users

	    // Fetch the list of matching user records based on the username for Applied_RegVO
	    Query query2 = session.createQuery("FROM Applied_RegVO WHERE js_UserName = :username");
	    query2.setParameter("username", username);
	    List<Applied_RegVO> users2 = query2.list();  // Get a list of users

	    // Update resume for all users in JS_RegVO
	    for (JS_RegVO user : users) {
	        user.setResume(resumePic);
	        session.update(user);
	    }
	    
	    // Update resume for all users in Applied_RegVO
	    for (Applied_RegVO user2 : users2) {
	        user2.setResume(resumePic);
	        session.update(user2);
	    }

	    // Commit the transaction
	    transaction.commit();
	    session.close();
	}





	public void e_insert(E_RegVO regVO) {

	    // Create a session factory using the existing configuration
	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    
	    // Open a session to interact with the database
	    Session session = sessionFactory.openSession();
	    
	    // Start a transaction
	    Transaction transaction = session.beginTransaction();

	    try {
	        // Save the E_RegVO object, which includes the profile picture and other details
	        session.save(regVO);

	        // Commit the transaction to persist the data
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            // Rollback in case of an error
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        // Close the session to free up resources
	        session.close();
	    }
	}

	
	public void insert_post(E_POST_RegVO regVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(regVO);

		transaction.commit();
		session.close();
	}
	
	public void insert_post2(E_POST_RegVO2 regVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(regVO);

		transaction.commit();
		session.close();
	}

	public Object login(String Un, String Pass) {
	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();

	    Object user = null;

	    
	    Query q1 = session.createQuery("FROM JS_RegVO WHERE js_UserName = :Un AND js_Password = :Pass");
	    q1.setParameter("Un", Un);
	    q1.setParameter("Pass", Pass); 
	    user = q1.uniqueResult();
	    
	    if (user == null) {
	        
	        Query q2 = session.createQuery("FROM E_RegVO WHERE e_UserName = :e_username AND e_Password = :e_password");
	        q2.setParameter("e_username", Un); 
	        q2.setParameter("e_password", Pass); 
	        user = q2.uniqueResult();
	    }
	    
	    session.close();
	    return user;
	}

	public List E_Post() {

		List searchList = new ArrayList();

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query q = session.createQuery("from E_POST_RegVO");

		searchList = q.list();
		session.close();

		return searchList;
	}
	
	public List<E_POST_RegVO> searchBar(String searchTerm) {
	    
	    List<E_POST_RegVO> searchList = new ArrayList<>();

	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();

	    // Use LIKE operator with wildcards to find partial matches
	    String hql = "from E_POST_RegVO where e_EssentialSkills like :skill";
	    Query query = session.createQuery(hql);
	    query.setParameter("skill", "%" + searchTerm + "%"); // Add wildcards for partial match
	    
	    searchList = query.list();
	    session.close();

	    return searchList;
	}
	
public List<E_POST_RegVO> Seepost(Object Un) {
	    
	    List<E_POST_RegVO> searchList = new ArrayList<>();

	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();

	    // Use LIKE operator with wildcards to find partial matches
	    Query query = session.createQuery("FROM E_POST_RegVO WHERE e_userName = :e_username");
	    query.setParameter("e_username", Un); 
        
	    searchList = query.list();
	    
	    session.close();

	    return searchList;
	}
	
	
	public List<E_POST_RegVO> DashBoard() {
	    List<E_POST_RegVO> postList = new ArrayList<>();

	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    // Execute HQL query to fetch all posts
	    String hql = "from E_POST_RegVO";
	    Query query = session.createQuery(hql);
	    postList = query.list();
	    
	    session.close();

	    return postList;
	}
	
	public List Details(int id) {

		List searchList = new ArrayList();

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query q = session.createQuery("from E_POST_RegVO Where id=" + id);

		searchList = q.list();
		session.close();

		return searchList;
	}


	public void Delete(E_POST_RegVO E_POST_RegVO) {
	    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();

	    E_POST_RegVO entity = (E_POST_RegVO) session.get(E_POST_RegVO.class, E_POST_RegVO.getId());
	    if (entity != null) {
	        session.delete(entity);
	    }

	    transaction.commit();
	    session.close();
	}

	/*public void Delete(E_POST_RegVO E_POST_RegVO) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(E_POST_RegVO);

		transaction.commit();
		session.close();
	}*/

	
		public List<E_POST_RegVO> edit(int id) {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();
		    Query query = session.createQuery("from E_POST_RegVO where id = :id");
		    query.setParameter("id", id);
		    List<E_POST_RegVO> searchList = query.list();
		    session.close();
		    return searchList;
		}

		public void update(E_POST_RegVO regVO, E_POST_RegVO2 regVO2) {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();
		    Transaction transaction = session.beginTransaction();
		    session.update(regVO);
		    session.update(regVO2);
		    transaction.commit();
		    session.close();
		}
		
		
		public void Apply(int id, Object un) {
		    // Initialize lists to hold post and user data
		    List<E_POST_RegVO> postList = new ArrayList<>();
		    List<JS_RegVO> userList = new ArrayList<>();
		    List<Applied_RegVO> appliedList = new ArrayList<>();

		    // Set up Hibernate session
		    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();
		    Transaction transaction = session.beginTransaction(); // Start a transaction

		    // Fetching data from E_POST_RegVO based on id
		    Query query1 = session.createQuery("FROM E_POST_RegVO WHERE id = :id");
		    query1.setParameter("id", id);
		    postList = query1.list();

		    // Fetching data from JS_RegVO based on username
		    Query query2 = session.createQuery("FROM JS_RegVO WHERE js_UserName = :js_UserName");
		    query2.setParameter("js_UserName", un);
		    userList = query2.list();

		    // Loop through the lists and save to the new table
		    for (E_POST_RegVO post : postList) {
		        for (JS_RegVO user : userList) {
		            Applied_RegVO result = new Applied_RegVO();

		            // Set fields from JS_RegVO (user)
		            result.setProfilePic(user.getProfilePic());
		            result.setResume(user.getResume());
		            result.setFirstName(user.getFirstName());
		            result.setLastName(user.getLastName());
		            result.setEmail(user.getEmail());
		            result.setUserName(user.getUserName());
		            result.setEducation(user.getEducation());
		            result.setCurrentCity(user.getCurrentCity());
		            result.setCurrentState(user.getCurrentState());

		            // Set fields from E_POST_RegVO (post)
		            result.setUsername(post.getUsername());
		            result.setCompanyName(post.getCompanyName());
		            result.setTechnology(post.getTechnology());
		            result.setExperience(post.getExperience());
		            result.setLocation(post.getLocation());
		            result.setJobRole(post.getJobRole());
		            result.setDepartment(post.getDepartment());
		            result.setEmploymentType(post.getEmploymentType());
		            result.setCompanyWebsite(post.getCompanyWebsite());
		            result.setCompanyAddress(post.getCompanyAddress());
		            result.setContactPerson(post.getContactPerson());
		            result.setContactEmail(post.getContactEmail());
		            result.setContactPhone(post.getContactPhone());
		            result.setJobDescription(post.getJobDescription());
		            result.setEssentialSkills(post.getEssentialSkills());
		            result.setAdditionalRequirements(post.getAdditionalRequirements());
		            result.setMinEducation(post.getMinEducation());
		            result.setPreferredQualification(post.getPreferredQualification());

		            // Save the result to the database
		            session.save(result);
		            appliedList.add(result); // Add the saved result to the list
		        }
		    }

		    // Commit the transaction
		    transaction.commit();

		    // Close the session
		    session.close();

		    // Return the list of Applied_RegVO objects
		    
		}
		
		public List<Applied_RegVO> notification(Object Un) {
		    
		    List<Applied_RegVO> searchList = new ArrayList<>();

		    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();

		    // Use LIKE operator with wildcards to find partial matches
		    Query query = session.createQuery("FROM Applied_RegVO WHERE e_userName = :e_username");
		    query.setParameter("e_username", Un); 
	        
		    searchList = query.list();
		    
		    session.close();

		    return searchList;
		}
		
		public List<E_RegVO> E_acc(Object Un) {
		    List<E_RegVO> searchList = new ArrayList<>();

		
		        // Initialize SessionFactory and Session
		    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			    Session session = sessionFactory.openSession();

		        // Use LIKE operator with wildcards if needed, otherwise exact match is fine
		        Query query = session.createQuery("FROM E_RegVO WHERE userName = :userName");
		        query.setParameter("userName", Un);

		        searchList = query.list();
		   

		    return searchList;
		}

		
		public List<JS_RegVO> JS_acc(Object Un) {
		    
		    List<JS_RegVO> searchList = new ArrayList<>();

		    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();

		    // Use LIKE operator with wildcards to find partial matches
		    Query query = session.createQuery("FROM JS_RegVO WHERE js_UserName = :js_UserName");
		    query.setParameter("js_UserName", Un); 
	        
		    searchList = query.list();
		    
		    session.close();

		    return searchList;
		}
		
		
		public Object CheckPass(String Un, String bf) {
		    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();

		    Object user = null;

		    
		    Query q1 = session.createQuery("FROM JS_RegVO WHERE js_UserName = :js_UserName AND js_Best = :js_Best");
		    q1.setParameter("js_UserName", Un);
		    q1.setParameter("js_Best", bf); 
		    user = q1.uniqueResult();
		    
		    if (user == null) {
		        
		        Query q2 = session.createQuery("FROM E_RegVO WHERE e_UserName = :e_UserName AND e_Best = :e_Best");
		        q2.setParameter("e_UserName", Un); 
		        q2.setParameter("e_Best", bf); 
		        user = q2.uniqueResult();
		    }
		    
		    session.close();
		    return user;
		}
		
		public void EResetPass(String Cp,Object Un) {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();
		    Transaction transaction = session.beginTransaction();
		    
		    Query q2 = session.createQuery("FROM E_RegVO WHERE e_UserName = :e_UserName");
	        q2.setParameter("e_UserName", Un); 

	        E_RegVO e_RegVO = (E_RegVO) q2.uniqueResult();
	        e_RegVO.setPassword(Cp);
	        session.update(e_RegVO);
	        transaction.commit();
	        session.close();

		}
		
		public void JSResetPass(String Cp,Object Un) {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		    Session session = sessionFactory.openSession();
		    Transaction transaction = session.beginTransaction();
		    
		    Query q2 = session.createQuery("FROM JS_RegVO WHERE js_UserName = :js_UserName");
	        q2.setParameter("js_UserName", Un); 

	        JS_RegVO js_RegVO = (JS_RegVO) q2.uniqueResult();
	        js_RegVO.setPassword(Cp);
	        session.update(js_RegVO);
	        transaction.commit();
	        session.close();

		}

}
