package h;

import static h.CodeGenerator.Lang.JAVA;

/**
 * Created by a on 23.11.16.
 */
class CodeGenerator {
    public enum Lang {JAVA, C_PLUS_PLUS, PHP}

    ;

    public CodeGenerator(Lang language) {
        _language = language;
    }

    public String generateCode() throws Exception {
        switch (_language) {
            case JAVA:                                                          //return generated java code}
            case C_PLUS_PLUS:                                     //return generated C++ code}
            case PHP:                                                           //return generated PHP code}
        }
        throw new Exception("Bad language");
    }

    public String someCodeRelatedThing() throws Exception // used in generateCode()
    {
        switch (_language) {
            case JAVA:                                                          //return generated java code}
            case C_PLUS_PLUS:                                     //return generated C++ code}
            case PHP:                                                           //return generated PHP code}
        }
        throw new Exception("Bad language");

    }

    private Lang _language;
}
