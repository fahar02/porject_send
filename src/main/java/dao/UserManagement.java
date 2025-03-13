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
	public double calMaterail(String s1,double a)
	{
		HashMap<String, Double> materialEmissionsMap = new HashMap<>();

        // Adding some sample data (material and its CO2 emission per kg)
        materialEmissionsMap.put("Steel", 1900.0);  // 1900 grams of CO2 per kg for Steel
        materialEmissionsMap.put("Stainless Steel", 2200.0);  // 2200 grams of CO2 per kg for Stainless Steel
        materialEmissionsMap.put("Aluminium", 8700.0); // 8700 grams of CO2 per kg for Aluminium
        materialEmissionsMap.put("Copper", 4000.0);   // 4000 grams of CO2 per kg for Copper
        materialEmissionsMap.put("Plastic", 6000.0);  // 6000 grams of CO2 per kg for Plastic
        materialEmissionsMap.put("Ceramics", 500.0);  // 500 grams of CO2 per kg for Ceramics
        materialEmissionsMap.put("Glass", 500.0);     // 500 grams of CO2 per kg for Glass
        materialEmissionsMap.put("Paper", 1200.0);    // 1200 grams of CO2 per kg for Paper
        double d=materialEmissionsMap.get(s1);
        double result=(d*a)/1000;
        if(result <0)
        {
        	return 0;
        }
        return result;

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
	        double d1=map.get(s1);
	        double d2=map.get(s2);
	        double result=Math.round(d1-d2)/1000;
	        if(result <0)
	        {
	        	return 0;
	        }
	       return result;
	}
	public double calHome(String s1,double a)
	{
		HashMap<String, Double> co2EmissionsMap = new HashMap<>();

        // Adding some sample data (device and its CO2 emission per hour in grams)
        co2EmissionsMap.put("Heater", 1500.0);  // 1500 grams of CO2 per hour for Heater
        co2EmissionsMap.put("AC", 2000.0);      // 2000 grams of CO2 per hour for AC
        co2EmissionsMap.put("Water", 800.0);    // 800 grams of CO2 per hour for Water Heater
        co2EmissionsMap.put("Light", 30.0);     // 30 grams of CO2 per hour for Light (for energy consumption)
        co2EmissionsMap.put("Other Electronic Device", 100.0);  // 100 grams of CO2 per hour for other electronics
		double d=co2EmissionsMap.get(s1);
		double result=Math.round(d*a)/1000;
		if(result <0)
        {
        	return 0;
        }
       
        return result;
	}

}
