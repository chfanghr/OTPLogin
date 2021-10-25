package site.urandom.otplogin.utils;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public final class QRCodeUtils {
    private static final String bw = "▄";
    private static final String bb = " ";
    private static final String wb = "▀";
    private static final String ww = "█";

    private static boolean isBlack(byte b) {
        return b != 0;
    }

    public static List<String> URI2ASCIIQRCode(URI uri) throws WriterException {
        QRCode code = Encoder.encode(uri.toString(), ErrorCorrectionLevel.L);
        ByteMatrix matrix = code.getMatrix();

        List<String> result = new ArrayList<>();

        for (int y = 0; y < matrix.getHeight(); y += 2) {
            StringBuilder builder = new StringBuilder();

            for (int x = 0; x < matrix.getWidth(); x++) {
                boolean nextBlack = false;
                if(y+1<matrix.getHeight())
                    nextBlack = isBlack(matrix.get(x,y+1));
                boolean currBlack = isBlack(matrix.get(x,y));
                if(currBlack&&nextBlack)
                    builder.append(bb);
                else if(currBlack)
                    builder.append(bw);
                else if(nextBlack)
                        builder.append(wb);
                else
                    builder.append(ww);
            }

            result.add(builder.toString());
        }
        return result;
    }
}
