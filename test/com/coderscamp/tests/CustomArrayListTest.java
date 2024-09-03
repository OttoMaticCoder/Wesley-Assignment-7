package com.coderscamp.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coderscamp.arraylist.CustomArrayList;

class CustomArrayListTest {
	
	private CustomArrayList<Integer> list;
	
	@BeforeEach
	 void set_Up() {
		list = new CustomArrayList<Integer>();
	}

	@Test
	void test_And_Get_Size() { 
		for (int i = 0; i < 15; i++) {
			list.add(i);
		}
		assertEquals(15, list.getSize());
	}
	
	@Test
	void test_Get_Elements() { 
		for (int i = 0; i < 15; i++) {
			list.add(i);
		}
		for (int i = 0; i < list.getSize(); i++) { 
			assertEquals(i, list.get(i));
		}
	}
	
	@Test
	void test_Add_At_Index() {
		list.add(1);
		list.add(2);
		list.add(1, 3); 
		assertEquals(3, list.getSize());
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(2, list.get(2));
	}
	
	@Test
	void test_Remove() { 
		list.add(1);
		list.add(2);
		list.add(3);
		int removed = list.remove(1);
		assertEquals(2, removed);
		assertEquals(2, list.getSize());
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
	}
}
