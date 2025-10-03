public class I18NManager {
    private static I18NManager instance;
    // [data]
    private I18NManager() {
        //data= new ..
    }
    public static I18NManager getInstance(){
        if (instance==null) instance=new I18NManager();
        return instance;
    }
    // mètodes NO-ESTÀTICS
}
