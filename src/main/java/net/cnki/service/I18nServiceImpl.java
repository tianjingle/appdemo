package net.cnki.service;


import net.cnki.service.i18n.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * i18n服务，提供获取资源信息的接口
 *
 * @author daisy
 */
@Service
public class I18nServiceImpl implements I18nService {


    /**
     * 国际化
     */
    @Autowired
    private MessageSource messageSource;


    /**
     * 编码 zh或者en
     */
    @Value("${net.cnki.app-demo.language}")
    private String language;

    /**
     * 根据key获取对应的信息
     *
     * @param msgKey
     * @return
     */
    @Override
    public String getMessage(String msgKey) {
        return messageSource.getMessage(msgKey, null, new Locale(language));
    }
}
