package org.bh.tools.net.msg;



/**
 * Represents a single field.
 *
 * @param <ValueType> The type of value this field holds (i.e.
 *                    {@link Integer}, {@link java.net.InetAddress InetAddress}, etc.)
 * @param <TextType>  The type of text to convert it to
 */
public abstract class Field<ValueType, TextType extends CharSequence> implements MessagePiece<TextType> {
	private final CharSequence name;
	private ValueType value;

	/**
	 * Creates a new header field
	 *
	 * @param initName  The name of this field (i.e. {@code "UUID"}, {@code "IP"}, etc.)
	 * @param initValue The value contained in this field (i.e. {@code 0xAF09}, {@code 127.0.0.1}, etc.)
	 */
	public Field(CharSequence initName, ValueType initValue) {
		name = initName;
		value = initValue;
	}

	/**
	 * Returns the name of this field (i.e. {@code "UUID"}, {@code "IP"}, etc.)
	 *
	 * @return the name of this field
	 */
	public CharSequence getName() {
		return name;
	}

	/**
	 * Changes the value of this field (i.e. {@code 0xAF09}, {@code 127.0.0.1}, etc.)
	 *
	 * @param newValue the new value of this field
	 *
	 * @return this
	 */
	public Field<ValueType, TextType> setValue(ValueType newValue) {
		value = newValue;
		return this;
	}

	/**
	 * Returns the value of this field (i.e. {@code 0xAF09}, {@code 127.0.0.1}, etc.)
	 *
	 * @return the value of this field
	 */
	public ValueType getValue() {
		return value;
	}

}
