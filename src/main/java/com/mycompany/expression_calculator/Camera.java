package com.mycompany.expression_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class Camera extends JFrame {

    private JLabel expression_label;
    private JLabel cameraScreen;
    private JButton btnCapture;
    private VideoCapture capture;
    private Mat image;
    private String text;

    public Camera(JLabel expression_label) {
        JLabel expressionLabel;

        this.expression_label = expressionLabel;
        // Load OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Initialize UI
        setLayout(null);

        cameraScreen = new JLabel();
        cameraScreen.setBounds(0, 0, 640, 480);
        add(cameraScreen);

        btnCapture = new JButton("Capture");
        btnCapture.setBounds(300, 480, 80, 40);
        add(btnCapture);

        btnCapture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                captureImage();
            }
        });

        setSize(new Dimension(640, 560));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startCamera() {
        capture = new VideoCapture(0);
        image = new Mat();

        // Continuously read and display frames from the camera
        while (true) {
            capture.read(image);
            ImageIcon icon = new ImageIcon(Mat2BufferedImage(image));
            cameraScreen.setIcon(icon);
        }
    }

    public void captureImage() {
        if (capture.read(image)) {
            MatOfByte buf = new MatOfByte();
            Imgcodecs.imencode(".jpg", image, buf);
            byte[] imageData = buf.toArray();
            // Optionally save the image to a file
            Imgcodecs.imwrite("images/photo.jpg", image);
        }
        Test tess = new Test();
        tess.image_processed();
        text = tess.getText();
        expression_label.setText(camera.getText());
        dispose();
    }

    public String getText(){
        return text;
    }

    // Helper method to convert Mat to BufferedImage
    public static BufferedImage Mat2BufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] bytes = new byte[bufferSize];
        mat.get(0, 0, bytes);
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);
        return image;
    }
}