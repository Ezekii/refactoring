package br.com.dxc.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author robson
 *
 */
public class ZipUtils {

	/**
	 * Compacta os arquivos recebidos por parametro em um zip no caminho
	 * indicado.
	 * 
	 * @param pathCompletoZip
	 * @param pathCompletoArquivos
	 */
	public static void compactarArquivos(String pathCompletoZip,
			String... pathCompletoArquivos) {
		try {
			byte[] buffer = new byte[1024];

			// Stream de saida
			FileOutputStream fos = new FileOutputStream(pathCompletoZip);

			// Zip de saida
			ZipOutputStream zos = new ZipOutputStream(fos);

			FileInputStream in = null;
			ZipEntry ze = null;

			for (String pathArquivo : pathCompletoArquivos) {
				String[] aux = pathArquivo.split("/");
				String nomeArquivo = aux[aux.length - 1];

				// Arquivo a ser zipdo
				ze = new ZipEntry(nomeArquivo);

				// Adciona arquivo no Zip de saida
				zos.putNextEntry(ze);

				// Ler o Arquivo que sera Zipado
				in = new FileInputStream(pathArquivo);

				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				// Fecha Arquivos
				in.close();
			}

			// Fecha Zip e entrada
			zos.closeEntry();
			zos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Método responsável em descompactar um arquivo zip com somente um arquivo
	 * dentro. Pode ser passado o nome específico para geração do arquivo a ser
	 * descompactado. Caso o mesmo não seja passado, sera gerado com o nome do
	 * arquivo real.
	 * 
	 * @param pathCompletoZip
	 * @param pathArquivoDescompactado
	 * @param nomeArquivoDescompactado
	 * @throws IOException
	 */
	public static void descompactarArquivoUnico(String pathCompletoZip,
			String pathArquivoDescompactado, String nomeArquivoDescompactado) throws IOException {

		ZipUtils.manipularArquivoZipDescompactando(pathCompletoZip,
				pathArquivoDescompactado, nomeArquivoDescompactado);
	}
	
	/**
	 * Método interno responsável em manipular o arquivo zip e descompactar o(s)
	 * mesmo(s).
	 * 
	 * @param pathCompletoZip
	 * @param pathArquivoDescompactado
	 * @param nomeArquivoDescompactado
	 * @throws IOException
	 */
	private static void manipularArquivoZipDescompactando(
			String pathCompletoZip,
			String pathArquivoDescompactado, String nomeArquivoDescompactado) throws IOException {

		byte[] buffer = new byte[1024];

		// Cria o input do arquivo ZIP
		ZipInputStream zinstream = new ZipInputStream(new FileInputStream(
				pathCompletoZip));

		// Pega a proxima entrada do arquivo
		ZipEntry zentry = zinstream.getNextEntry();

		// Enquanto existir entradas no ZIP
		while (zentry != null) {

			// se nao passar nome, descompacta com o nome real do arquivo.
			if (nomeArquivoDescompactado == null) {
				nomeArquivoDescompactado = zentry.getName();
			}

			// Cria o output do arquivo.
			FileOutputStream outstream = new FileOutputStream(
					pathArquivoDescompactado.concat(nomeArquivoDescompactado));
			int n;

			// Escreve no arquivo
			while ((n = zinstream.read(buffer)) > -1) {
				outstream.write(buffer, 0, n);
			}
			// Fecha arquivo
			outstream.close();

			// Fecha entrada e tenta pegar a proxima
			zinstream.closeEntry();
			zentry = zinstream.getNextEntry();
		}

		// Fecha o zip como um todo
		zinstream.close();

	}

	/**
	 * Descompacta os arquivos do zip na pasta indicada.
	 * 
	 * @param pathCompletoZip
	 * @param pastaDescompactar
	 * @throws IOException
	 */
	public static void descompactarArquivo(String pathCompletoZip,
			String pastaDescompactar) throws IOException {

		ZipUtils.manipularArquivoZipDescompactando(pathCompletoZip,
				pastaDescompactar, null);
	}
}