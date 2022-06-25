package up.deconto.tf2.delivery.utils;

import java.util.UUID;
import java.util.regex.Pattern;

public class UUIDUtil {

	private final static Pattern UUID_REGEX_PATTERN = Pattern
			.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

	/**
	 * Get Pattern
	 * 
	 * @return Pattern
	 */
	public static Pattern getPattern() {
		return UUID_REGEX_PATTERN;
	}

	/**
	 * Check String is UUID
	 * 
	 * @param String value
	 * @return boolean
	 */
	public static boolean isUUID(String value) {
		return UUID_REGEX_PATTERN.matcher(value).matches();
	}

	/**
	 * String to UUID
	 * 
	 * @param String value
	 * @return UUID
	 */
	public static UUID str2uuid(String value) {
		return UUID.fromString(value);
	}

	/**
	 * UUID to String
	 * 
	 * @param UUID value
	 * @return String
	 */
	public static String uuid2str(UUID value) {
		return value.toString();
	}
}