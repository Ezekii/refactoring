package br.com.dxc.util;

import org.apache.commons.lang.StringUtils;

/**
 * Classe para Bean paar valores de um XSD <br>
 * O type � definido pelas constantes Constantes.XML_SIMPLETYPE_ em
 * {@link Constantes}
 * 
 * @author Helder Pereira Barb�s
 */
public class XsdBean {

	private String name;

	private String type;

	public XsdBean(String name, String type) {
		super();
		this.name = name;
		this.setType(type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String origemTipo) {

		if (StringUtils.isBlank(origemTipo)) {
			return;
		}

		String tipo = origemTipo.toLowerCase();

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_STRING)) {
			type = Constantes.XML_SIMPLETYPE_STRING;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_BOOLEAN)) {
			type = Constantes.XML_SIMPLETYPE_BOOLEAN;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_FLOAT)) {
			type = Constantes.XML_SIMPLETYPE_FLOAT;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_DECIMAL)) {
			type = Constantes.XML_SIMPLETYPE_DECIMAL;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_DURATION)) {
			type = Constantes.XML_SIMPLETYPE_DURATION;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_DATETIME)) {
			type = Constantes.XML_SIMPLETYPE_DATETIME;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_TIME)) {
			type = Constantes.XML_SIMPLETYPE_TIME;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_DATE)) {
			type = Constantes.XML_SIMPLETYPE_DATE;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_GYEARMONTH)) {
			type = Constantes.XML_SIMPLETYPE_GYEARMONTH;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_GYEAR)) {
			type = Constantes.XML_SIMPLETYPE_GYEAR;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_GMONTHDAY)) {
			type = Constantes.XML_SIMPLETYPE_GMONTHDAY;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_GDAY)) {
			type = Constantes.XML_SIMPLETYPE_GDAY;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_GMONTH)) {
			type = Constantes.XML_SIMPLETYPE_GMONTH;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_HEXBINARY)) {
			type = Constantes.XML_SIMPLETYPE_HEXBINARY;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_BASE64BINARY)) {
			type = Constantes.XML_SIMPLETYPE_BASE64BINARY;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_ANYURI)) {
			type = Constantes.XML_SIMPLETYPE_ANYURI;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_QNAME)) {
			type = Constantes.XML_SIMPLETYPE_QNAME;
			return;
		}

		if (tipo.endsWith(Constantes.XML_SIMPLETYPE_NOTATION)) {
			type = Constantes.XML_SIMPLETYPE_NOTATION;
			return;
		}
	}
}