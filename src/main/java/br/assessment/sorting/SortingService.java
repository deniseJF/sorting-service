package br.assessment.sorting;

import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import br.assessment.sorting.entities.ComparatorParameters;
import br.assessment.sorting.entities.Configuration;
import br.assessment.sorting.entities.ObjectsComparator;
import br.assessment.sorting.entities.Configuration.ComparatorDirection;

public class SortingService {
	ComparatorChain chain;
	Configuration configuration;
	
	public SortingService(Configuration configuration){
		chain = new ComparatorChain();
		this.configuration = configuration;
		initComparatorChain(configuration);
	}
	
	public SortingService(String path){
		chain = new ComparatorChain();
		this.configuration = ConfigurationLoader.loadConfigurationFromFile(path);
		initComparatorChain(configuration);
	}

	private void initComparatorChain(Configuration configuration) {
		for (ComparatorParameters param : configuration.getConfiguration()) {
			chain.addComparator(new BeanComparator(param.getAttribute()));
			if (param.getDirection().equals(ComparatorDirection.DESC))
				chain.setReverseSort(configuration.getConfiguration().indexOf(param));
		}
	}
	
	public void sortList(List<? extends ObjectsComparator> list) throws OrderingException {
		if (list == null)
			throw new OrderingException("The list to sort is null.");

		Collections.sort(list, chain);
	}

	public static class OrderingException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public OrderingException(String msg) {
			super(msg);
		}

	}
}
