package br.assessment.sorting.entities;

public class ObjectsComparator implements Comparable<ObjectsComparator>{
	
	public int compareTo(ObjectsComparator another) {
		return toString().compareTo(another == null ? "null" : another.toString());
	}

}
