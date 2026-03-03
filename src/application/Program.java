package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("====TEST 1: SELLER FIND BY ID ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n====TEST 2: SELLER FIND BY DEPARTMENT ====");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n====TEST 3: SELLER FIND ALL ====");
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n====TEST 4: SELLER INSERT ====");
		Seller newSeller = new Seller(null, "Jordan", "jordan@gmail.com", new Date(), 3400.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id: " + newSeller.getId());	
		
		System.out.println("\n====TEST 5: SELLER UPDATE ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wane");
		seller.setEmail("martha@gmail.com");
		seller.setBaseSalary(2000.0);
		sellerDao.update(seller);
		System.out.println("Update Completed");


	}

}
