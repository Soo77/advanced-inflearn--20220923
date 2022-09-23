package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();


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
        trace.exception(status6, new IllegalStateException());
        trace.end(status5);
        trace.end(status4);
        trace.end(status3);
        trace.exception(status2, new IllegalStateException());
        trace.end(status1);

    }
}