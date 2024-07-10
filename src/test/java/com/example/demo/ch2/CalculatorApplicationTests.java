package com.example.demo.ch2;


import com.example.demo.ch2._classFile.Calculator;
import com.example.demo.ch2._interfaceFile.Operation;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.context.junit4.SpringRunner;


// 통합 테스트

@RunWith(SpringRunner.class)
//@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTests {

    // 생성자 주입.
    @Autowired
    private Calculator calculator;


    // 에외가 발생하면 성공.
    @Test(expected = IllegalArgumentException.class)
    public void doingDivisionShouldFall(){
        calculator.calculate(12,13,'/');
    }


    /**
     *  Junit의 OutputCapture를 사용해 결과를 콘솔에 출력 할 수 있다.
     *  2.2.x부터는 위의 OutputCapture가 사용 불가 한다.
     *
     */
    //    public CapturedOutput capturedOutput;

    @Rule
    public OutputCaptureRule outputcapture = new OutputCaptureRule();


    @Test
    public void doingMultiplicationShouldSucceed(){
        calculator.calculate(12,13,'*');
        Assertions.assertThat(outputcapture).contains("12 * 13 = 156");
    }


    @Test(expected = IllegalArgumentException.class)
    public void doingDivisionShouldFail(){
        calculator.calculate(12,13,'/');
    }

    // Mock객체와 스프링 부트의 통합 테스트

//
//    @MockBean
//    private Calculator calculator;
//
//    @MockBean(name = "addition")
//    private Operation mockOperation;
//
//    @MockBean(name = "division")
//    private Operation mockOperation;



}
