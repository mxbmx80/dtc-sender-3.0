package mx.bmx.dtc.dtc_sender.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseMessage<T> {
    private boolean success;
    private String message;
        private T data;
    private final long timestamp;

    public ResponseMessage(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    // Static factory method - ok
    public static <T> ResponseMessage<T> ok(T data) {
        return of(true, null, data);
    }

    // Static factory method - error (message only)
    public static <T> ResponseMessage<T> error(String message) {
        return error(message, null);
    }

    // Static factory method - error (message and data)
    public static <T> ResponseMessage<T> error(String message, T data) {
        return of(false, message, data);
    }

    // Static factory method - of (general purpose)
    public static <T> ResponseMessage<T> of(boolean success, String message, T data) {
        return new ResponseMessage<>(success, message, data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseMessage<?> that = (ResponseMessage<?>) o;
        return success == that.success &&
                timestamp == that.timestamp &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, message, data, timestamp);
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
