package codeping.flex.stock.global.common.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonPropertyOrder({"content", "hasNext", "isFirst", "isLast"})
public class SliceResponse<T> implements Serializable {
    private List<T> content;
    private boolean hasNext;
    private boolean isFirst;
    private boolean isLast;

    @Builder
    private SliceResponse(List<T> content, boolean hasNext, boolean isFirst, boolean isLast) {
        this.content = content != null ? new ArrayList<>(content) : new ArrayList<>();
        this.hasNext = hasNext;
        this.isFirst = isFirst;
        this.isLast = isLast;
    }

    public static <T> SliceResponse<T> of(List<T> contents, boolean hasNext, boolean isFirst, boolean isLast) {
        return SliceResponse.<T>builder()
                .content(contents)
                .hasNext(hasNext)
                .isFirst(isFirst)
                .isLast(isLast)
                .build();
    }
}