public class Mandelbrot {
    public static void main(String[] args) {
        MandelbrotGUI gui = new MandelbrotGUI();
        Generator generator = new Generator();
        gui.enableInput();

        boolean hasImage = false;
        while (true) {
            int command = gui.getCommand();
            switch (command) {
                case MandelbrotGUI.QUIT:
                    System.exit(0);
                    break;
                case MandelbrotGUI.RESET:
                    gui.resetPlane();
                    gui.clearPlane();
                    hasImage = false;
                    break;
                case MandelbrotGUI.RENDER:
                    generator.render(gui);
                    hasImage = true;
                    break;
                case MandelbrotGUI.ZOOM:
                    if (hasImage) {
                        generator.render(gui);
                    } else {
                        gui.resetPlane();
                    }
                    break;
            }
        }
    }
}
