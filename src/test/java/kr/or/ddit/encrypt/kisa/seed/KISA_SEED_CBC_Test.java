package kr.or.ddit.encrypt.kisa.seed;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SEED_CBC_Test {

private Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_Test.class);
	//블록 암호화는 : 비밀번호를 제외한 개인 정보를 암호화 할때 사용
	//복호화가 가능한 암호 방식

	

	@Test
	public void encryptTest() {
		/*** Given ***/
		String planText = "1234";

		/*** When ***/
		String encryptText = KISA_SEED_CBC.Encrypt(planText);
		String decryptText = KISA_SEED_CBC.Decrypt(encryptText);
		
		logger.debug("encryptText : "+encryptText);
		logger.debug("decryptText : "+decryptText);
		/*** Then ***/
		assertEquals(planText, decryptText);
		
	}
}
