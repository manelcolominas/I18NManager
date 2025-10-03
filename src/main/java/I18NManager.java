import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18NManager {
    private static I18NManager instance;
    private static HashMap<String, ResourceBundle> cache = new HashMap<>(); // creem un diccionari

    private I18NManager() {

    }

    static I18NManager getInstance() { // es fa referencia a ell mateix si la instancia I18NManager esta buida crea una de nova i la retorna
        if (instance == null) {
            instance = new I18NManager();
        }
        return instance;
    }

    public static String getText(String language, String key) {
        ResourceBundle bundle = cache.get(language); // busca la llengua dintre de la cache i ho guarda dintre del bundle
        if (bundle == null) { // si el bundle està buit
            System.out.println("NO EL TINC. VAIG A BUSCAR-HO A LA CACHE");
            Locale locale = new Locale(language);
            bundle = ResourceBundle.getBundle(language, locale); // No sé que fa aquesta linea ben bé
            // ResourceBundle és una classe de Java que serveix per carregar fitxers de propietats (.properties)
            cache.put(language, bundle); // afegeix aquesta llengua a la cache
        }

        else {
            System.out.println("EL TINC A LA CACHE");
        }

        return bundle.getString(key);
    }

    public void clear() {
        cache.clear();
    }
}
