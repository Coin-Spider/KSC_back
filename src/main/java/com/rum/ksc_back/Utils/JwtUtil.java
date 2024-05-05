package com.rum.ksc_back.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rum.ksc_back.domain.Ron.KSCUser;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class JwtUtil {
    private final String issuer="w";
    public static ZonedDateTime getNow() {
        return ZonedDateTime.now();
    }

    public static String getJwt(KSCUser user) {
        Date Expiration =  Date.from(JwtUtil.getNow().plusHours(30).toInstant());
        return
                JWT.create()
                        .withClaim("userName", user.getUserName())
                        .withExpiresAt(Expiration)
                        .withIssuer("w")
                        .sign(Algorithm.HMAC256("sign"));
    }

    public static boolean chTimeEx(String token) {
        Instant now = getNow().toInstant();
        Instant expires = JWT.decode(token).getExpiresAt().toInstant();
        return now.isBefore(expires);
    }

    public static boolean chSigner(String token) {
        String issuer = JWT.decode(token).getIssuer();
        return true;
    }
}
