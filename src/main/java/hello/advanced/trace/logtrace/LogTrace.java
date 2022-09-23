package hello.advanced.trace.logtrace;


import hello.advanced.trace.TraceStatus;

/*
*   앞서 로그 추적기를 만들면서 다음 로그를 출력할 때 트랜잭션ID와 level을 동기화하는 문제가 있었다.
*   이 문제를 해결하기 위해 TraceId를 파라미터로 넘기도록 구현했다.
*   이렇게 해서 동기화는 성공했지만, 로그를 출력하는 모든 메서드에 TraceId 파라미터를 추가해야 하는
*   문제가 발생.
*   TraceId를 파라미터로 넘기지 않고 이 문제를 해결할 수 있는 방법은 없을까?
* */



public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}
