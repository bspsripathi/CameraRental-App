package rentmycam.io;

import java.util.*;

class Camera {
	int cameraId;
	String brand;
	String model;
	double Price;
	boolean status;

	public Camera(int cameraId, String brand, String model, double perDayPrice, boolean Available) {
		this.cameraId = cameraId;
		this.brand = brand;
		this.model = model;
		this.Price = perDayPrice;
		this.status = Available;
	}

	@Override
	public String toString() {
		return "Camera [cameraId=" + cameraId + ", brand=" + brand + ", model=" + model + ", Price=" + Price
				+ ", status=" + status + "]";
	}

	public int getCameraId() {
		return cameraId;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getPerDayPrice() {
		return Price;
	}

	public boolean isAvailable() {
		return status;
	}

	public void setAvailable(boolean Available) {
		status = Available;
	}
}

public class CameraApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String USERNAME, PASSWORD;
		System.out.println("\n+-----------------------------------+");
		System.out.println("|   WELCOME TO CAMERA RENTAL APP    |");
		System.out.println("+-----------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE");
		System.out.print("USERNAME - ");
		USERNAME = sc.next();
		System.out.print("PASSWORD - ");
		PASSWORD = sc.next();
		ArrayList<Camera> list = new ArrayList<>();
		list.add(new Camera(1, "Samsung", "DSLR", 1000, true));
		list.add(new Camera(2, "kodak", "Ds123", 500, true));
		list.add(new Camera(3, "Lenova", "XPL", 300, true));
		list.add(new Camera(4, "Nikon", "SRL", 5000, true));
		list.add(new Camera(5, "Kodak", "KO130", 560, true));
		list.add(new Camera(6, "Samsung", "DL", 550, true));
		list.add(new Camera(7, "Canon", "Go267", 120, true));
		cameraApp(list);
	}

	public static void cameraApp(ArrayList<Camera> list) {
		double INR = 1000;
		int v = 0;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. MY CAMERA");
		System.out.println("2. RENT A CAMERA from list");
		System.out.println("3. VIEW ALL CAMERAS");
		System.out.println("4. MY WALLET");
		System.out.println("5. EXIT");
		n = sc.nextInt();
		if (n == 5) {
			System.out.println("YOU EXIT FROM THE APPLICATION");
			System.out.println("THANK YOU \nVISIT AGIAN");

		} else {
			
			switch (n) {
			case 1:
				System.out.println("1. ADD");
				System.out.println("2. REMOVE");
				System.out.println("3. VIEW MY CAMERAS");
				System.out.println("4. GO TO PREVIOUS MENU");
				int n1;
				
				n1 = sc.nextInt();
				if (n1 == 1) {// Adding
					System.out.println("Enter Camera ID: ");
					int cameraId = sc.nextInt();
					if(checkIdPrentOrNot(cameraId,list)) {
						break;
					}
					System.out.println("Enter Camera Brand: ");
					String brand = sc.next();
					System.out.println("Enter Camera Model: ");
					String model = sc.next();
					System.out.println("Enter Camera Price per day: ");
					double price = sc.nextFloat();
					boolean Available = true;

					list.add(new Camera(cameraId, brand, model, price, Available));
					System.out.println("SUCCESSFULLY ADDED");
					System.out.println("You want view camera List please enter '1' else enter '0': ");
					v = sc.nextInt();
					if (v == 1) {
						dispalyAll(list);
					}

				} else if (n1 == 2) {// remove
					dispalyAll(list);
					System.out.println("ENTER THE CAMERA ID TO REMOVE - ");
					int cameraId = sc.nextInt();
					for (int i = 0; i < list.size(); i++) {
						Camera camera = list.get(i);
						if (camera.getCameraId() == cameraId) {
							list.remove(i);
						}
					}
					System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
				} else if (n1 == 3) {// view my cameras
					dispalyAll(list);
				} else if (n1 == 4) {// previous menu
					cameraApp(list);
				}
				break;

			case 2://Rent a cam 
				rentCamera(list, sc, INR);
				
				break;

			case 3://Display All
				dispalyAll(list);
				break;
			case 4: // My wallet
				wallet(sc,INR);
				
				break; 
			}
			System.out.println("If u want continue (1.Yes 2.No)- ");
			v = sc.nextInt();
			if(v==1) {
				cameraApp(list);
			}else {
				
			}
		}
	}

	private static boolean checkIdPrentOrNot(int cameraId, ArrayList<Camera> list) {
		boolean flag = false;
		for (Camera camera : list) {
			if(camera.getCameraId() == cameraId) {
				flag = true;
				System.out.println("Camera Id is already present, please add another ID to add");
				break;
			}
		}
		return flag;
		
	}

	private static void wallet(Scanner sc, double INR) {
		System.out.println("YOUR CURRENT WALLET BALANCE IS:" + INR);
		System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO)- ");
		int m = sc.nextInt();
		if (m == 1) {
			System.out.println("ENTER DEPOSIT AMOUNT: ");
			double addAmount = sc.nextDouble();
			INR = INR + addAmount;
			System.out.print("Your Wallet balance updated successfully...");
		}
		System.out.println("Current wallet balance - " + INR);
		
	}

	private static void dispalyAll(ArrayList<Camera> list) {
		System.out.println(
				"=============================================================================================");
		System.out.println("CAMERA ID\t\tBRAND\t\tMODEL\t\tPRICE(PERDAY)\t\tSTATUS");
		System.out.println(
				"=============================================================================================");
		for (int i = 0; i < list.size(); i++) {
			Camera data = list.get(i);
			String status = data.isAvailable() ? "Available" : "Rented";
			System.out.println(data.getCameraId() + "\t\t\t" + data.getBrand() + "\t\t" + data.getModel()
					+ "\t\t" + data.getPerDayPrice() + "\t\t" + status);
			System.out.println(
					"==============================================================================================");
		}
		
	}

	public static void rentCamera(ArrayList<Camera> list, Scanner sc, double INR) {
		dispalyAll(list);
		int index = -1;
		System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT -: ");
		int cameraId = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			Camera camera = list.get(i);
			if (camera.getCameraId() == cameraId) {
				index = i;
				break; // Found the camera, exit the loop
			}
		}
		if (index != -1) {
			Camera a = list.get(index);
			if (a.getPerDayPrice() <= INR) {
				System.out.println("RENTED SUCCESSFULLY");
				a.setAvailable(false);
				INR = INR - a.getPerDayPrice();
				System.out.println("CURRENT WALLET BALANCE - " + INR);
			} else {
				System.out.println("YOU DON'T HAVE SUFFICIENT BALANCE IN YOUR WALLET");
			}
		} else {
			System.out.println("CAMERA WITH ID " + cameraId + "IS NOT FOUND IN THE LIST.");
		}
	}
}
