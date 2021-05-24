package net.cnki.common.exception;


/**
 * @author daisy
 * @create 2019-04-12 11:45
 */
public class CustomException extends RuntimeException {

    /**
     * 报错码
     */
    private Integer status;

    /**
     * 报错信息
     */
    private String promptMsg;

    public CustomException(String msg) {
        super(msg);
        this.promptMsg=msg;
    }

    public CustomException(Integer status, String promptMsg) {
        this.status = status;
        this.promptMsg = promptMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPromptMsg() {
        return promptMsg;
    }

    public void setPromptMsg(String promptMsg) {
        this.promptMsg = promptMsg;
    }
}
