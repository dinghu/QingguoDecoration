package com.qing.guo.decoration;

import java.io.UnsupportedEncodingException;

/**
 * Hex
 * 
 * @author espritblock http://eblock.io
 *
 */
public class Hex {

		public static final String DEFAULT_CHARSET_NAME = "UTF-8";
		private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		private static final char[] DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


		public static char[] encodeHex(byte[] data) {
			return encodeHex(data, true);
		}

		public static char[] encodeHex(byte[] data, boolean toLowerCase) {
			return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
		}

		protected static char[] encodeHex(byte[] data, char[] toDigits) {
			int l = data.length;
			char[] out = new char[l << 1];
			int i = 0;

			for(int var5 = 0; i < l; ++i) {
				out[var5++] = toDigits[(240 & data[i]) >>> 4];
				out[var5++] = toDigits[15 & data[i]];
			}

			return out;
		}


}
