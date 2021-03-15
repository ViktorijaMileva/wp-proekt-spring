package mk.finki.ukim.wpproekt.authService.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mk.finki.ukim.wpproekt.authService.JwtService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    private final String SECRET_KEY = "yht4M00CGdRhuyZEZ7-X52FSqegWh9Fvpgk4GmLMAPSjZx_vaXydrzb-Tte4ZFid4lS6lFkPuErJaXTCrW___zA-jWFQtPY5fFxBSWEEa1MDlju190mdBjUCRa_vDTHc-GlU49DStIVQziGyZ6iFT_6qNQgue3BX-7wlmlDgKxM";

    @Override
    public Date extractDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /*@Override
    public String extractRole(String token) {
        return extractClaim(token, Claims::getIssuer);
    }*/

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return extractDate(token).before(new Date());
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    @Override
    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
