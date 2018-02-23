package br.com.dxc.core.qrcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.detector.Detector;

public class QRCodeUtil {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;

	/**
	 * Gera um QRCode para um OutputStream
	 * 
	 * @param conteudo
	 * @return
	 * @throws WriterException
	 * @throws IOException
	 */
	public static OutputStream gerarStream(String conteudo)
			throws WriterException, IOException {
		return gerarStream(conteudo, WIDTH, HEIGHT);
	}

	/**
	 * Gera um QRCode para um OutputStream
	 * 
	 * @param conteudo
	 * @param width
	 * @param height
	 * @return
	 * @throws WriterException
	 * @throws IOException
	 */
	public static OutputStream gerarStream(String conteudo, int width,
			int height) throws WriterException, IOException {
		BitMatrix bm = gerarBitMatrix(conteudo, width, height);
		OutputStream outputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bm, "jpg", outputStream);
		return outputStream;
	}

	/**
	 * Gera um QRCode para um arquivo fisico
	 * 
	 * @param conteudo
	 * @param file
	 * @return
	 * @throws WriterException
	 * @throws IOException
	 */
	public static File gerarFile(String conteudo, File file)
			throws WriterException, IOException {
		return gerarFile(conteudo, WIDTH, HEIGHT, file);
	}

	/**
	 * Gera um QRCode para um arquivo fisico
	 * 
	 * @param conteudo
	 * @param width
	 * @param height
	 * @param file
	 * @return
	 * @throws WriterException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static File gerarFile(String conteudo, int width, int height,
			File file) throws WriterException, IOException {
		BitMatrix bm = gerarBitMatrix(conteudo, width, height);
		MatrixToImageWriter.writeToFile(bm, "jpg", file);
		return file;
	}

	/**
	 * Gera o BitMatrix do QRCode
	 * 
	 * @param conteudo
	 * @param width
	 * @param height
	 * @return
	 * @throws WriterException
	 */
	private static BitMatrix gerarBitMatrix(String conteudo, int width,
			int height) throws WriterException {
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bm = writer.encode(conteudo, BarcodeFormat.QR_CODE, width,
				height);
		return bm;
	}

	/**
	 * Encontra o padrao QRCode e efetua a leitura retornando o conteudo de
	 * texto
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 * @throws FormatException
	 * @throws ChecksumException
	 */
	public static String localizar(File file) throws IOException,
			NotFoundException, FormatException, ChecksumException {
		QRCodeReader reader = new QRCodeReader();

		BufferedImage originImage = ImageReader.readImage(file.toURI());

		LuminanceSource originSource = new BufferedImageLuminanceSource(
				originImage);
		BinaryBitmap originBitmap = new BinaryBitmap(new HybridBinarizer(
				originSource));

		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

		Detector detector = new Detector(originBitmap.getBlackMatrix());
		DetectorResult detectorResult = detector.detect(hints);
		BitMatrix originMatrix = detectorResult.getBits();

		BufferedImage bf = MatrixToImageWriter.toBufferedImage(originMatrix);
		LuminanceSource source = new BufferedImageLuminanceSource(bf);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result = reader.decode(bitmap);
		return result.getText();
	}

}
