public class Logic {

    private Model _model;
    public Logic(int param1, int param2) {
        _model = new Model(param1, param2);
    }
    protected Model getModel(){
        return this._model;
    }
}