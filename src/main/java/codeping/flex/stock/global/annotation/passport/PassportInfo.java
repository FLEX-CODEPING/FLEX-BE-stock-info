package codeping.flex.stock.global.annotation.passport;

public record PassportInfo(
    Long userId,
    String email,
    String role,
    String profileImage
) {

}