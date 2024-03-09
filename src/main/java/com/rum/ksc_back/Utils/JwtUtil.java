package com.rum.ksc_back.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rum.ksc_back.domain.Ron.KSCUser;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JwtUtil {
    private final String issuer="w";
    public static ZonedDateTime getNow() {
        return ZonedDateTime.now();
    }

    public static String getJwt(KSCUser user) {
        Date Expiration = Date.valueOf(getNow().plusDays(1).toLocalDate());
        return
                JWT.create()
                        .withClaim("userName", user.getUserName())
                        .withExpiresAt(Expiration)
                        .withIssuer("w")
                        .sign(Algorithm.HMAC256("sign"));
    }

    public static boolean chTimeEx(String token) {
        LocalDate localDate = getNow().toLocalDate();
        LocalDate n = LocalDate.ofInstant(JWT.decode(token).getExpiresAt().toInstant(), ZoneId.systemDefault());
        return localDate.isBefore(n);
    }

    public static boolean chSigner(String token) {
        String issuer = JWT.decode(token).getIssuer();
        return true;
    }
}
