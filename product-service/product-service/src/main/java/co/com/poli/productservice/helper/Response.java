package co.com.poli.productservice.helper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer code;
    private Object data;
}
