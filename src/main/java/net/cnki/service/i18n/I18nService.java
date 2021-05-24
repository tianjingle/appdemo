package net.cnki.service.i18n;

public interface I18nService {

    /**
     * 根据key获取对应的信息
     *
     * @param msgKey
     * @return
     */
    String getMessage(String msgKey);
}
