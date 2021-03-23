package com.example.costagram.utils;

// 목적 : 사용자 UX를 위한 클래스
public class Script {

	// 목적 : 사용자 UX를 위해 성공 시 알림을 만들어주고 후 경로를 지정한 함수.
	public static String href(String msg, String url) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('" + msg + "');");
		sb.append("location.href = '" + url + "';");
		sb.append("</script>");

		return sb.toString();
	}

	// 목적 : 사용자 UX를 위해 실패 시 알림을 만들어주고 후 경로를 지정한 함수.
	public static String back(String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('" + msg + "');");
		sb.append("history.back();");
		sb.append("</script>");

		return sb.toString();
	}
}
