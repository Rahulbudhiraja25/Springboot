package com.project.ems.service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeGenerator {

    public static void generateQRCodeImage(String text, int width, int height, String attendeeName, long attendeeId) throws WriterException, IOException {

        String folderName = "qrCodes";
        File folder = new File(folderName);


        if (!folder.exists()) {
            folder.mkdirs();
        }


        String sanitizedAttendeeName = attendeeName.replaceAll("[^a-zA-Z0-9]", "_"); // Replace invalid characters
        String fileName = "QR_" + sanitizedAttendeeName + "_" + attendeeId + ".png";


        String filePath = folderName + File.separator + fileName;


        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        // Save the QR code image
        File file = new File(filePath);
        ImageIO.write(bufferedImage, "PNG", file);
        System.out.println("QR Code saved at: " + file.getAbsolutePath());
    }
}
