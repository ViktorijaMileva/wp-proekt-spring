package mk.finki.ukim.wpproekt.AuthService;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    public Date extractDate(String token);

   // public String extractRole(String token);

    public String extractUsername(String token);

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    public String createToken(Map<String, Object> claims, String subject);

    public Boolean validateToken(String  token, UserDetails userDetails);

    public Claims extractAllClaims(String token);

    public Boolean isTokenExpired(String token);

    public String generateToken(UserDetails userDetails);


}
