import java.util.Scanner;

public class StripNumberFromText_V2 {

	public static void main(String[] args) {
		
		Scanner scanL = new Scanner(System.in);
		Scanner scanN = new Scanner(System.in);
		
		String text = "", numberConverted = "", temp = "";
		int amount = 0;
		char currentChar = ' ', oldChar = ' ', nextChar = ' ';
		byte arrayIndex = 0, sortingListLength = 0;
		

		while(!text.equalsIgnoreCase("y")) {
			
			numberConverted = "";
			
			
			System.out.println("Enter amount of lines to strip");
			
			amount = scanN.nextInt();
			
			System.out.println("Enter text to get only number");
			
			String[] packWords = new String[amount];
			
			for(int i = 0; i < amount; i++) {
			
			packWords[i] = scanL.nextLine();
			
			}
			
			
			String[] conversionResult = new String[amount];
			
			
			for(int i = 0; i < amount; i++) {
				
				text = packWords[i];
				
				
				for(int j = 0; j < text.length(); j++) {
					
					
					if(j != text.length() - 1) {
						
						nextChar = text.charAt(j + 1);
					
					} else {
						
						nextChar = ' ';
						
					}
					
					
					currentChar = text.charAt(j);
					
					
					if(j != 0) {
						
						oldChar = text.charAt(j - 1);
						
					} else {
						
						oldChar = ' ';
						
					}
					
					
					if(Character.isDigit(currentChar) && Character.isDigit(nextChar) || 
							(Character.isDigit(currentChar) && (!Character.isDigit(nextChar) && (nextChar == '.' || nextChar == ','))) || 
								((currentChar == '.' || currentChar == ',') && Character.isDigit(oldChar) && Character.isDigit(nextChar))) {
						
						numberConverted += currentChar;
						
						
					} else if ((currentChar == '.' || currentChar == ',') && Character.isDigit(oldChar) && !Character.isDigit(nextChar)) {
						
						numberConverted += " ";
						
						
					} else if(Character.isDigit(currentChar) && (!Character.isDigit(nextChar) && !(nextChar == '.' || nextChar == ','))) {
						
						numberConverted += currentChar + " ";
						
						
					} 
				
				}
			
				
				System.out.println(numberConverted);
				
				conversionResult[i] = numberConverted;
				
				numberConverted = "";
				
				
			}
			
			
			while(!text.equalsIgnoreCase("y") && !text.equalsIgnoreCase("n")) {
				
				System.out.println("Do you want the numbers sorted? (y/n)");
				
				text = scanL.nextLine();
				
			}
			
			
			text = "";
			
			
			if(text.equalsIgnoreCase("y")) {
				
				while(!text.equalsIgnoreCase("a") && !text.equalsIgnoreCase("d")) {
					
					System.out.println("Ascending or Desending? (a/d)");
					
					text = scanL.nextLine();
					
				}
			

				for(int i = 0; i < conversionResult.length; i++) {
					
					numberConverted += conversionResult[i];
					
				}
							
			
				
				for(int i = 0; i < numberConverted.length(); i++) {
						
					currentChar = numberConverted.charAt(i);
						
						
					if(currentChar == ' ') {
							
						sortingListLength++;
						
					}
						
				}
					
					
				double[] sortingList = new double[sortingListLength];
				
				sortingListLength = 0;
				arrayIndex = 0;
		
				
				for(int i = 0; i < numberConverted.length(); i++) {
						
					currentChar = numberConverted.charAt(i);
						
					
					if(currentChar != ' ' && currentChar == ',') {
							
						currentChar = '.';
						
						temp += currentChar;
						
					} else if (currentChar != ' ') {
							
						temp += currentChar;
							
					} else if (currentChar == ' ') {
							
						sortingList[arrayIndex] = Double.parseDouble(temp);
							
						temp = "";
							
						arrayIndex++;
							
					}
					
						
				}
					
				
				if(text.equalsIgnoreCase("a")) {
						
					for(int i = 0; i < sortingList.length; i++) {
							
						for(int j = i + 1; j < sortingList.length; j++) {
								
								if(sortingList[i] > sortingList[j]) {
									
									double tmp = sortingList[i];  
									sortingList[i] = sortingList[j];  
									sortingList[j] = tmp; 
									
								}
									
						}
								
					}
					
				} else if(text.equalsIgnoreCase("d")) {
						
					for(int i = 0; i < sortingList.length; i++) {
							
						for(int j = i + 1; j < sortingList.length; j++) {
								
								if(sortingList[i] < sortingList[j]) {
										
									double tmp = sortingList[i];  
									sortingList[i] = sortingList[j];  
									sortingList[j] = tmp; 
										
								}
									
						}
								
					}
					
				}
					
				
				for(int i = 0; i < sortingList.length; i++) {
					
					if(sortingList[i] == (int) sortingList[i]) {
							
						System.out.println((int) sortingList[i]);
							
					} else {					
						
						System.out.println(sortingList[i]);
						
					}
					
				}
				
			}
			

			System.out.println("");
			
			
			while(!text.equalsIgnoreCase("y") && !text.equalsIgnoreCase("n")) {
				
				System.out.println("Exit? (y/n)");
				
				text = scanL.nextLine();
				
			}
			
		}
		
		
		System.out.println("Program terminated");
		
		scanL.close();
		scanN.close();

	}

}
