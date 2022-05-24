package hust.soict.dsai.aims.utils;
import java.util.Collections;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;
public class DVDUtils {
	public static String compareByCost(DigitalVideoDisc d1, DigitalVideoDisc d2){
		String cost_compare = "The DVD "+ d1.getTitle();
		if (d1.getCost() > d2.getCost()){
			cost_compare += (" is more expensive than the DVD " + d2.getTitle());
		}
		else if(d1.getCost() == d2.getCost()) {
			cost_compare += (" has the same price with the DVD " + d2.getTitle());
		}
		else {
			cost_compare += (" is cheaper than " + d2.getTitle());
		}
		return cost_compare;
		
	};
	public static String compareByTitle(DigitalVideoDisc d1, DigitalVideoDisc d2) {
		int title_compare_result;
		String title_compare;
		title_compare_result = d1.getTitle().compareTo(d2.getTitle());
		if (title_compare_result < 0) {
			title_compare = "The DVD "+ d1.getTitle() + " comes before" + " the DVD "+ d2.getTitle();
			}
		else if (title_compare_result == 0) {
			title_compare = "The DVD "+ d1.getTitle() + " is equal to" + " the DVD "+ d2.getTitle();

		}
		else {
			title_compare = "The DVD "+ d1.getTitle() + " comes after" + " the DVD "+ d2.getTitle();

		}
		return title_compare;
		
	}
	protected static void swap(DigitalVideoDisc[] arr, int i, int j)
	{
	    DigitalVideoDisc temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

	protected static int partition(DigitalVideoDisc[] arr, int low, int high)
	{

		DigitalVideoDisc pivot = arr[high];

	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         

	        if (arr[j].getCost() < pivot.getCost())
	        {

	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	protected static void quickSort(DigitalVideoDisc[] arr, int low, int high)
	{
	    if (low < high)
	    {

	        int pi = partition(arr, low, high);
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}

	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] arr) {
		int n = arr.length;
		quickSort(arr, 0, n-1);
		
		return arr;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] arr) {
	      
	        for (int i = 0; i < arr.length -1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < arr.length; j++){  
	                if (arr[j].getTitle().compareTo(arr[index].getTitle())< 0){  
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            DigitalVideoDisc tmp= arr[index];   
	            arr[index] = arr[i];  
	            arr[i] = tmp;
	        }
	        return arr;

		
		
	
		
		
	

}
}
