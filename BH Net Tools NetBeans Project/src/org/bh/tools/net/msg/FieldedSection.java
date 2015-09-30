package org.bh.tools.net.msg;

import org.bh.tools.net.msg.Field;
import org.bh.tools.util.ArrayPP;



/**
 * FieldedSection, made for BH Message Service, is copyright Blue Husky Programming ©2015 GPLv3 <hr/>
 * Represents a section comprised of fields (such as a header or footer) in a message
 *
 * @param <BaseFieldType> The base type of field of which all this section's fields are instances
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * - 2015-09-22 (1.0.0) - Kyli created Header
 * @since 2015-09-22
 */
public abstract class FieldedSection<BaseFieldType extends Field>
		implements MessagePiece<CharSequence> {

	/**
	 * The fields that comprise the header. All together, these should neatly fit into a rectangular header.
	 */
	@SuppressWarnings({"unchecked", "ProtectedField"})
	protected ArrayPP<BaseFieldType> fields = new ArrayPP<>();

	@SuppressWarnings("unchecked")
	public FieldedSection(BaseFieldType... initialFields) {
		fields.add(initialFields);
	}

	@Override
	public byte[] convertToBytes() {
		ArrayPP<Byte> ret = new ArrayPP<>();
		for (BaseFieldType headerField : fields) {
			ret.addAll(ArrayPP.wrap(headerField.convertToBytes()));
		}
		return ArrayPP.unwrap(ret.toArray());
	}

	@Override
	public CharSequence convertToText() {
		StringBuilder sb = new StringBuilder();
		for (BaseFieldType headerField : fields) {
			sb.append(headerField.convertToText());
		}
		return sb;
	}

	/**
	 * @deprecated You really ought not to think of this as text. If you want the length of the header in bytes, look
	 * to {@link #size() size()}
	 */
	@Override
	public int length() {
		return convertToText().length();
	}




}
