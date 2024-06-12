package com.sunbeam.tester;

import java.awt.Choice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sunbeam.dao.BlogsDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.GetCategoriesdao;
import com.sunbeam.dao.RegistrationDao;
import com.sunbeam.dao.Userdao;
import com.sunbeam.entity.Blogs;
import com.sunbeam.entity.Categories;
import com.sunbeam.entity.User;

public class Main {
	
	
	
		//For the Main Menu/First page of the Program... 
		public static int mainMenu(Scanner sc)	 {
			int choice;
			System.out.println("Welcome to Safin's Blogging App");
			System.out.println();
			System.out.println("0. Exit");
			System.out.println("1. Login");
			System.out.println("2. Register");
			choice= sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Thankyou for using my App");
				return choice; 
			case 1:
				loginPage(sc);
				return choice;
			case 2:
				registerUser();
				
				return choice;
			default:
				System.out.println("Please Enter the valid Input...");
				return choice;
			}
		}
		
		//For the case 1 login Page
		public static void loginPage(Scanner sc) {
			System.out.println("Please Login to continue...");
			System.out.println();
			System.out.print("Email : ");
			String email = sc.next();
			System.out.print("Password : ");
			String password = sc.next();
			System.out.println();
			checkForCharacterForLogin(sc, email, password);
		}
		
		//To check the Line "Enter c to continue and e to exit from Application"
		public static void checkForCharacterForLogin(Scanner sc, String email, String password) {
			System.out.println("Enter c to continue and e to exit from the app");
			String character = sc.next();
			if(character.equals("c")) {
				ifCpressedInLogin(sc, email, password);
			}
			else if(character.equals("e")){
				mainMenu(sc);
			}
			else {
				System.out.println("Please Enter valid character");
				checkForCharacterForLogin(sc, email, password);
			}
		}
		
		public static int ifCpressedInLogin(Scanner sc, String email, String password) {
			int userID = -1;
			try(Userdao ud = new Userdao()){
				 userID = ud.checkForUserCreds(sc, email, password);	
				AfterSuccessfulLoginBlogingPage(sc, userID);
			}			
			 catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return userID;
		}
		
		//After the user name and password is inserted and checked in DB where the values are present after that this function is called
		public static void AfterSuccessfulLoginBlogingPage(Scanner sc, int userID) {
			int choice;
			do {
			System.out.println("Welcome <user>");
			System.out.println("1. Add Category");
			System.out.println("2. Show Categories");
			System.out.println("3. All Blogs");
			System.out.println("4. Add Blog");
			System.out.println("5. Edit Blog");
			System.out.println("6. Search Blog");
			System.out.println("7. Delete Blog");
			System.out.println("8. Logout");
			
			choice = sc.nextInt();
			switch (choice) {
			case 1:
			{
				Categories categories = new Categories();
				categories.acceptData();
				
				try {
					CategoryDao categoryDao = new CategoryDao();
					categoryDao.createCategory(categories);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
				
				break;

			case 2:
			{
				try {
					GetCategoriesdao categoriesdao = new GetCategoriesdao();
					ArrayList<Categories> list= 	  categoriesdao.getCatDao();
					
					for (Categories categories : list) {
						System.out.println(categories);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
				break;
			case 3:
			{
				try {
					BlogsDao blogsDao = new BlogsDao();
					ArrayList<Blogs> list= 	  blogsDao.displayAllBlogs();
					
					for (Blogs blogs : list) {
						
						System.out.println(blogs);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
				
				break;
			case 4:
			{
				Blogs blogs = new Blogs();
				blogs.acceptData();
				blogs.setUser_id(userID);
				
				
				System.out.println("Which category your blog fits (enter id)?");
				try {
					GetCategoriesdao dCategoriesdao = new GetCategoriesdao();
				ArrayList<Categories> list= 	  dCategoriesdao.getCatDao();
				
				
				for (Categories categories : list) {
					System.out.println(categories);
					
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int idCat = sc.nextInt();
				blogs.setCategory_d(idCat);
				
				try {
					BlogsDao  blogsDao = new BlogsDao();
					blogsDao.insertIntoBlog(blogs);
					System.out.println("added blog");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
				
				break;
			case 5:
			{
				System.out.println("Enter id which you want to update blog for:");
				int id = sc.nextInt();
				
				System.out.println("Enter the contents for updating: ");
				String content =sc.next();
				
				try {
					BlogsDao blogsDao = new BlogsDao();
					
					blogsDao.editBlog(id, content);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}
				
				break;
			case 6:
			{
				System.out.println("Enter blog id to serach for: ");
				int id = sc.nextInt();
				try {
					BlogsDao blogsDao = new BlogsDao();
					ArrayList<Blogs> blogs =    blogsDao.serachBlog(id);
					for (Blogs blogs2 : blogs) {
						System.out.println(blogs2);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
				break;
			case 7:
			{
				
				System.out.println("Enter blog id to delete for: ");
				 int id  = sc.nextInt();
				
				BlogsDao blogsDao;
				try {
					blogsDao = new BlogsDao();
					blogsDao.removeBlog(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
				
			}
				
			
				
			default:
				break;
			}}while(choice!=8);
		}
		
	
		
		public static void registerUser() {
			try {
				RegistrationDao registrationDao = new RegistrationDao();
				User user = new User();
				user.acceptData();
				registrationDao.registerUser(user);
				System.out.println("User added..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int choice;
			do {
				choice = mainMenu(sc);
			} while (choice != 8);
		}

	}













