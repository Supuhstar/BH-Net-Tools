package org.bh.tools.net.msg;



/**
 * MessagePiece, made for BH Message Service, is copyright Blue Husky Programming ©2015 GPLv3 <hr/>
 * Represents a piece of a message.
 *
 * @param <TextType> The type of text that this message piece can be converted into
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * - 2015-09-22 (1.0.0) - Kyli created MessagePiece
 * @since 2015-09-22
 */
public interface MessagePiece<TextType extends CharSequence> extends CharSequence {

	/**
	 * Converts this message piece into a character sequence that can be sent as data.
	 *
	 * @return this message piece, as a character sequence that can be sent as data.
	 */
	public TextType convertToText();

	/**
	 * Converts this message piece into a byte sequence that can be sent as data.
	 *
	 * @return this message piece, as a byte sequence that can be sent as data.
	 */
	public byte[] convertToBytes();

	/**
	 * Required for {@link CharSequence} compliance.
	 *
	 * @deprecated Use of this is discouraged, as it may be performance-intensive, and a message piece should not be
	 * thought of as a string with distinctive characters.
	 */
	@Override
	public default char charAt(int index) {
		return convertToText().charAt(index);
	}

	/**
	 * Required for {@link CharSequence} compliance.
	 *
	 * @deprecated Use of this is discouraged, as it may be performance-intensive, and a message piece should not be
	 * thought of as a string with distinctive segments.
	 */
	@Override
	public default CharSequence subSequence(int start, int end) {
		return convertToText().subSequence(start, end);
	}

	/**
	 * Indicates the size of this header, in <strong>Bytes</strong>. This value may or
	 * may not be the same as that of {@link #length() length()}. If the size of this message is longer than can be
	 * represented by a signed 32-bit integer, this method should be used, instead of {@link #length() length()}, which
	 * would return a negative number.
	 *
	 * @return the size of this header, in <strong>Bytes</strong>
	 */
	public abstract long size();

	/**
	 * Indicates the length of the text representation of this header, in <strong>characters</strong>. This value may or
	 * may not be the same as that of {@link #size() size()}. If the length of this message is longer than can be
	 * represented by a signed 32-bit integer, a negative number should be returned, and {@link #size() size()} should
	 * be used, instead.
	 *
	 * @return the length of the text representation of this header, in <strong>characters</strong>
	 */
	@Override
	public abstract int length();
}
