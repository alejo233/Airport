package model;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Jugador;

public class Airport implements Comparator {
	
	private String[] name;
	
	private Airline[]airline;    
 
 	public Airport(Airline[]al) {
 		airline = al;
 		String[]name= {"Avianca","LATAM","KLM","Air France","British Airways","Iberia","American Airlines","Qatar Airways","Air Europa"};
 	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
		
	}

	public Airline[] getAirline() {
		return airline;
	}

	public void setAirline(Airline[]airline) {
		this.airline = airline;
	}
 	//bubble sort
	public void sortTime(Flight A[], int order) {
		for (int i = 0; i < A.length-1; i++) {
			for (int j = 0; j < A.length-i-1; j++) {
				if(compare2(A[j],A[j+1])==1) {
					Flight temp=A[j];
					A[j]=A[j+1];
					A[j+1]=temp;
				}
			}
		}
	}
	//insertion sort
	public  void sortName(Airline A[]){
	    for (int p = 1; p < A.length; p++){ 
	              Airline aux = A[p]; 
	             int  j = p ;
	              while (j>0 && compare(A[j-1],aux)==1) { 
	                                                    
	            	  A[j] = A[j];   
	                   j--;                  
	              }
	              A[j] = aux;
	    }
	}
	//insertion sort
	public  void sortGate(Flight A[]){
	    for (int p = 1; p < A.length; p++){ 
	              Flight aux = A[p]; 
	             int  j = p ;
	              while (j>0 && compare(A[j-1],aux)==1) { 
	                                                    
	            	  A[j] = A[j];   
	                   j--;                  
	              }
	              A[j] = aux;
	    }
	}
	//selection sort
	public  void sortDate(int order) {
        int i, j, pos=0;
        ArrayList<Flight> flights= leerArchivo();
		Flight[] fg= new Flight[flights.size()];
		for (int k = 0; k < flights.size(); k++) {
			fg[i]=flights.get(i);
		}
   
        for (i = 0; i < fg.length - 1; i++) { 
            Flight  menor = fg[i]; 
              for (j = i + 1; j < fg.length; j++){ 
                    if (fg[j].compareTo(menor)==-1) { 
                        menor = fg[j]; 
                        pos = j;
                    }
              }
              if (pos != i){ 
            	  Flight tmp = fg[i];
                  fg[i] = fg[pos];
                  fg[pos] = tmp;
              }
        }
}
	
	
	//Selection Sort
		public void sortByLastname() {
			for (int I = 0; I < students.length-1; I++) {
				String minLastName = students[I].getLastname();
				int minPosition = I;
				
				for (int J = I+1; J < students.length; J++) {
					String currentLastName = students[J].getLastname();
					if(currentLastName.compareTo(minLastName) < 0) {
						minLastName = currentLastName;
						minPosition = J;
					}
				}
				
				Student temp = students[minPosition];
				students[minPosition] = students[I];
				students[I] = temp;
			}
		}
	
	
	//insertion sort
	public  void sortDestination(Flight A[]){
	    for (int p = 1; p < A.length; p++){ 
	              Flight aux = A[p]; 
	             int  j = p ;
	              while (j>0 && compare3(A[j-1],aux)==1) { 
	                                                    
	            	  A[j] = A[j];   
	                   j--;                  
	              }
	              A[j] = aux;
	    }
	}
	
	//insertion sort
	public  void sortNumFlight(Flight A[]){
	    for (int p = 1; p < A.length; p++){ 
	              Flight aux = A[p]; 
	             int  j = p ;
	              while (j>0 && compare4(A[j-1],aux)==1) { 
	                                                    
	            	  A[j] = A[j];   
	                   j--;                  
	              }
	              A[j] = aux;
	    }
	}
	
	

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Airline a= (Airline)o1;
		Airline b= (Airline)o2;
		return a.getName().compareTo(b.getName());
	}
	
	public int compare(Flight a, Flight b) {
		return a.getBoardingGate().compareTo(b.getBoardingGate());
	}
	
	public int compare2(Flight a, Flight b) {
		return a.getTimeSchedule().compareTo(b.getTimeSchedule());
	}
	
	public int compare3(Flight a, Flight b) {
		return a.getDestination().compareTo(b.getDestination());
	}
	
	public int compare4(Flight a, Flight b) {
		return a.getFlightNumber().compareTo(b.getFlightNumber());
	}
	
	public ObservableList<String> 	passFlightsToTheList(int option, int order) throws FileNotFoundException, ClassNotFoundException {
		ObservableList<String> flights=FXCollections.observableArrayList();
		switch(option) {
		case 1:
		File file = new File("data/Flight.txt");
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				flights.add(linea);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			break;
		
		case 2:
			Flight[] flight=sortDate(order);
			for (int i = 0; i < flight.length; i++) {
				flights.add(flight[i].toString());
			}
			break;
		case 3:
			Jugador[] player=OrdenarBurbujaPuntaje();
			for (int i = player.length-1; i >=0; i--) {
				flights.add(player[i].toString());
			}
			break;
		}
		return flights;
	}
	

 	
}


