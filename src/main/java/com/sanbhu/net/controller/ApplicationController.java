package com.sanbhu.net.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.sanbhu.net.bo.LinkParam;
import com.sanbhu.net.utils.AESEncryptDecrypt;

@Controller
public class ApplicationController {

	@Autowired
	private AESEncryptDecrypt aesEncryptDecrypt;

	@Value("${aes.secret}")
	private String aesSecret;

	@RequestMapping({ "/", "/decryptData" })
	public String showEncryptPage(@RequestParam(value = "encryptData", defaultValue = "") final String encryptData,
			final HttpServletRequest request) {
		if (encryptData != null && !encryptData.equals("")) {
			String plainData = aesEncryptDecrypt.decrypt(encryptData, aesSecret);
			request.setAttribute("plainData", plainData);
		}
		return "decrypt/index";
	}

	@RequestMapping("/encryptData")
	public String encryptData(@RequestParam(value = "plainData", defaultValue = "") final String plainData,
			final HttpServletRequest request) {
		if (plainData != null && !plainData.equals("")) {
			String encryptedData = aesEncryptDecrypt.encrypt(plainData, aesSecret);
			request.setAttribute("encryptedData", encryptedData);
		}
		return "encrypt/index";
	}

	@RequestMapping("/showLinkValidation")
	public String showLinkValidation(final HttpServletRequest request) {
		LinkParam linkParam = createLink();
		Gson gsonObj = new Gson();
		String linkParamString = gsonObj.toJson(linkParam);
		String encryptedData = aesEncryptDecrypt.encrypt(linkParamString, aesSecret);
		encryptedData = aesEncryptDecrypt.encryptWithBase64(encryptedData);
		String encryptedLink = "/validateEncryptedLink?encData=" + encryptedData;
		request.setAttribute("encryptedLink", encryptedLink);
		return "validate/index";
	}

	@RequestMapping("/validateEncryptedLink")
	public String validateLink(@RequestParam(value = "encData", defaultValue = "") String encData,
			final HttpServletRequest request) {
		encData = aesEncryptDecrypt.decryptWithBase64(encData);
		String plainData = aesEncryptDecrypt.decrypt(encData, aesSecret);
		Gson gsonObj = new Gson();
		Calendar calendar = Calendar.getInstance();
		LinkParam linkParam = gsonObj.fromJson(plainData, LinkParam.class);
		Date linkExpiryTime = linkParam.getLinkExpiryTime();
		long diff = linkExpiryTime.getTime() - calendar.getTime().getTime();
		long diffSeconds = diff / 1000 % 60;
		if (diffSeconds > 0) {
			request.setAttribute("isLinkExpired", false);
		} else {
			request.setAttribute("isLinkExpired", true);
		}
		return "validate/result";
	}

	private LinkParam createLink() {
		LinkParam linkParam = new LinkParam();
		Calendar calendar = Calendar.getInstance();
		linkParam.setUserName("bhushanp");
		linkParam.setEmailAddress("bhushanp@xpanxion.co.in");
		linkParam.setLinkCreatedTime(calendar.getTime());
		calendar.add(Calendar.SECOND, 10);
		linkParam.setLinkExpiryTime(calendar.getTime());
		return linkParam;
	}

}
