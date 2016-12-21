import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;	/*uses constant QR_CODE that means QR code 2d barcode format is used---Enumerates barcode formats known to this package. Please keep alphabetized.*/
import com.google.zxing.BinaryBitmap;	/*uses constructor---This class is the core bitmap class used by ZXing to represent 1 bit data. Reader objects accept a BinaryBitmap and attempt to decode it*/
import com.google.zxing.EncodeHintType;	/*uses constant ERROR_CORRECTION to represent what level of correction---These are a set of hints that you may pass to Writers to specify their behavior.*/
//import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
/*Uses constructor and decode(BinaryBitmap image, Map<DecodeHintType,?> hints)---MultiFormatReader is a convenience class and the main entry point into the library for most uses. By default it attempts to decode all barcode formats that the library supports. Optionally, you can provide a hints object to request different behavior, for example only decoding QR codes.*/
import com.google.zxing.MultiFormatWriter;
/*uses constructor and encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType,?> hints) --- This is a factory class which finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.
 */
import com.google.zxing.NotFoundException;
/*---Thrown when a barcode was not found in the image. It might have been partially detected but could not be confirmed.*/
import com.google.zxing.Result;
/*uses getText() ---Encapsulates the result of decoding a barcode within an image.*/
import com.google.zxing.WriterException;
/*---A base class which covers the range of exceptions which may occur when encoding a barcode using the Writer framework.*/
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
/*---This LuminanceSource implementation is meant for J2SE clients and our blackbox unit tests.*/
/*LuminanceSource---The purpose of this class hierarchy is to abstract different bitmap implementations across platforms into a standard interface for requesting greyscale luminance values. The interface only provides immutable methods; therefore crop and rotation create copies. This is to ensure that one Reader does not modify the original luminance source and leave it in an unknown state for other Readers in the chain.*/
import com.google.zxing.client.j2se.MatrixToImageWriter;
/*uses writeToFile(BitMatrix matrix, String format, File file)---Writes a BitMatrix to BufferedImage, file or stream. Provided here instead of core since it depends on Java SE libraries.*/
import com.google.zxing.common.BitMatrix;
/*Represents a 2D matrix of bits. In function arguments below, and throughout the common module, x is the column position, and y is the row position. The ordering is always x, y. The origin is at the top-left.

Internally the bits are represented in a 1-D array of 32-bit ints. However, each row begins with a new int. This is done intentionally so that we can copy out a row into a BitArray very efficiently.

The ordering of bits is row-major. Within each int, the least significant bits are used first, meaning they represent lower x values. This is compatible with BitArray's implementation.*/
import com.google.zxing.common.HybridBinarizer;
/*uses constructor---Performs Thresholding, i.e image segmentation from grayscale to binary image */
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/*Constants L(7%),M(15%),Q(25%),H(30%)---This enum encapsulates the four error correction levels defined by the QR code standard.*/

public class QRCode {

	public static void main(String[] args) throws WriterException, IOException,
			NotFoundException {
		String qrCodeData = "Dammmn Smeet, you are brilliant!";
		String filePath = "QRCode.jpg";
		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);	//keeps error correction level L,i.e 7% damage can be handled.

		createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);	//creates QR code, last two parameters are for height and width, respectively.
		System.out.println("QR Code image created successfully!");
	}

	public static void createQRCode(String qrCodeData, String filePath,
			String charset, Map<EncodeHintType, ErrorCorrectionLevel> hintMap, int qrCodeheight, int qrCodewidth)
			throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(
				new String(qrCodeData.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
				/*Returns BitMatrix using encode method*/
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
				.lastIndexOf('.') + 1), new File(filePath));
	}

}
