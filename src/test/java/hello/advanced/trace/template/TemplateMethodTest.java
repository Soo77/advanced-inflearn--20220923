package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/*
*   변하는 부분: 비즈니스 로직
*   변하지 않는 부분: 시간 측정
*
*   이제 템플릿 메서드 패턴을 사용해서 변하는 부분과 변하지 않는 부분을 분리해보자.
*
* */

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /*
    *  템플릿 메서드 패턴 적용
    * */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.excute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.excute();
    }

    /*
    * 'template1.excute()' 를 호출하면 템플릿 로직인 'AbstractTemplate.execute()'를 실행한다. 여기서 중간에 'call()'메서드를
    * 호출하는데, 이 부분이 오버라이딩 되어있다. 따라서 현재 인스턴스인 'SubClassLogic1' 인스턴스의 'SubClassLogic2.call()'메서드가 호출된다.
    *
    * 템플릿 메서드 패턴은 이렇게 다형성을 사용해서 변하는 부분과 변하지 않는 부분을 분리하는 방법이다.
    *
    * */


    /*
    * "익명 내부 클래스 사용하기"
    * 템플릿 메서드 패턴은 'SubClassLogic1', 'SubClassLogic2' 처럼 클래스를 계속 만들어야하는 단점이 있다. 익명 내부 클래스를
    * 사용하면 이런 단점을 보완할 수 있다.
    * 익명 내부 클래스를 사용하면 객체 인스턴스를 생성하면서 동시에 생성할 클래스를 상속받은 자식 클래스를 정의할 수 있다.
    * 'SubClassLogic1'처럼 직접 지정하는 이름이 없고 클래스 내부에 선언되는 클래스여서 익명 내부 클래스라 한다.
    * 익명 내부 클래스에 대한 자세한 내용은 자바 기본 문법을 참고하자.
    *
    * */

}
