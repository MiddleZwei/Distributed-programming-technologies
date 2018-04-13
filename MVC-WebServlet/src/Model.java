public class Model {

    private final int _result;

    Model(int a, int b) {
        _result = a+b;
    }

    protected int getResult(){
        return _result;
    }
}