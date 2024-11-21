package codeping.flex.stock.global.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.util.Base64;

/**
 * PkEncoderUtil은 Long 값을 암호화 및 복호화합니다.
 * 대칭 키 암호화를 사용하며, 키는 secret 값으로부터 생성됩니다.
 * Base64 URL 인코딩 및 디코딩을 통해 암호화된 데이터를 문자열로 변환합니다.
 */
@Component
public class PkEncoderUtil {

    private final String algorithm;
    private final String secret;
    private static SecretKey secretKey;

    public PkEncoderUtil(
            @Value("${crypto.algorithm}") String algorithm,
            @Value("${crypto.secret}") String secret) {
        this.algorithm = algorithm;
        this.secret = secret;
    }

    /**
     * 초기화 메서드.
     * Spring이 빈 생성 후 호출하며, 비밀 키를 생성합니다.
     */
    @PostConstruct
    private void init() {
        this.secretKey = generateKey();
    }

    /**
     * 비밀 키 생성 메서드.
     *
     * @return SecretKey 생성된 대칭 키
     */
    private SecretKey generateKey() {
        byte[] keyBytes = secret.getBytes();
        return new SecretKeySpec(keyBytes, algorithm);
    }


    /**
     * Long 값을 암호화하여 Base64 URL-safe 문자열로 반환합니다.
     *
     * @param value 암호화할 Long 값
     * @return 암호화된 Base64 URL-safe 문자열
     */
    public String encryptValue(Long value) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] valueBytes = ByteBuffer.allocate(Long.BYTES).putLong(value).array();
            byte[] encrypted = cipher.doFinal(valueBytes);
            return encodeToBase64(encrypted);
        } catch (Exception e) {
            throw new IllegalStateException("Encryption failed", e);
        }
    }

    /**
     * Base64 URL-safe 문자열로 암호화된 값을 복호화하여 Long 값으로 반환합니다.
     *
     * @param encryptedValue 암호화된 Base64 URL-safe 문자열
     * @return 복호화된 Long 값
     */
    public Long decryptValue(String encryptedValue) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encryptedBytes = decodeFromBase64(encryptedValue);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return ByteBuffer.wrap(decryptedBytes).getLong();
        } catch (Exception e) {
            throw new IllegalStateException("Decryption failed", e);
        }
    }

    private String encodeToBase64(byte[] bytes) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private byte[] decodeFromBase64(String encoded) {
        return Base64.getUrlDecoder().decode(encoded);
    }
}