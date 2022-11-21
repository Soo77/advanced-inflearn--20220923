package hello.advanced.trace.strategy.code.strategy;

/*
* 전략 패턴-예제1
* 템플릿 메서드 패턴은 부모 클래스에 변하지 않는 템플릿을 두고, 변하는 부분을 자식 클래스에 둬서 상속을 사용해서 문제 해결
* 전략 패턴은? 변하지 않는 부분을 Context 라는 곳에 두고 변하는 부분을 Strategy라는 인터페이스를 만들고
* 해당 인터페이스를 변하는 곳에서 구현해서 문제 해결.(상속이 아닌 위임으로 해결)
* 전략 패턴에서 Context는 변하지 않는 템플릿 역할, Strategy는 변하는 알고리즘 역할
*
* */

public interface Strategy {
    void call();
}
