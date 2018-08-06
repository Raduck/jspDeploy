package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_Test {
	private Logger loggr = LoggerFactory.getLogger(KISA_SHA256_Test.class);
	
	
	/**
	* Method : encryptTest
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : sha256 hash 암호화 테스트
	*/
	@Test
	public void encryptTest() {
		/***Given***/
		String plainText = "1234";
		String plainText2 = "12345";
		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		String encryptText2
		= KISA_SHA256.encrypt(plainText);
		loggr.debug("encryptText : "+encryptText);
		loggr.debug("encryptText : "+encryptText2);
		/***Then***/
		assertEquals("3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4",
				encryptText);
	}

}
