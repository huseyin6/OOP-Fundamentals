package g33_ceng211_hw1;

import java.util.Arrays;

public class Library {
	
	private Book[] bookArr;           // One-Dimensional array that holds Book objects
	private int numberOfObjects = 0;  // initially equals to 0
	private int currentCapacity = 25; // I give a random capacity for Book Array..
									  // When it is needed the program will ensure the capacity
	
	public Library () {
		bookArr = new Book[currentCapacity];
	}
	
	public Book[] getBookArr() {
		return bookArr;
	}

	public void setBookArr(Book[] bookArr) {
		this.bookArr = bookArr;
	}
	
	public int getNumberOfObjects() {
		return numberOfObjects;
	}

	public void setNumberOfObjects(int numberOfObjects) {
		this.numberOfObjects = numberOfObjects;
	}
	
	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public void add(Book book) {
		if(numberOfObjects < currentCapacity){
			bookArr[numberOfObjects] = book;
			numberOfObjects++;
		}else {
			ensureCapacity();
			add(book);
		}
	}
	
	public void ensureCapacity() {
		int capacity = this.bookArr.length - 1;
		if(numberOfObjects >= capacity){
			int newCapacity = 2 * capacity;
			this.currentCapacity = newCapacity + 1;
			this.bookArr = Arrays.copyOf(this.bookArr, currentCapacity+1);
		}
	}
	
	public Book getBookByIndex(int i) {
		return bookArr[i];
	}
	
}
