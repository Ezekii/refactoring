package br.com.dxc.logging;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.dxc.exception.BusinessValidatorException;


/**
 * @author robson
 *
 */
public class LogBuilder {

	private String message;
	private Map<String, Object> payload = new HashMap<String, Object>();

	private LogBuilder(String message) {
		this.message = message;
	}

	/**
	 * Obtem a instancia do builder
	 * 
	 * @return
	 */
	public static LogBuilder create() {
		return new LogBuilder(null);
	}

	/**
	 * Obtem a instancia do builder
	 * 
	 * @param mensagem
	 * @return
	 */
	public static LogBuilder create(String mensagem) {
		return new LogBuilder(mensagem);
	}

	/**
	 * Adiciona a mensagem principal do log
	 * 
	 * @param message
	 * @return
	 */
	public LogBuilder message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Adiciona itens ao payload do log
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public LogBuilder payload(String key, Object value) {
		payload.put(key, value);
		return this;
	}

	/**
	 * @return
	 * @throws BusinessValidatorException
	 */
	public String build() throws BusinessValidatorException {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("mensagem", message);

			JSONObject payloadJsonObject = new JSONObject(payload);
			jsonObject.put("payload", payloadJsonObject);

			return jsonObject.toString();
		} catch (JSONException e) {
			throw new BusinessValidatorException(e);
		}
	}

}