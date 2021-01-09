package Model;

import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QRCodeController {

    private static final String QR_CODE_IMAGE_PATH = "C:\\Users\\Sharon\\Desktop\\QRCode.png";


    @GetMapping(value = "/genrateAndDownloadQRCode")
    public void download()
            throws Exception {
        String codeText = "sharon";
        QRCodeGenerator qrCodeGenerator=new QRCodeGenerator();
        qrCodeGenerator.generateQRCodeImage(codeText);

  /*  @GetMapping(value = "/genrateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody CodeText codeText) throws IOException, WriterException {

            return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText.getCodeTextString(), 480, 480));

    }*/
    }
}