package apiModels;

import java.util.Objects;

public class PostResponseModel {
    private String status;
    private Data data ;
    private String message;

    public PostResponseModel() {
    }

    public PostResponseModel(String status, Data data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PostResponseModel{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostResponseModel)) return false;
        PostResponseModel that = (PostResponseModel) o;
        return Objects.equals(status, that.status) && Objects.equals(data, that.data) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data, message);
    }


}
