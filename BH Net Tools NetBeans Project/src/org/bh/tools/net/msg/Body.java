package org.bh.tools.net.msg;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;



/**
 * Body, made for BH Message Service, is copyright Blue Husky Programming ©2015 GPLv3 <hr/>
 *
 * The body of something you can transmit.
 *
 * @param <TextType> The type of text this can be converted to.
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * - 2015-09-25 (1.0.0) - Kyli created IMBody
 * @since 2015-09-25
 */
public class Body<TextType extends CharSequence> implements MessagePiece<TextType> {

	/**
	 * This is recommended for use instead of actually using a {@code null} body in a {@link Transmittable}.
	 */
	public static final NullBody NULL = new NullBody();

	/**
	 * The most Unicodiest charset we could find.
	 */
	private static final Charset UNICODIEST_CHARSET;

	static {
		Charset c;
		try {
			c = Charset.forName("UTF-16");
		}
		catch (IllegalCharsetNameException | UnsupportedCharsetException ex1) {

			try {
				c = Charset.forName("UTF-8");
			}
			catch (IllegalCharsetNameException | UnsupportedCharsetException ex2) {

				try {
					c = Charset.forName("Unicode");
				}
				catch (IllegalCharsetNameException | UnsupportedCharsetException ex3) {
					c = Charset.defaultCharset();
				}
			}
		}
		UNICODIEST_CHARSET = c;
	}

	/**
	 * The text contained within this body section.
	 */
	protected TextType text;

	public Body(TextType initText) {
		text = initText;
	}

	@Override
	public TextType convertToText() {
		return text;
	}

	@Override
	public byte[] convertToBytes() {
		return text == null ? new byte[0] : text.toString().getBytes(UNICODIEST_CHARSET);
	}

	/**
	 * @deprecated Simply returns the length of the array returned by {@link #convertToBytes() convertToBytes()}. It's
	 * recommended you cache the result of that method and read its length, instead.
	 */
	@Override
	public long size() {
		return convertToBytes().length;
	}

	/**
	 * @deprecated Simply returns the length of the text returned by {@link #convertToText() convertToText()}. It's
	 * recommended you cache the result of that method and read its length, instead.
	 */
	@Override
	public int length() {
		return convertToText().length();
	}



	/**
	 * A completely empty extension of {@link Body}, this is recommended for use instead of actually using a
	 * {@code null} body in a {@link Transmittable}, as it avoids {@link NullPointerException}s and shortcuts all the
	 * calculations {@link Body} does when you give it {@code null} text.
	 */
	public static class NullBody extends Body<CharSequence> {

		public NullBody() {
			super(null);
		}

		/**
		 * Returns {@code null}
		 *
		 * @return {@code null}
		 */
		@Override
		public CharSequence convertToText() {
			return null;
		}

		/**
		 * Returns a byte array with a {@code length} of {@code 0}.
		 *
		 * @return a byte array with a {@code length} of {@code 0}.
		 */
		@Override
		public byte[] convertToBytes() {
			return new byte[0];
		}

		/**
		 * Returns {@code 0L}.
		 *
		 * @return {@code 0L}
		 */
		@Override
		public long size() {
			return 0L;
		}

		/**
		 * Returns {@code 0}.
		 *
		 * @return {@code 0}
		 */
		@Override
		public int length() {
			return 0;
		}
	}

}
