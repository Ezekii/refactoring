package br.com.dxc.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ObjectUtils;


public class MessagesUtils {

    private static final String BUNDLE_NAME = "messages";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private static void validarKey(String key){
        if (key == null || "".equals(key.trim())) {
            throw new IllegalArgumentException("parâmetro obrigatório");
        }
    }

    private static String  validarMensagem(String key){
        String msg = RESOURCE_BUNDLE.getString(key);
        // Se for null ou vazio, mostra a propria chave
        if (StringUtils.isBlank(msg)) {
            msg = key;
        }

        return msg;
    }

    public static String getMessage(String key) {
        validarKey(key);
        try {
            return validarMensagem(key);
        } catch (Exception e) {
            // Se não houver messagem correspondente em algum message bundle do servidor
            // Neste caso lança a string do exception code mesmo.
            return key;
        }
    }

    public static String getMessage(String key, Object... params) {
        validarKey(key);
        try {
            return !ObjectUtils.isEmpty(params) ? MessageFormat.format(validarMensagem(key), params) : getMessage(key);
        } catch (Exception e) {
            // Se não houver messagem correspondente em algum message bundle lança a string do exception code mesmo.
            return key;
        }
    }

}
