package com.github.virgo47.enumconv._2framework;

import java.util.HashMap;
import java.util.Map;

public enum SomeEntityType implements ConvertedEnum<Integer> {
	NORMAL(0),
	SPECIAL(1);

	private final Integer dbValue;

	private SomeEntityType(Integer dbValue) {
		this.dbValue = dbValue;
	}

	@Override
	public Integer toDbValue() {
		return dbValue;
	}

	// static resolving:
	public static final Map<Integer, SomeEntityType> dbValues = new HashMap<>();

	static {
		for (SomeEntityType value : values()) {
			dbValues.put(value.dbValue, value);
		}
	}

	public static SomeEntityType fromDbValue(Integer dbValue) {
		return dbValues.get(dbValue);
	}
}
