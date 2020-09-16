package patterns.adapter;

public class AdapterPattern {
    public static void main(String[] args) {

        VectorGraphicsInterface g1 = new VectorRasterAdapter();
        g1.drawLine();
        g1.drawSquare();

        VectorGraphicsInterface g2 = new VectorRasterAdapter2();
        g2.drawLine();
        g2.drawSquare();

    }
}

interface VectorGraphicsInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Line");
    }

    void drawRasterSquare() {
        System.out.println("Square");
    }
}

class VectorRasterAdapter extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorRasterAdapter2 implements VectorGraphicsInterface {

    RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
