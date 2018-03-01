package br.com.dxc.core.keystore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;

import br.com.dxc.exception.ApplicationBusinessExceptionCode;
import br.com.dxc.exception.BusinessValidatorException;

public class ColmeiaKeyStore {

	@Value("${keystore.caminho}")
	public String CAMINHO_KEY_STORE;
	@Value("${colmeia.jks}")
	private String FILE_NAME;
	@Value("${keystore.senha}")
	private String KEY_STORE_PASSWORD;
	@Value("${keystore.chave}")
	private String KEY;

	private static ColmeiaKeyStore instance;

	private ColmeiaKeyStore() {
	}

	/**
	 * Obtem a instancia estatica da classe
	 * 
	 * @return
	 */
	public static ColmeiaKeyStore getInstance() {
		if (instance == null) {
			instance = new ColmeiaKeyStore();
		}
		return instance;
	}

	/**
	 * Gera uma nova keystore
	 * 
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private KeyStore gerarKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
			IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		char[] password = decrypt(obterSenhaKeyStore(), KEY_STORE_PASSWORD).toCharArray();
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		ks.load(null, password);
		return ks;
	}

	/**
	 * Obtem a senha da propriedade e remove a base64
	 * 
	 * @return
	 */
	private String obterSenhaKeyStore() {
		return new String(Base64.decodeBase64(KEY.getBytes()));
	}

	/**
	 * Carrega a KeyStore do Colmeia. Caso nao existe gera uma nova
	 * 
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private KeyStore carregarKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
			IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		final File file = new File(CAMINHO_KEY_STORE + File.separator + FILE_NAME);

		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		if (file.exists()) {
			InputStream readStream = new FileInputStream(file);
			char[] password = decrypt(obterSenhaKeyStore(), KEY_STORE_PASSWORD).toCharArray();
			ks.load(readStream, password);
			readStream.close();
			return ks;
		}
		return gerarKeyStore();
	}

	/**
	 * Inclui um certificado dentro da KeyStore do Colmeia
	 * 
	 * @param certificado
	 * @param chave
	 * @param senha
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnrecoverableEntryException
	 */
	public void incluirCertificado(File certificado, String chave, String senha) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException, NoSuchProviderException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnrecoverableEntryException {
		incluirCertificado(new FileInputStream(certificado), chave, senha);
	}

	/**
	 * Inclui um certificado dentro da KeyStore do Colmeia
	 * 
	 * @param certificado
	 * @param chave
	 * @param senha
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnrecoverableEntryException
	 */
	public void incluirCertificado(InputStream certificado, String chave, String senha) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException, NoSuchProviderException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnrecoverableEntryException {
		File fileKS = new File(CAMINHO_KEY_STORE + File.separator + FILE_NAME);
		RandomAccessFile raf = fileKS.exists() ? new RandomAccessFile(fileKS, "rw") : null;

		java.nio.channels.FileLock lock = raf != null ? raf.getChannel().lock() : null;
		try {
			KeyStore ks = carregarKeyStore();

			KeyStore ksCertificado = KeyStore.getInstance("pkcs12", "SunJSSE");
			ksCertificado.load(certificado, senha.toCharArray());

			Enumeration<String> aliases = ksCertificado.aliases();
			while (aliases.hasMoreElements()) {
				String alias = aliases.nextElement();
				X509Certificate cert = (X509Certificate) ksCertificado.getCertificate(alias);

				KeyStore.PrivateKeyEntry pkEntry = null;
				PrivateKey privateKey = null;
				if (ksCertificado.isKeyEntry(alias)) {
					pkEntry = (KeyStore.PrivateKeyEntry) ksCertificado.getEntry(alias,
							new KeyStore.PasswordProtection(senha.toCharArray()));
					privateKey = pkEntry.getPrivateKey();
				}

				ks.setKeyEntry(chave, privateKey, chave.toCharArray(), new X509Certificate[] { cert });
			}

			FileOutputStream fos = null;
			try {
				fos = new java.io.FileOutputStream(fileKS);
				char[] password = decrypt(obterSenhaKeyStore(), KEY_STORE_PASSWORD).toCharArray();
				ks.store(fos, password);
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
		} finally {
			if (lock != null) {
				lock.release();
			}
			if (raf != null) {
				raf.close();
			}
		}
	}

	/**
	 * Obtem um certificado que esta na KeyStore do Colmeia
	 * 
	 * @param chave
	 * @return
	 * @throws ApplicationException
	 */
	// TODO era ApplicationException
	public CertificadoBean obterCertificado(String chave) throws BusinessValidatorException {
		try {
			KeyStore ks = carregarKeyStore();

			KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(chave,
					new KeyStore.PasswordProtection(chave.toCharArray()));

			if (pkEntry != null) {
				PrivateKey privateKey = pkEntry.getPrivateKey();

				return new CertificadoBean(privateKey, (X509Certificate) ks.getCertificate(chave));
			}
		} catch (Exception e) {
			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_CERTIFICADO_DIGITAL, e);
		}

		return null;
	}

	/**
	 * Decodifica a senha AES
	 * 
	 * @param key
	 * @param encrypted
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 */
	public static String decrypt(String key, String encrypted)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);

		byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted.getBytes()));

		return new String(original);
	}

}