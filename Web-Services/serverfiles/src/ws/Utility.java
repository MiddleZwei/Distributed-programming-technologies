package ws;

import java.util.HashMap;
import java.util.Map;

public class Utility {


    Map<String, State> state_map;

    Utility() {
        state_map = new HashMap<String, State>();
    }

    void loadData(){

        State rajasthan=new State("Rajasthan","Jaipur",33,"Hindi, Rajasthani","Jaipur, Jodhpur, Udaipur","Ajmer, Udaipur, Jaipur","Rajasthan is famous for its marbles");
        State punjab=new State("Punjab","Chandigarh",22,"Hindi, Punjabi","Amritsar","Amritsar, Ludhiana","Punjab is popular for its joyful punjabi people");
        State mp=new State("Madhya Pradesh","Bhopal",51 ,"Hindi","Bhopal, Gwalior","Bhopal, Gwalior","Madhya Pradesh is well known for its wildlife and monuments");
        State haryana=new State("Haryana","Chandigarh",21 ,"Hindi, Haryanvi","","Hisar, Rohtak, Fridabad","Haryana is popular for its haryanvi language");
        State gujrat=new State("Gujrat","Gandhinagar",33 ,"Hindi, Gujrati","Ahmedabad, Vadodara, Gandhinagar","Ahmedabad, Vadodara","Gujrat is famous for its rich culture and dandiya nights");

        state_map.put("Rajasthan", rajasthan);
        state_map.put("Punjab", punjab);
        state_map.put("Madhya Pradesh", mp);
        state_map.put("Haryana", haryana);
        state_map.put("Gujrat", gujrat);

    }

    State getState(String stateName) {
        State state = null;
        state = state_map.get(stateName);
        return state;
    }

}
