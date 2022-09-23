package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void excute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        //log.info("비즈니스 로직1 실행"); // <- 이 부분만 해결하면 된다.
        call(); // 상속으로 해결할 수 있다. 자식클래스에 따라서 이 부분이 바뀐다.
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
