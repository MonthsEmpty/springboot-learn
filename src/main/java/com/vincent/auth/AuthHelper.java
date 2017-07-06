package com.vincent.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

/**
 * Created by renwu on 2017/7/6.
 */
public class AuthHelper {

    public static String base64Security = "asdffsadfdsa";

    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser().requireIssuer("test")
                    .setSigningKey(base64Security.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String createJWT(String name, String userId, String issuer, long TTLMillis, String base64Security, String authData) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("userName", name)
                .claim("userId", userId)
                .claim("authData", authData)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, base64Security.getBytes());
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

    public static String setCookie(HttpServletResponse response, String name, String id, String issuer, long expireMillis, String secretKey, String authData) {
        String token = createJWT(name, id, issuer, expireMillis, secretKey, authData);
        Cookie cookie = new Cookie("JSESSTOKEN", token);
        response.addCookie(cookie);
        return token;
    }
}
