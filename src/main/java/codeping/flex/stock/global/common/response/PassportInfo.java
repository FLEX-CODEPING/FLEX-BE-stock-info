package codeping.flex.stock.global.common.response;

public record PassportInfo(
    Long userId,
    String email,
    String role,
    String profileImage
) {

}