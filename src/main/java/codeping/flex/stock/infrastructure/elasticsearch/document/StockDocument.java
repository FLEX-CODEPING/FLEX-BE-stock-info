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
    private String id;

    @Field(type = FieldType.Text, name = "stockcode", analyzer = "my-nori-analyzer")
    private String stockcode;

    @JsonProperty("corp_name")
    @Field(type = FieldType.Text, name = "corp_name", analyzer = "my-nori-analyzer")
    private String corpName;

    @Field(type = FieldType.Text, analyzer = "my-nori-analyzer")
    private String market;

    @Builder
    public StockDocument(String stockcode, String corpName, String market) {
        this.id = stockcode;
        this.corpName = corpName;
        this.market = market;
        this.stockcode = stockcode;
    }

}