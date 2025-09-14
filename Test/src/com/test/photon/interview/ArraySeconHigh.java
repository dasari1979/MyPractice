package com.test.photon.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySeconHigh {

	public static void main(String[] args) {
		Rectangle r = new Square();
		r.setWidth(5);
		r.setHeight(10);

		System.out.println(r.area()); // ❌ Expected 50, but prints 100

		int arr[] = {5,7,2,9,4,10,11};
		
		List<Integer> list = Arrays.stream(arr).sorted().boxed().skip(arr.length-2).collect(Collectors.toList());
		Integer second = Arrays.stream(arr).sorted().boxed().skip(arr.length-2).findFirst().get();

		list.forEach(x->{
		        if(x == second) {
				System.out.print(x+" ");
	         }
		       
		});

	}

}
class Rectangle {
    protected int width, height;

    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }

    public int area() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w) {
        width = height = w;
    }

    @Override
    public void setHeight(int h) {
        width = height = h;
    }
    @Override
    public int area() { return width * height; }
}
