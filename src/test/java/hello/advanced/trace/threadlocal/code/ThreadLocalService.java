package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    /*
    *   기존의 FieldService와 거의 같은 코드인데, nameStore 필드가 일반 String 타입에서 ThreadLocal을 사용하도록 변경되었다.
    *
    *   ThreadLocal 사용법
    *   값 저장: ThreadLocal.set(xxx)
    *   값 조회: ThreadLocal.get()
    *   값 제거: ThreadLocal.remove()
    *
    *   *주의*
    *   해당 쓰레드가 쓰레드 로컬을 모두 사용하고 나면 ThreadLocal.remove() 를 호출해서 쓰레드 로컬에 저장된 값을 제거해주어야 한다.
    *
    * */
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000); // 1초간 일이 발생한담에
        log.info("조회 nameStore={}", nameStore.get()); //저장한 네임스토어를 조회
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


