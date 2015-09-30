package org.bh.tools.net.msg;

import org.bh.tools.net.msg.Field;



/**
 * Footer, made for BH Message Service, is copyright Blue Husky Programming ©2015 GPLv3 <hr/>
 *
 * The footer of something you can transmit, containing any meta data that must be appended to the end of a message.
 *
 * @param <BaseFieldType> The base type of field that this footer contains
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * - 2015-09-26 (1.0.0) - Kyli created Header
 * @since 2015-09-26
 */
@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Footer<BaseFieldType extends Field<Object, CharSequence>> extends FieldedSection<BaseFieldType> {

	/**
	 * A completely empty extension of {@link Footer}, this is recommended for use instead of actually using a
	 * {@code null} body in a {@link Transmittable}, as it avoids {@link NullPointerException}s and shortcuts all the
	 * calculations {@link Footer} does when you give it zero fields.
	 */
	public static class NullFooter extends Footer<Field<Object, CharSequence>> {

		public NullFooter() {
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
