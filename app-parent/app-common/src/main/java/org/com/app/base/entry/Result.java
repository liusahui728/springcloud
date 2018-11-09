package org.com.app.base.entry;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author guoj
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 1;

    public static final int FAIL = 0;

    private T data;

    private String msg = "success";

    private int code = SUCCESS;

    public static class utils {
        public static Result setSuccess() {
            return new Result();
        }

        public static <T> Result setSuccessResult(T data) {
            return new Result().setData(data);
        }

        public static Result setFail() {
            return new Result().setCode(FAIL).setMsg("fail");
        }

        public static <T> Result setFailResult(String msg) {
            return new Result().setCode(FAIL).setMsg(msg);
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(Result.utils.setSuccess()));
        System.out.println(JSON.toJSONString(Result.utils.setSuccessResult(123)));
        System.out.println(JSON.toJSONString(Result.utils.setFail()));
        System.out.println(JSON.toJSONString(Result.utils.setFailResult("123")));
    }
}
