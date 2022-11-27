package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;

@Slf4j
public class ContextV2Test {

    /*
    * 전략 패턴 적용
    * */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());

        /*
         * Context와 Strategy를 선 조립 후 실행 하는 방식이 아니라 Context를 실행할 때 마다 전략을 인수로 전달한다.
         * 클라이언트는 Context를 실행하는 시점에 원하는 Strategy를 전달할 수 있다. 따라서 이전 방식과 비교해서 원하는 전략을 더욱
         * 유연하게 변경할 수 있다.
         * 테스트 코드를 보면 하나의 Context만 생성한다. 그리고 하나의 Context에 실행 시점에 여러 전략을 인수로 전달해서 유연하게
         * 실행하는 것을 확인할 수 있다.
         *
         * */
    }

    /*
     * 전략 패턴 익명 내부 클래스
     * */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context.execute(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /*
     * 전략 패턴 익명 내부 클래스2, 람다
     * */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }


    /*
    * 정리
    * ContextV1은 필드에 Strategy를 저장하는 방식으로 전략 패턴을 구사했다.
    *  - 선 조립, 후 실행 방법에 적합하다.
    *  - Context를 실행하는 시점에는 이미 조립이 끝났기 때문에 전략을 신경쓰지 않고 단순히 실행만 하면 된다.
    * ContextV2는 파라미터에 Strategy 를 전달받는 방식으로 전략 패턴을 구사했다.
    *  - 실행할 때마다 전략을 유연하게 변경할 수 있다.
    *  - 단점 역시 실행할 때마다 전략을 계쏙 지정해주어야 한다는 점이다.
    *
    * 템플릿
    * 우리가 해결하고 싶은 문제는 변하는 부분과 변하지 않는 부분을 분리하는 것이다.
    * 변하지 않는 부분을 템플릿이라고 하고, 그 템플릿 안에서 변하는 부분에 약간 다른 코드 조각을 넘겨서 실행하는 것이 목적이다.
    * ContextV1, ContextV2 두 가지 방식 다 문제를 해결할 수 있지만, 어떤 방식이 조금 더 나아 보이는가?
    * 우리가 원하는 것은 에플리케이션 의존 관계를 설정하는 것 처럼 선 조립, 후 실행이 아니다. 단순히 코드를 실행할 때 변하지 않는
    * 템플릿이 있고, 그 템플릿 안에서 원하는 부분만 살짝 다른 코드를 실행하고 싶을 뿐이다.
    * 따라서 우리가 고민하는 문제는 실행 시점에 유연하게 실행 코드 조각을 전달하는 ContextV2가 더 적합하다.
    * *
    *
    * 다음에 할것은..
    * 템플릿 콜백패턴
    *
    *
    * */


}

