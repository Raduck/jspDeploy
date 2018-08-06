package kr.or.ddit.calculator;

import static org.junit.Assert.*;
import kr.or.ddit.calculator.Calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	/*
		setUp() (@Before) 실행 --> add 테스트 메소드 실행 ----> tearDown()(@After) 실행
		setUp() (@Before) 실행 --> minus 테스트 메소드 실행 ----> tearDown()(@After) 실행
		setUp() (@Before) 실행 --> mul 테스트 메소드 실행 ----> tearDown()(@After) 실행
		setUp() (@Before) 실행 --> div 테스트 메소드 실행 ----> tearDown()(@After) 실행
		afterCalss(@afterClass)
		
		테스트 메서드 실행 순서는 보장되지 않는다.
	*/
	private Calculator cal;
	private int param1;
	private int param2;
	@Before //빈도가 낮아 잘 사용하지 않는다.
	public void setUp(){
		cal = new Calculator();
		param1 = 6;
		param2 = 5;
	}
	@After
	public void tearDown(){
		System.out.println("after");
	}
	
	
	/**
	* Method : addTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 계산기의 덧셈 기능 테스트
	*/
	@Test
	public void addTest() { //기업 마다 명명이 다르다
		/***Given***/
		
		
		/***When***/
		int addResult = cal.add(param1, param2);
		/***Then***/
		assertEquals(11, addResult);
	}
	@Test
	public void minusTest(){
		/***Given***/
		
		/***When***/
		int minusResult = cal.minus(param1, param2);
		/***Then***/
		assertEquals(1, minusResult);
	}
	
	@Test
	public void multipleTest(){
		/***Given***/
		
		/***When***/
		int multipleResult = cal.multiple(param1, param2);
		/***Then***/
		assertEquals(30, multipleResult);
	}
	
	@Test
	public void divideTest(){
		/***Given***/
		
		/***When***/
		int divideResult = cal.divide(param1, param2);
		/***Then***/
		assertEquals(1, divideResult);
	}
	
	@Test
	public void divByZeroTest(){
		/***Given***/
		param2=0;

		/***When***/
		int divResult = cal.divide(param1, param2);
		/***Then***/
		assertEquals(0, param2);
	}
}
