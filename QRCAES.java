import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCAES {
	public static void initiateQR(String qrCodeData) throws WriterException, IOException, NotFoundException,Exception {
		System.out.println(qrCodeData);
		try{
			SecretKey key=AESEncryption.getSecretEncryptionKey();
			byte[] cipherText=AESEncryption.encryptText(qrCodeData,key);
			String filePath = "qrcode.jpg";
			String charset = "UTF-8";
		
			Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
			createQRCode(cipherText, filePath, charset, hintMap, 200, 200);
			
			System.out.println("QR Code created successfully, Thanks!");	
			String decryptedText = AESEncryption.decryptText(cipherText,key);
			System.out.println("Encrypted Text (Binary Form):"+cipherText);
       			System.out.println("Descrypted Text:"+decryptedText);
       		
		}catch(Exception e)
		{
			System.out.println("Exception Issued");
		}
	}

	public static void createQRCode(byte[] cipherText, String filePath, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hintMap, int qrCodeheight, int qrCodewidth) throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode( new String(cipherText, charset), BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	}
}
