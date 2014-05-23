package br.assessment.sorting;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import br.assessment.sorting.entities.Configuration;

public class ConfigurationLoader {
	public static Configuration loadConfigurationFromFile(String filePath)
			throws ConfigurationErrorException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Configuration conf;
			conf = mapper.readValue(new File(filePath), Configuration.class);
			return conf;
		} catch (JsonParseException e) {
			throw new ConfigurationErrorException(
					"Error on parsing JSON file.", e);
		} catch (JsonMappingException e) {
			throw new ConfigurationErrorException(
					"Error on mapping to Configuration object.", e);
		} catch (IOException e) {
			throw new ConfigurationErrorException(
					"Error on reading from file.", e);
		}
	}

	public static class ConfigurationErrorException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ConfigurationErrorException(String msg, Throwable e) {
			super(msg, e);
		}

	}
}
