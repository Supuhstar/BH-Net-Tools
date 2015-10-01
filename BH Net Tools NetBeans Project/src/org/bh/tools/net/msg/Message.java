package org.bh.tools.net.msg;



/**
 * Message, made for BH Net Tools, is copyright Blue Husky Programming ©2015 GPLv3 <hr/>
 *
 * A default message; a simple implementation of {@link Transmittable}. It does nothing special, and implementing your
 * own will probably be more efficient at runtime.
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * - 2015-09-29 (1.0.0) - Kyli created Message
 * @since 2015-09-29
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Message implements Transmittable<Header, Body, Footer> {

	private Header header;
	private Body body;
	private Footer footer;

	@Override
	public CharSequence convertToText() {
		MessagePiece header = getHeader(), body = getBody(), footer = getFooter();
		StringBuilder sb = new StringBuilder();
		if (header != null) {
			sb.append(header.convertToText());
		}
		if (body != null) {
			sb.append(body.convertToText());
		}
		if (footer != null) {
			sb.append(footer.convertToText());
		}
		return sb;
	}

	@Override
	public byte[] convertToBytes() {
		MessagePiece header = getHeader(), body = getBody(), footer = getFooter();
		byte[] ret = new byte[0];
		if (header != null) {
			ret = header.convertToBytes();
		}
		if (body != null) {
			byte[] bodyBytes = body.convertToBytes(),
					nextRet = new byte[ret.length + bodyBytes.length];
			System.arraycopy(ret, 0, nextRet, 0, ret.length);
			System.arraycopy(bodyBytes, 0, nextRet, ret.length - 1, bodyBytes.length);
			ret = nextRet;
		}
		if (footer != null) {
			byte[] footerBytes = footer.convertToBytes(),
					nextRet = new byte[ret.length + footerBytes.length];
			System.arraycopy(ret, 0, nextRet, 0, ret.length);
			System.arraycopy(footerBytes, 0, nextRet, ret.length - 1, footerBytes.length);
			ret = nextRet;
		}
		return ret;
	}

	@Override
	public long size() {
		MessagePiece header = getHeader(), body = getBody(), footer = getFooter();
		long totalSize = 0;
		if (header != null) {
			totalSize = header.size();
		}
		if (body != null) {
			totalSize += body.size();
		}
		if (footer != null) {
			totalSize += footer.size();
		}
		return totalSize;
	}

	@Override
	public int length() {
		MessagePiece header = getHeader(), body = getBody(), footer = getFooter();
		int length = 0;
		if (header != null) {
			length = header.length();
		}
		if (body != null) {
			length += body.length();
		}
		if (footer != null) {
			length += footer.length();
		}
		return length;
	}

	@Override
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header newHeader) {
		header = newHeader;
	}

	@Override
	public Body getBody() {
		return body;
	}

	public void setBody(Body newBody) {
		body = newBody;
	}

	@Override
	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer newFooter) {
		footer = newFooter;
	}
}
