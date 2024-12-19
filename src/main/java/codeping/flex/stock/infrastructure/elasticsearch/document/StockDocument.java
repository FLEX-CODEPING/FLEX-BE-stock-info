package codeping.flex.stock.infrastructure.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "stock", writeTypeHint = WriteTypeHint.FALSE)
@Setting(settingPath = "elastic/stock-setting.json")
@Mapping(mappingPath = "elastic/stock-mapping.json")
public class StockDocument {

    @Id
    @Field(type = FieldType.Text)
    private String stockcode;

    @Field(type = FieldType.Text, name = "stockcode", analyzer = "my-nori-analyzer")
    private String stockcodeText;

    @JsonProperty("corp_name")
    @Field(type = FieldType.Text, name = "corp_name", analyzer = "my-nori-analyzer")
    private String stockName;

    @Field(type = FieldType.Text, analyzer = "my-nori-analyzer")
    private String market;

    @Builder
    public StockDocument(String stockcode, String stockName, String market) {
        this.stockcode = stockcode;
        this.stockName = stockName;
        this.market = market;
        this.stockcodeText = stockcode;
    }

}