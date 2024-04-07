package Execute;

import java.nio.charset.StandardCharsets;

public class CharChange {
    public String UTF_to_ISO(String x){
        return new String(x.getBytes(StandardCharsets.UTF_8) , StandardCharsets.ISO_8859_1);
    }
    public String ISO_to_UTF(String x){
        return new String(x.getBytes(StandardCharsets.ISO_8859_1) , StandardCharsets.UTF_8);
    }
}
