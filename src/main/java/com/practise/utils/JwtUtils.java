package com.practise.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET = "mySuperSecretKeyForJwtThatIsAtLeast32BytesLong!";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    // 過期時間：12小時（毫秒）
    private static final long EXPIRATION_MILLIS = 12 * 60 * 60 * 1000;

    /**
     * 生成JWT令牌，過期時間固定12小時
     * @param claims 自定義的資料放在這裡
     * @return 生成的JWT字串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析JWT令牌，回傳Claims內容
     * @param token JWT字串
     * @return Claims自訂資料
     * @throws JwtException 解析失敗或令牌過期會丟出例外
     */
    public static Claims parseToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
