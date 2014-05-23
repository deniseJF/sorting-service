package br.assessment.sorting.entities;

import br.assessment.sorting.entities.Configuration.ComparatorDirection;


public class ComparatorParameters{
	
	private String attribute;
	private ComparatorDirection direction;
	
	public ComparatorParameters(){
		
	}

	public ComparatorParameters(String attribute, ComparatorDirection direction) {
		this.attribute = attribute;
		this.direction = direction;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;		
	}

	public ComparatorDirection getDirection() {
		return direction;
	}

	public void setDirection(ComparatorDirection direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "ComparatorParameters [attribute=" + attribute + ", direction="
				+ direction + "]";
	}
	
}
