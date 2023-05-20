package rentmycam.io;
import java.util.*;
public class Camera {
public static void main(String [] args) {
	Scanner sc=new Scanner(System.in);
		String USERNAME,PASSWORD;
		System.out.println("\n+-----------------------------------+");
		System.out.println("|   WELCOME TO CAMERA RENTAL APP    |");
		System.out.println("+-----------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE");
		System.out.print("USERNAME - ");
		USERNAME=sc.next();
		System.out.print("PASSWORD - ");
		PASSWORD=sc.next();
		cameraApp();
}
		public static void cameraApp() {
			int n;
			Scanner sc=new Scanner(System.in);
			System.out.println("1. MY CAMERA");
			System.out.println("2. RENT A CAMERA from list");
			System.out.println("3. VIEW ALL CAMERAS");
			System.out.println("4. MY WALLET");
			System.out.println("5. EXIT");
		     n=sc.nextInt();
			   if (n==5) {
				System.out.println("YOU EXIT FROM THE APPLICATION");
				System.out.println("THANK YOU \nVISIT AGIAN");
        	
		          }
			else {
			switch(n) {
		        	case 1:
					               System.out.println("1. ADD");
			                	   System.out.println("2. REMOVE");
					               System.out.println("3. VIEW MY CAMERAS");
					               System.out.println("4. GO TO PREVIOUS MENU");
					               int n1;
					               n1=sc.nextInt();
					               if(n1==1) {}
					               else if(n1==2) {}
					               else if(n1==3) {}	
					               else if(n1==4) 
						             cameraApp();
					               break;
		        	case 2 :
		        		           rentCamera();
		        	               	break;
		        	case 3 :
		                    		listOfCameras();
		        		             break;
					
					
				}
			}
	}
		public static void listOfCameras() {
			System.out.println("=================================================================================================");
			System.out.println("CAMERA ID        BRAND            MODEL         PRICE(PERDAY)         STATUS");
			System.out.println("=================================================================================================");
			System.out.println("  1              SAMSUNG            DS123        500                 Available");
			System.out.println("=================================================================================================");
		}
		public static void rentCamera() {
			System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT");
			System.out.println("\nYOUR TRANSCATION FOR CAMERA "+"HAS SUCCESSFULLY COMPLETED");
		}
}
class Wallet {
	
}

	
	


