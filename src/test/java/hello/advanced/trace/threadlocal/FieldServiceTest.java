package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");

        /* Runnable userA = new Runnable().fieldService.logic("userA");
        *
        *  이와 같은 코드를 람다로 변환한 것임
        *  Runnable userA = new Runnable() {
        *       @Override
        *       public void run() {
        *       }
        *  }
        *
        *  자바에서 쓰레드를 구현할 때 2가지 방법이 있다고 한다.
        *  1. Runnable
        *  2. Thread
        *
        *  Runnable 인터페이스를 구현하게 되면 재사용성이 높고, 코드의
        *  일관성을 유지할 수 있어서 Thread보다 더 효율적인 방법.
        *  그리고 추상메서드 run을 반드시 구현해야 한다.
        *  Thread도 run을 구현해야 한다는 점은 같지만 추상 메서드가 아니라
        *  단순 메서드 오버라이딩으로 구현한다.
        *
        *  Thread는 상속을 받아 사용해야 하기 때문에 다른 클래스를 상속받아
        *  사용할 수 없다는 단점이 있다. 따라서 일반적으로는 Runnable 인터페이스를
        *  구현해서 스레드를 사용한다.
        *  Thread 클래스 자체도 Runnable 인터페이스를 가지고 있다.
        *
        *  Thread는 상속을 받으며 Runnable은 인터페이스로서 구현한다.
        *  Thread는 재사용이 불가능하며 Runnable은 가능하다.
        *  Thread 사용시 다른 클래스를 상속받을 수 없다.
        *
        *
        *
        * */
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        // Runnable 이랑 Thread 가 이해가 안가면 JAVA 기본서적을 보셔야합니다. ㅠㅠ
        // 이해가 안간다...
        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");
        // A스레드는 userA라는 로직을 가지고 있고요. B스레드는 userB 로직을
        // 실행을 하게 됩니다.

        threadA.start();
        //sleep(2000); // 2초 쉬고 실행하니까 동시성 문제가 아예 발생 안하는 코드
        sleep(100); // 슬립을 짧게주면 동시성 문제가 발생한다. 첫번째 것이 끝나는데 1초걸리는데 100은 0.1초다. 두번째가 첫번째 안끝났는데 들어간다.
        threadB.start();

        sleep(3000); // 3초 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    /*
    *
    *   동시성 문제
    *   결과적으로.. Thread-A 입장에서는 저장한 데이터와 조회한 데이터가 다른 문제가 발생한다. 이처럼 여러 쓰레드가 동시에 같은 인스턴스의 필드 값을
    *   변경하면서 발생하는 문제를 동시성 문제라 한다. 이런 동시성 문제는 여러 쓰레드가같은 인스턴스의 필드에 접근해야 하기 때문에 트래픽이 적은 상황에서는
    *   확율상 잘 나타나지 않고, 트래픽이 많아질수록 자주 발생한다.
    *   특히 스프링 빈처럼 싱글톤 객체의 필드를 변경하며 사용할 때 이러한 동시성 문제를 조심해야한다.
    *
    *
    *   이럴때 사용하는 것이 ThreadLocal!
    *   쓰레드 로컬은 해당 쓰레드만 접근할 수 있는 특별한 저장소를 말한다. 쉽게 이야기해서 물건 보관 창구를 떠올리면 된다. 여러 사람이 같은 물건 보관 창구를 사용하더라도
    *   창구 직원은 사용자를 인식해서 사용자별로 확실하게 물건을 부군해준다.
    *   사용자A, 사용자B 모두 창구 직원을 통해서 물건을 보관하고, 꺼내지만 창구 직원이 사용자에 따라 보관한 물건을 구분해주는 것이다.
    *
    *   쓰레드로컬을 사용하면 각 쓰레드마다 별도의 내부 저장소를 제공한다. 따라서 같은 인스턴스의 쓰레드 로컬 필드에 접근해도 문제없다.
    *   thread-A가 userA라는 값을 저장하면 쓰레드 로컬은 thread-A 전용 보관소에 데이터를 안전하게 보관한다.
    *   thread-B가 userB라는 값을 저장하면 쓰레드 로컬은 thread-B 전용 보관소에 데이터를 안전하게 보관한다.
    *
    *   쓰레드 로컬을 통해서 데이터를 조회할 때도 thread-A가 조회하면 쓰레드 로컬은 thread-A 전용 보관소에서 userA 데이터를 반환해준다. 물론 thread-B를 조회하면
    *   thread-B 전용 보관소에서 userB 데이터를 반환해준다.
    *
    *   자바는 언어차원에서 쓰레드 로컬을 지원하기 위한 java.lang.ThreadLocal 클래스를 제공한다.
    *
    * */

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
