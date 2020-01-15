package tech.yxing.phone.result;

public class CodeMsg {
    private int code;
    private String msg;

    //通用模块错误码
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");

    //用户模块错误码1
    public static CodeMsg USER_NULL = new CodeMsg(1101, "用户名不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(1102, "密码错误");
    public static CodeMsg USER_EXIST = new CodeMsg(1103, "用户名已存在");
    public static CodeMsg ADDRESS_NULL = new CodeMsg(1104, "尚未添加地址");

    //手机模块错误码2
    public static CodeMsg SEARCH_NULL = new CodeMsg(2101, "没有搜索到任何结果");

    //轮播图模块错误码3
    public static CodeMsg BANNER_NULL = new CodeMsg(3101, "目前还没添加轮播图");

    //订单模块错误码4
    public static CodeMsg STATE_ORDER_NULL = new CodeMsg(4101, "没有该状态订单");
    public static CodeMsg ORDER_NULL = new CodeMsg(4101, "目前还没有任何订单");

    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //可以返回带参数的校验码
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
