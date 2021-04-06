package com.onetopic.fp.lambda;

// functional/LambdaExpressions.java

interface Description {
    String brief();

}

interface Body {
    String detailed(String head);
    //String detailed2(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

//Lambda实现了匿名内部类的写法,比匿名内部类有更好的可读性
public class LambdaExpressions {

    static Body bod = h -> h + " No Parens!"; // [1]

    static Body bod2 = (h) -> h + " More details"; // [2]

    static Description desc = () -> "Short info"; // [3] //空参数必须加()

    static Multi mult = (h, n) -> h + n; // [4]/多参数必须加()

    static Description moreLines = () -> { // [5] //函数体中有多行的情况
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
