package com.tps.web.staroffice.customer.utils;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class StarUtil {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static boolean convertToBoolean(int i) { return i > 0; }
	public static String encode(String string) {
		return DigestUtils.sha512Hex(string + "_staroffice");
	}
	public static String utf8Encode(String string) {
		try {
			string = URLEncoder.encode(string, "UTF-8");
		} catch (Exception e) {}
		return string;
	}
	public static String formatDate(Date date) {
		return sdf.format(date);
	}
}