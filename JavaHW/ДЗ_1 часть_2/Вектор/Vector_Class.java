public class Vector_Class {
    private double x, y, z;

    public Vector_Class(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getModule() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double getScalar(Vector_Class vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public double cos(Vector_Class vector) {
        return (x * vector.x + y * vector.y + z * vector.z)/(Math.abs(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2))*Math.abs(Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2)))));
    }

    public Vector_Class getVector(Vector_Class vector) {
        return new Vector_Class(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    public Vector_Class add(Vector_Class vector) {
        return new Vector_Class(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector_Class subtract(Vector_Class vector) {
        return new Vector_Class(x - vector.x, y - vector.y, z - vector.z);
    }

    @Override //Переопределение метода toString для вывода данных на консоль
    public String toString() {
        return "{x = " + x + "; y = " + y + "; z = " + z + "}";
    }
}
