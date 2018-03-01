package br.com.dxc.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.cert.X509Certificate;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.security.Init;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.ElementProxy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.dxc.core.keystore.CertificadoBean;

public class AssinaturaXMLUtil {

	private static final String CODIFICACAO = "UTF-8";

	private AssinaturaXMLUtil() {
	}

	public static AssinaturaXMLUtil newInstance() {
		return new AssinaturaXMLUtil();
	}

	/**
	 * Realiza a assinatura do XML dentro do proprio elemento
	 * 
	 * @param xmlSource
	 * @param nomeElemento
	 * @param certificadoBean
	 * @return
	 * @throws Exception
	 */
	public String assinarElemento(String xmlSource, String nomeElemento, CertificadoBean certificadoBean)
			throws Exception {
		Document document = documentFactory(xmlSource);
		Element elemento = (Element) document.getElementsByTagName(nomeElemento).item(0);
		elemento.setIdAttribute("id", true);
		return assinarXML(document, elemento, nomeElemento, certificadoBean);
	}

	/**
	 * Realiza a assinatura do XML no elemento pai
	 * 
	 * @param xmlSource
	 * @param nomeElemento
	 * @param certificadoBean
	 * @return
	 * @throws Exception
	 */
	public String assinarElementoPai(String xmlSource, String nomeElemento, CertificadoBean certificadoBean)
			throws Exception {
		Document document = documentFactory(xmlSource);
		Element elemento = (Element) document.getElementsByTagName(nomeElemento).item(0);
		elemento.setIdAttribute("id", true);
		return assinarXML(document, elemento.getParentNode(), nomeElemento, certificadoBean);
	}

	/**
	 * Realiza a assinatura do XML dentro do elemento especificado
	 * 
	 * @param document
	 * @param assinar
	 * @param nomeElemento
	 * @param certificadoBean
	 * @return
	 * @throws XMLSecurityException
	 * @throws TransformerException
	 */
	private String assinarXML(Document document, Node assinar, String nomeElemento, CertificadoBean certificadoBean)
			throws XMLSecurityException, TransformerException {
		Element elemento = (Element) document.getElementsByTagName(nomeElemento).item(0);
		elemento.setIdAttribute("id", true);
		String id = elemento.getAttribute("id");

		Init.init();

		ElementProxy.setDefaultPrefix(Constants.SignatureSpecNS, "");
		XMLSignature sig = new XMLSignature(document, "", XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256);

		assinar.appendChild(sig.getElement());

		Transforms transforms = new Transforms(document);

		transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
		transforms.addTransform(Transforms.TRANSFORM_C14N_OMIT_COMMENTS);
		sig.addDocument("#" + id, transforms, "http://www.w3.org/2001/04/xmlenc#sha256");

		trimWhitespace(document);

		X509Certificate cert = certificadoBean.getCertificate();
		sig.addKeyInfo(cert);
		sig.sign(certificadoBean.getPrivateKey());

		return outputXML(document);
	}

	/**
	 * Remove os espacos em branco do XML
	 * 
	 * @param node
	 */
	public static void trimWhitespace(Node node) {
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); ++i) {
			Node child = children.item(i);
			if (child.getNodeType() == Node.TEXT_NODE) {
				child.setTextContent(child.getTextContent().trim());
			}
			trimWhitespace(child);
		}
	}

	/**
	 * Monta o objeto documento baseado no conteudo do xml
	 * 
	 * @param xml
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	private Document documentFactory(String xml) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes(CODIFICACAO)));
		return document;
	}

	/**
	 * Transforma um documento XML em uma string
	 * 
	 * @param doc
	 * @return
	 * @throws TransformerException
	 */
	private String outputXML(Node doc) throws TransformerException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.setOutputProperty(OutputKeys.ENCODING, CODIFICACAO);
		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		trans.transform(new DOMSource(doc), new StreamResult(os));
		String xml = os.toString();
		if ((xml != null) && (!"".equals(xml))) {
			xml = xml.replaceAll("\\r\\n", "");
			xml = xml.replaceAll(" standalone=\"no\"", "");
		}

		return xml;
	}

}
