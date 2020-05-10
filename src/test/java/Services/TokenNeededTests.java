package Services;

import io.jsonwebtoken.Claims;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import rest.TokenNeededFilter;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TokenNeededTests {

    TokenNeededFilter filter = new TokenNeededFilter();

    @Test
    public void a_validateToken() {
        boolean validated;
        Claims claims = null;
        Claims claim = null;

        try {
            claim = filter.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDb21wQWdlbmRhIiwic3ViIjoiMzIwMSIsImlhdCI6MTU4ODc1MDQ4MCwiZXhwIjo0NjIyNDcwNDIyfQ.KHQlJ-BaSNeZQrnExK_z_yaI-NJmD5FaiTYkY66Ivps");
            validated = true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            validated = false;
        }

        assertEquals(claim, claims);
    }
}
