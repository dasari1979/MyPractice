package com.test.interview.lamda.example;

public class Book {

	private int id;
	private String name;
	private int pages;

	public Book(int i, String name, int j) {
		super();
		this.id = i;
		this.name = name;
		this.pages = j;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + pages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}

	@Override
	public String toString() {

		return "Book [id= " + id + ", name= " + name + ", pages= " + pages + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
