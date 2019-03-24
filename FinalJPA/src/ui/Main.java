package ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.City;
import model.User;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User u = new User();
        u.setFirstName("dusan");
        em.persist(u);
        tx.commit();
        em.close();
        
        
        /*
        Query q = em.createQuery("SELECT e FROM Employee e");
        Query query = em.createNamedQuery("Employee.findAll");
        
        List lista = q.getResultList();
        
        for( Object e : lista){
            Employee e2 = (Employee)e;
            System.out.println(e2.getEmail());
        }
        
        List l1 = query.getResultList();
        for(Object o : lista) {
        	Employee e3 = (Employee)o;
        	System.out.println(e3.getFirstName());
        }
               
        TypedQuery<Employee> q2 = em.createQuery("SELECT c FROM Employee c", Employee.class);
        
        List <Employee> empList = q2.getResultList();
        
        for (Employee e : empList){
            System.out.println(e.getBonus());
        }
        
        em.close();
        */
       
        
        
        
        /*
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<City> from = criteriaQuery.from(City.class);        
        CriteriaQuery<Object> select = criteriaQuery.select(from);        

        select.orderBy(criteriaBuilder.asc(from.get("employees")));        
        TypedQuery<Object> typedQuery = em.createQuery(select);

        List<Object> resultlist = typedQuery.getResultList();        
        for(Object o:resultlist){

        	City e=(City)o;

           System.out.println(e.getName());
        }
        
        em.close();*/
	}
	


	}


