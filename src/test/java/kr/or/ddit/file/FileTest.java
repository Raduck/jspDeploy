package kr.or.ddit.file;

import static org.junit.Assert.*;
import kr.or.ddit.calculator.Calculator;

import org.junit.Before;
import org.junit.Test;

public class FileTest {
	private FileUtil futil;
	
	@Before
	public void setUp() {
		futil = new FileUtil();
		
	}
	@Test
	public void getFileName() {
		/***Given***/
		//String test = "form-data; name=\"uploadFile\"; filename=\"sally.png\"";
		String test = "form-data; name=\"uploadFile\"; filename=\"james.png\"";

		/***When***/
		String result = futil.getFileName(test);
		/***Then***/
		//assertEquals("sally.png", result);
		assertEquals("james.png", result);

	}
	
	
	
}
