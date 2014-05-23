package br.assessment.sorting.entities;

import java.util.List;

public class Configuration {
	
	public enum ComparatorDirection { ASC, DESC };	

	private List<ComparatorParameters> configuration;
	
	public Configuration() {	}	

	public Configuration(List<ComparatorParameters> configuration) {
		this.configuration = configuration;
	}

	public List<ComparatorParameters> getConfiguration() {
		return configuration;
	}

	public void setConfiguration(List<ComparatorParameters> configuration) {
		this.configuration = configuration;
	}
}
