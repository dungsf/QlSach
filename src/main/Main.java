package main;

import java.io.IOException;
import java.util.Scanner;

import services.admin.AdminServices;
import services.client.BookCaseServices;
import services.client.BookServices;
import services.client.LoginLogOutServices;
import services.client.UserServices;
import utils.Validator;

public class Main {
	
	public static void main(String[] args) {
		String userName, userPass;
		String menu, adminChoise, editChoise, userChoise;
		Scanner sc = new Scanner(System.in);
		
		AdminServices admin = new AdminServices();
		UserServices userServices = new UserServices();
		BookServices bookServices = new BookServices();
		LoginLogOutServices loginLogOutServices = new LoginLogOutServices();
		BookCaseServices bookCaseServices = new BookCaseServices();
		//add user, admin
		//userServices.addUser();
		
		while(true) {
			System.out.println("-------------MENU-------------");
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("3.Exit");
			do {
				System.out.print("Please enter the choise: ");
				menu = sc.next();
				if(!Validator.isId(menu)) {
					System.err.println("Please enter the number!");
				}
			}while(!Validator.isId(menu));
			
			switch(menu) {
				case "1":
					System.out.println("------------------------------------------------------------------------");
					System.out.println("Welcome to Read Book Application! Please enter your username and userpass");
					do {
						
						System.out.print("User name: ");
						 userName = sc.next();
						
						System.out.print("Password: ");
						userPass = sc.next();
						
						if(loginLogOutServices.checkRole(userName, userPass) == -1) {
							System.err.println("Username or Password is wrong!");
							System.err.println("Please enter again: ");
						}
					}while(loginLogOutServices.checkRole(userName, userPass) == -1);
					
					if(loginLogOutServices.checkRole(userName, userPass) == 0) {
						do {
							System.out.println("---------------------------------------------------------------------------------");
							System.out.println("Hello "+userName+", Please select a function bellow by entering the corresponding number.");
							// User function
							System.out.println("1. View list book");
							System.out.println("2. View book detail");
							System.out.println("3. Search book");
							System.out.println("4. View bookcase");
							System.out.println("5. Edit bookcase");
							System.out.println("6. Change password");
							System.out.println("7. Logout");
							do {
								System.out.print("Hello "+userName+", your choice is: ");
								userChoise = sc.next();
								if(!Validator.isId(userChoise)) {
									System.err.println("Please enter the number!");
								}
							}while(!Validator.isId(userChoise));
							
							switch (userChoise) {
							case "1":
								System.out.println("---------------LIST BOOK----------------");
								bookServices.viewListBook();
								break;
							case "2":
								System.out.println("---------------BOOK DETAIL----------------");
								bookServices.readBook();
								break;
							case "3":
								int searchChoice = 0;
								do{
									System.out.println("Please select type: ");
									System.out.println("1. By name");
									System.out.println("2. By author");
									System.out.println("3. By category");
									System.out.println("4. Exit"); 
									searchChoice = sc.nextInt();
									switch (searchChoice) {
									case 1:
										bookServices.searchBook(1);
										break;
									case 2:
										bookServices.searchBook(2);
										break;
									case 3:
										bookServices.searchBook(3);
										break;
									case 4:
										break;
									default:
										System.err.println("Your choice is invalid! Please input another choice.");
										break;
									}
								} while (searchChoice!=4);
								break;
							case "4":
								bookCaseServices.viewBookCase(userServices.getIdLogin(userName));
								break;
							case "5":
								System.out.println("-----------------------------");
								bookCaseServices.viewBookCase(userServices.getIdLogin(userName));
								System.out.println("-----------------------------");
								System.out.println("1. Add a new book");
								System.out.println("2. Remove a book");
								System.out.println("3. Clear BookCase");
								System.out.println("4. Exit");
								System.out.println("Please enter the number:");
								do {
									userChoise = sc.next();
									if (!Validator.isId(userChoise)) {
										System.err.println("Please enter the number!");
									}
								} while (!Validator.isId(userChoise));
								switch (userChoise) {
								case "1":
									int idBook;
									System.out.println("Please enter the id add: ");
									idBook = sc.nextInt();
									bookCaseServices.addBook(userServices.getIdLogin(userName), idBook);
									break;
								case "2":
									int idBook1;
									System.out.println("Please enter the id remove: ");
									idBook1 = sc.nextInt();
									bookCaseServices.removeBook(userServices.getIdLogin(userName), idBook1);
									break;
								case "3":
									bookCaseServices.clearBook(userServices.getIdLogin(userName));									
									break;
								case "4":
									break;
								default:
									System.err.println("Your choice is invalid! Please input another choice.");
									break;
								}
								break;
							case "6":
								int idLogin = userServices.getIdLogin(userName);
								userServices.changePassword(idLogin);
								break;
							case "7":
								
								break;
							default:
								System.err.println("Your choice is invalid! Please input another choice.");
								break;
							}
						}while(!userChoise.equals("7"));
						
					
						
					}else if(loginLogOutServices.checkRole(userName, userPass) == 1) {
						do {
							System.out.println("-----------ADMIN-----------");
							System.out.println("1. Create book");
							System.out.println("2. Edit book");
							System.out.println("3. Remove book");
							System.out.println("4. View list of Users");
							System.out.println("5. Change password");
							System.out.println("6. Logout");
							do {
								System.out.print("Please enter your choise: ");
								adminChoise = sc.next();
								if(!Validator.isId(adminChoise)) {
									System.err.println("Please enter the number!");
								}
							}while(!Validator.isId(adminChoise));
							
							switch(adminChoise) {
								case "1":
									System.out.println("---------------CREATE BOOK---------------");
									admin.inputBook();
									break;
								case "2":
									bookServices.viewListBook();
									int id;
									do {
										System.out.print("Enter the book_id you want to update: ");
										id = sc.nextInt();
										if(!bookServices.checkBookId(id)) {
											System.err.println("Book is not existed");
										}
									}while(!bookServices.checkBookId(id));
									
									do {
										System.out.println("----------EDIT BOOK---------");
										System.out.println("1.Book name");
										System.out.println("2.Book author");
										System.out.println("3.Book title");
										System.out.println("4.Book content");
										System.out.println("5.Exit");
										do {
											System.out.print("You want to edit: ");
											editChoise = sc.next();
											if(!Validator.isId(editChoise)) {
												System.err.println("Please enter the number!");
											}
										}while(!Validator.isId(editChoise));
										
										switch(editChoise) {
											case "1":
												try {
													admin.editBookName(id);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												break;
											case "2":
												try {
													admin.editBookAthor(id);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												break;
											case "3":
												try {
													admin.editBookTitle(id);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												break;
											case "4":
												try {
													admin.editBookContent(id);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												break;
											case "5":
												break;
											default:
												System.err.println("Your choice is invalid! Please input another choice.");
												break;
										}
										
									}while(!editChoise.equals("5"));
									break;
									
								case "3":
									String idRemove;
									do {
										bookServices.viewListBook();
										System.out.print("Enter the book_id you want to remove: ");
										idRemove = sc.next();
										if(!Validator.isId(idRemove)) {
											System.err.println("Please enter the number!");
										}else if(!bookServices.checkBookId(Integer.parseInt(idRemove))) {
												System.err.println("Book is not existed");
										}
										
									}while(!Validator.isId(idRemove) || !bookServices.checkBookId(Integer.parseInt(idRemove)));
									
									try {
										admin.remove(Integer.parseInt(idRemove));
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								case "4":
									String editChoises;
									do {
										userServices.display();
										System.out.println("1.Change role");
										System.out.println("2.Exit");
										do {
											System.out.print("You want to edit: ");
											editChoises = sc.next();
											if(!Validator.isId(editChoises)) {
												System.err.println("Please enter the number!");
											}
										}while(!Validator.isId(editChoises));
										
										switch(editChoises) {
											case "1":
												String ids;
												do {
													System.out.print("Please enter the id you want to change role: ");
													ids = sc.next();
													if(!Validator.isId(ids)) {
														System.err.println("Please enter the number!");
													}else if(userServices.getIdLogin(userName) == Integer.parseInt(ids)){
														System.err.println("You can't change this user role!");
													}
												}while(!Validator.isId(ids) || userServices.getIdLogin(userName) == Integer.parseInt(ids));
												
												
												System.out.println("-----------------CHANGE ROLE-----------------");
												admin.changeRole(ids);
												break;
											case "2":
												break;
											default:
												System.err.println("Your choice is invalid! Please input another choice.");
												break;
										}
										
									}while(!editChoises.equals("2"));
									break;
								case "5":
									System.out.println("------------CHANGE PASSWORD-----------------");
									int idLogin = userServices.getIdLogin(userName);
									userServices.changePassword(idLogin);
									break;
								case "6":
									break;
								default:
									System.err.println("Your choice is invalid! Please input another choice.");
									break;
							}
						}while(!adminChoise.equals("6"));
						
					}
					break;
				case "2":
					userServices.register();
					break;	
				case "3":
					System.exit(0);
					break;
				default:
					System.err.println("Your choice is invalid! Please input another choice.");
					break;
			}
			
		}
	}
}
