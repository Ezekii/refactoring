//TODO Refatorar
//package br.com.cresol.colmeia.core.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.StringReader;
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamSource;
//import javax.xml.validation.Schema;
//import javax.xml.validation.SchemaFactory;
//import javax.xml.validation.Validator;
//
//import org.apache.commons.lang.StringUtils;
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.Namespace;
//import org.jdom.input.SAXBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.xml.sax.InputSource;
//
//import br.com.cresol.colmeia.core.conf.AppConfig;
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.core.exception.ColmeiaException;
//
//public class XMLUtil {
//
//	private static Logger log = LoggerFactory.getLogger(XMLUtil.class);
//
//	/**
//	 * Pesquisar os campos existentes no XSD.
//	 * 
//	 * @param nomeArquivo
//	 * @return lista de campos XSD
//	 * @throws ColmeiaException
//	 * @throws ApplicationException
//	 * @throws Exception
//	 */
//	public Collection<XsdBean> pesquisarCamposXSD(StringReader conteudo)
//			throws ColmeiaException, ApplicationException, Exception {
//
//		SAXBuilder builder = new SAXBuilder();
//
//		Document doc = new Document();
//
//		doc = builder.build(conteudo);
//
//		Element element = doc.getRootElement();
//
//		this.recursiveRead(element);
//		return listaCamposXSD;
//	}
//
//	private List<XsdBean> listaCamposXSD = new ArrayList<XsdBean>();
//
//	private String pai = "";
//
//	/**
//	 * M�todo respons�vel em converter um objeto em XML.
//	 * 
//	 * @param objeto
//	 * @return
//	 * @throws JAXBException
//	 */
//	public String parssarObjeto4XML(Object objeto) throws JAXBException {
//
//		JAXBContext jc = JAXBContext.newInstance(objeto.getClass());
//
//		Marshaller marshaller = jc.createMarshaller();
//		StringWriter sw = new StringWriter();
//		marshaller.marshal(objeto, sw);
//
//		return sw.toString();
//	}
//
//	/**
//	 * M�todo respons�vel em trasnformar um xml em uma classe com os seus
//	 * respectivos valores.
//	 * 
//	 * @param xml
//	 * @param classe
//	 * @return
//	 * @throws ApplicationException
//	 */
//	@SuppressWarnings("rawtypes")
//	public Object passarXML4Object(String xml, Class classe)
//			throws ApplicationException {
//
//		try {
//			JAXBContext context = JAXBContext.newInstance(classe);
//			Unmarshaller unmarshaller = context.createUnmarshaller();
//
//			return unmarshaller.unmarshal(new StreamSource(new StringReader(xml
//					.toString())));
//
//		} catch (Exception e) {
//			log.error("ERRO_COLMEIA_INESPERADO:", e);
//			throw new ApplicationException(e);
//		}
//	}
//
//	/**
//	 * Gera uma String contendo o conteudo de um xml utilizando JAXB.
//	 * 
//	 * @param obj
//	 * @param classeXml
//	 * @return String
//	 * @throws ApplicationException
//	 */
//	public String gerarStringXml(Object obj, Class... classeXml)
//			throws ApplicationException {
//		return this.gerarStringXml(obj, TipoCodificacao.UTF, classeXml);
//	}
//
//	/**
//	 * Gera uma String contendo o conteudo de um xml utilizando JAXB.
//	 * 
//	 * @param obj
//	 * @param codificacao
//	 * @param classesXml
//	 * @return String
//	 * @throws ApplicationException
//	 */
//	public String gerarStringXml(Object obj, TipoCodificacao codificacao,
//			Class... classesXml) throws ApplicationException {
//		try {
//			Class[] representacoes = null;
//			if (classesXml.length > 0) {
//				representacoes = classesXml;
//			} else {
//				representacoes = new Class[] { obj.getClass() };
//			}
//
//			JAXBContext jaxbContext = JAXBContext.newInstance(representacoes);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//			jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING,
//					codificacao.getCodificacao());
//
//			StringWriter stringWriter = new StringWriter();
//			jaxbMarshaller.marshal(obj, stringWriter);
//
//			String stringXml = stringWriter.getBuffer().toString();
//
//			return stringXml;
//		} catch (Exception e) {
//			throw new ApplicationException(e);
//		}
//	}
//
//	/**
//	 * Valida o conteudo do arquivo xml com o schema.
//	 * 
//	 * @param xsdFile
//	 * @param xml
//	 * @param validarSchemaComXml
//	 * @throws ApplicationException
//	 */
//	public void validarXmlComSchema(String xsdFile, String xml,
//			boolean validarSchemaComXml) throws ApplicationException {
//		try {
//			String pastaArquivosSchemas = AppConfig
//					.getConfiguracao("pasta.arquivos.schema");
//
//			SchemaFactory schemaFactory = SchemaFactory
//					.newInstance("http://www.w3.org/2001/XMLSchema");
//			Schema schema = schemaFactory.newSchema(new File(
//					pastaArquivosSchemas + File.separator + xsdFile + ".xsd"));
//
//			Validator validator = schema.newValidator();
//
//			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
//					.newInstance();
//			builderFactory.setNamespaceAware(true);
//			DocumentBuilder parser = builderFactory.newDocumentBuilder();
//
//			org.w3c.dom.Document document = null;
//			if (validarSchemaComXml) {
//				document = parser.parse(new File(xml));
//			} else {
//				document = parser
//						.parse(new InputSource(
//								new ByteArrayInputStream(xml
//										.getBytes(TipoCodificacao.UTF
//												.getCodificacao()))));
//			}
//
//			validator.validate(new DOMSource(document));
//		} catch (Exception e) {
//			throw new ApplicationException(e);
//		}
//	}
//
//	/**
//	 * Fun��o recursiva que adiciona os elementos de um XSD.
//	 * 
//	 * @param element
//	 */
//	private void recursiveRead(Element element) {
//
//		Iterator<Element> it = element.getChildren().iterator();
//
//		while (it.hasNext()) {
//			Element rootElement2 = it.next();
//			if (rootElement2.getName().equals("element")
//					&& !rootElement2.getChildren().isEmpty()) {
//
//				if (!StringUtils.isBlank(pai))
//					pai = pai + ".";
//
//				pai = pai + rootElement2.getAttributeValue("name");
//				listaCamposXSD.add(new XsdBean(rootElement2
//						.getAttributeValue("name"), rootElement2
//						.getAttributeValue("type")));
//
//				recursiveRead(rootElement2
//						.getChild(
//								"complexType",
//								Namespace
//										.getNamespace("http://www.w3.org/2001/XMLSchema"))
//						.getChild(
//								"sequence",
//								Namespace
//										.getNamespace("http://www.w3.org/2001/XMLSchema")));
//			} else {
//				listaCamposXSD.add(new XsdBean(rootElement2
//						.getAttributeValue("name"), rootElement2
//						.getAttributeValue("type")));
//			}
//		}
//
//		String[] campos = pai.split("\\.");
//		pai = "";
//
//		for (int i = 0; i < (campos.length - 1); i++) {
//			if (i == campos.length - 2) {
//				pai = pai + campos[i];
//			} else {
//				pai = pai + campos[i] + ".";
//			}
//		}
//	}
//}