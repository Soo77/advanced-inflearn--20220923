package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");
        TraceStatus status4 = trace.begin("hello4");
        TraceStatus status5 = trace.begin("hello5");
        TraceStatus status6 = trace.begin("hello6");
        TraceStatus status7 = trace.begin("hello7");
        TraceStatus status8 = trace.begin("hello8");

        trace.end(status8);
        trace.end(status7);
        trace.end(status6);
        trace.end(status5);
        trace.end(status4);
        trace.end(status3);
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");
        TraceStatus status4 = trace.begin("hello4");
        TraceStatus status5 = trace.begin("hello5");
        TraceStatus status6 = trace.begin("hello6");
        TraceStatus status7 = trace.begin("hello7");
        TraceStatus status8 = trace.begin("hello8");

        trace.exception(status8, new IllegalStateException());
        trace.exception(status7, new IllegalStateException());
        trace.exception(status6, new IllegalStateException());
        trace.exception(status5, new IllegalStateException());
        trace.exception(status4, new IllegalStateException());
        trace.exception(status3, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}