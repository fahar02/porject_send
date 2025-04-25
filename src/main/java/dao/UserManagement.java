package dao;

import java.util.HashMap;



import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dto.Home;
import dto.Material;
import dto.Travel;
import dto.User;

public class UserManagement {
	public List<Travel> gettravel(User u)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		User user=entityManager.find(User.class,1);
		entityTransaction.commit();
		List<Travel> travel=user.getTravel();
	     if (travel != null) {
	         ListIterator<Travel> iterator = travel.listIterator();
	         while (iterator.hasNext()) {
	             System.out.println(iterator.next());
	         }
	     } else {
	         System.out.println("No travel records found for the user.");
	     }
		return travel;
	}
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("EcoSphere").createEntityManager();
	}
	public User saveUser(User user)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	
	public User fingUserId(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		User user= entityManager.find(User.class,id);
		transaction.commit();
		return user;
		
	}
	public List<User> fingUser()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from User u");
		System.out.println("query executed");
		return query.getResultList();
		
	}
	public Home saveHome(User user,Home home)
	{
		EntityManager entityManager=getEntityManager();
		User u=entityManager.find(User.class,user.getUserId());
		if(u!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			home.setUser(user);
			List <Home> homes=user.getHome();
			homes.add(home);
			user.setHome(homes);
			entityManager.persist(home);
			entityManager.merge(user);
			entityTransaction.commit();
			return home;
		}
		else {
			System.out.println("User is not persent");
		}
		return null;
	}
	public Travel saveTravle(User user,Travel travel)
	{
		EntityManager entityManager=getEntityManager();
		User u=entityManager.find(User.class,user.getUserId());
		if(u!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			travel.setUser(user);
			List <Travel> travels=user.getTravel();
			travels.add(travel);
			user.setTravel(travels);
			entityManager.persist(travel);
			entityManager.merge(user);
			entityTransaction.commit();
			return travel;
		}
		else {
			System.out.println("User is not persent");
		}
		return null;
	}
	public Material saveMaterail(User user,Material material)
	{
		EntityManager entityManager=getEntityManager();
		User u=entityManager.find(User.class,user.getUserId());
		if(u!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			material.setUser(user);
			List <Material> materials=user.getMaterail();
			materials.add(material);
			user.setMaterail(materials);
			entityManager.persist(material);
			entityManager.merge(user);
			entityTransaction.commit();
			return material;
		}
		else {
			System.out.println("User is not persent");
		}
		return null;
	}
	
	public  double calTravel(String s1,String s2,double distance)
	{
		 HashMap<String, Double> map= new HashMap<>();

	        // Adding some sample data (mode and its emission per km)
	        map.put("Car", 120.5); // 120.5 grams of CO2 per km
	        map.put("Bus", 80.2);  // 80.2 grams of CO2 per km
	        map.put("Bicycle", 0.0); // Bicycle has no emissions
	        map.put("Train", 50.3); // 50.3 grams of CO2 per km
	        map.put("Flight", 250.0);
	        map.put("Walking", 0.0);// 250 grams of CO2 per km
	        map.put("Bike", 20.0);
	        double d1=map.get(s1)*distance;
	        double d2=map.get(s2)*distance;
	        double result=(d1-d2)/1000;
	        System.out.println(result+" "+d1+" "+d2);
	        if(result !=0)
	        {
	        	return result;
	        }
	       return 0;
	}
	

}
