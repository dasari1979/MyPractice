package com.test.interview.streamapi.coding.questions;

class JavaTpoint {
	void show() {
		System.out.println("It is JavaTpoint section");
	}
}

class SEO extends JavaTpoint {
	void showData() {
		// List<?> list = new ArrayList<Integer>();
		System.out.println("It is SEO section");
	}

	void show() {
		System.out.println("Sub class...");
	}
}

public class NoClassDefFoundErrorExample {

	public static void main(String[] args) {
		JavaTpoint seo = new SEO();
		seo.show();
		// SEO data = new SEO();
		// data.showData();
		// data.show();

	}

}
