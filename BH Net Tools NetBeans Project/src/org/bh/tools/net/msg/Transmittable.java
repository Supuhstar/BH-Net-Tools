package org.bh.tools.net.msg;



/**
 * Transmittable, made for BH Message Service, is copyright Blue Husky Programming ©2015 GPLv3 <hr/>
 *
 * @param <HeaderType> The type of header
 * @param <BodyType>   The type of body content
 * @param <FooterType> The type of footer
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * - 2015-09-22 (1.0.0) - Kyli created Transmittable
 * @since 2015-09-22
 */
@SuppressWarnings({"MarkerInterface", "rawtypes"})
public interface Transmittable<HeaderType extends Header, BodyType extends Body, FooterType extends Footer>
		extends MessagePiece<CharSequence> {
	public HeaderType getHeader();

	public BodyType getBody();

	public FooterType getFooter();

	public void setHeader(HeaderType newHeader);

	public void setBody(BodyType newBody);

	public void getFooter(FooterType newFooter);
}
