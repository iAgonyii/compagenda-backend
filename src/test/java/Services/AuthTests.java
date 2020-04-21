package Services;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import rest.AuthRest;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthTests {
    AuthRest rest = new AuthRest();

//    @Test
//    public void a_GetToken() {
//        String token;
//        token = rest.issueToken("test");
//        assertEquals("Cock", token);
//    }
}
