package br.com.dxc.core.connection.servidor;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URLConnection;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import sun.misc.BASE64Encoder;

@Configuration
@EnableTransactionManagement
public class ProxyUtil {

	@Value("${proxy.host}")
	private String PROXY_HOST;

	@Value("${proxy.port}")
	private String PROXY_PORT;

	@Value("${proxy.user}")
	private String PROXY_USER;

	@Value("${proxy.pwd}")
	private String PROXY_PWD;

	/**
	 * Adiciona proxy ao sistema 
	 */
	public void adicionarProxy() {
		// caso exista host de proxy, autenticar
		if (PROXY_HOST != null && PROXY_HOST.trim().length() > 0) {
			Properties properties = System.getProperties();
			properties.put("https.proxyHost", PROXY_HOST);
			properties.put("https.proxyPort", PROXY_PORT);
			properties.put("http.proxyHost", PROXY_HOST);
			properties.put("http.proxyPort", PROXY_PORT);
			properties.put("http.proxyUser", PROXY_USER);
			properties.put("http.proxyPassword", PROXY_PWD);

			final String authUser = PROXY_USER;
			final String authPassword = PROXY_PWD;
			Authenticator.setDefault(new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(authUser, authPassword
							.toCharArray());
				}
			});
		}
	}
	
	/**
	 * Caso exista configuração de proxy, método abaixo utilizado para
	 * autenticar. Se conection != null, é setado user e pwd diretamente na
	 * conexao
	 * 
	 * @param conection
	 */
	public void verificaProxy(URLConnection conection) {
		// caso exista host de proxy, autenticar
		if (PROXY_HOST != null && PROXY_HOST.trim().length() > 0) {
			Properties properties = System.getProperties();
			properties.put("https.proxyHost", PROXY_HOST);
			properties.put("https.proxyPort", PROXY_PORT);
			properties.put("http.proxyHost", PROXY_HOST);
			properties.put("http.proxyPort", PROXY_PORT);

			if (conection != null) {
				String login = PROXY_USER + ":" + PROXY_PWD;
				String encodedLogin = new BASE64Encoder().encode(login
						.getBytes());

				conection.setRequestProperty("Proxy-Authorization", "Basic "
						+ encodedLogin);

				final String authUser = PROXY_USER;
				final String authPassword = PROXY_PWD;
				Authenticator.setDefault(new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(authUser,
								authPassword.toCharArray());
					}
				});
			} else {
				properties.put("http.proxyUser", PROXY_USER);
				properties.put("http.proxyPassword", PROXY_PWD);
			}
		}
	}
	
}
