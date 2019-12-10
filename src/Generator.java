import java.awt.*;

public class Generator {

    private int pixelSize = 1;

    /**
     * Ritar en bild i fönstret i användargränssnittet gui
     */
    public void render(MandelbrotGUI gui) {
        gui.disableInput();
        Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
                gui.getMinimumImag(), gui.getMaximumImag(),
                gui.getWidth(), gui.getHeight());

        switch (gui.getResolution()) {
            case MandelbrotGUI.RESOLUTION_VERY_HIGH:
                pixelSize = 1;
                break;
            case MandelbrotGUI.RESOLUTION_HIGH:
                pixelSize = 3;
                break;
            case MandelbrotGUI.RESOLUTION_MEDIUM:
                pixelSize = 5;
                break;
            case MandelbrotGUI.RESOLUTION_LOW:
                pixelSize = 7;
                break;
            case MandelbrotGUI.RESOLUTION_VERY_LOW:
                pixelSize = 9;
                break;
        }

        Color[][] picture = new Color[gui.getHeight() / pixelSize][gui.getWidth() / pixelSize];

        for (int i = 0; i < complex.length / pixelSize; i++) {
            for (int j = 0; j < complex[i].length / pixelSize; j++) {
                Complex c = complex[i * pixelSize + pixelSize / 2][j * pixelSize + pixelSize /2];
                if (c.getAbs2() > 1) {
                    picture[i][j] = Color.WHITE;
                } else {
                    if (c.getRe() > 0 && c.getIm() > 0) {
                        picture[i][j] = Color.RED;
                    } else if (c.getRe() < 0 && c.getIm() > 0) {
                        picture[i][j] = Color.BLUE;
                    } else if (c.getRe() < 0 && c.getIm() < 0) {
                        picture[i][j] = Color.GRAY;
                    } else if (c.getRe() > 0 && c.getIm() < 0) {
                        picture[i][j] = Color.CYAN;
                    }
                }
            }
        }

        gui.putData(picture, pixelSize, pixelSize);
        gui.enableInput();
    }

    /**
     * Skapar en matris där varje element är ett komplext tal som
     * har rätt koordinater (se beskrivning nedan)
     */
    private Complex[][] mesh(double minRe, double maxRe,
                             double minIm, double maxIm,
                             int width, int height) {
        Complex[][] mesh = new Complex[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double re = minRe + ((maxRe - minRe) / (width - 1)) * j;
                double im = maxIm - ((maxIm - minIm) / (height - 1)) * i;
                mesh[i][j] = new Complex(re, im);
            }

        }
        return mesh;
    }

}
