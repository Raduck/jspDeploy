package kr.or.ddit.calculator;

public class Calculator {
	
	public static void main(String[] args){
		Calculator cal = new Calculator();
		int addResult = cal.add(5, 6);
		
		if(addResult == 11)
			System.out.println("덧셈결과가 맞습니다.");
		else
			System.out.println("덧셈결과가 틀렸습니다.");
		
		int minusResult = cal.minus(6,4);
		
		if(minusResult == 2)
			System.out.println("덧셈결과가 맞습니다.");
		else
			System.out.println("덧셈결과가 틀렸습니다.");
		///////////////////////////////////////////////////////
		//mul : 곱하기, div : 나누기
		int multipleResult = cal.multiple(3, 5);
		if(multipleResult==15){
			System.out.println("곱셈결과가 맞습니다.");
		}else{
				System.out.println("곱셈결과가 틀렸습니다.");
			}
		
		int divideResult = cal.divide(15, 3);
		if(divideResult == 5)
			System.out.println("나눗셈결과가 맞습니다.");
		else
			System.out.println("나눗셈결과가 틀렸습니다.");
		
	}
	
	/**
	* Method : add
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC20
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 덧셈 기능
	*/
	public int add(int param1, int param2){
		return param1+param2;
	}
	public int minus(int param1, int param2) {
		return param1-param2;
	}
	public int multiple(int param1, int param2){
		return param1*param2;
	}
	public int divide(int param1, int param2){
		if(param2==0){
			return 0;
		}else{
			return param1/param2;
		}
		
		
	}
}
