package entity4;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this(0.0f, 0.0f, 0.0f);
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] xy = super.getXY();
        return new float[]{xy[0], xy[1], z};
    }

    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + z + ")";
    }
}


