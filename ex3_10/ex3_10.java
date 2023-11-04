package ex3_10;

import java.util.ArrayList;
import java.util.List;


/**
 * 4theme
 * exercise3_10
 * @author Vitalii Reshetnyk
 */

class Point {
    double x, y, z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Line2D {
    Point start;
    Point end;

    public Line2D(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point intersectOZ() {

        double[] directionVector = {end.x - start.x, end.y - start.y, end.z - start.z};
        if (directionVector[0] == 0 && directionVector[1] == 0) {
            return null;
        }
        if (directionVector[2] == 0) {
            return null;
        }
        double t = -start.z / directionVector[2];
        return new Point(0, 0, start.z + t * directionVector[2]);
    }
    public Point intersectOX() {

        double[] directionVector = {end.x - start.x, end.y - start.y, end.z - start.z};
        if (directionVector[2] == 0 && directionVector[1] == 0) {
            return null;
        }
        if (directionVector[0] == 0) {
            return null;
        }
        double t = -start.x / directionVector[0];
        return new Point(start.x + t * directionVector[0], 0, 0);
    }
    public Point intersectOY() {

        double[] directionVector = {end.x - start.x, end.y - start.y, end.z - start.z};
        if (directionVector[0] == 0 && directionVector[2] == 0) {
            return null;
        }
        if (directionVector[1] == 0) {
            return null;
        }
        double t = -start.y / directionVector[1];
        return new Point(0, start.y + t * directionVector[1], 0);
    }
}

class Line3D {
    Point start;
    Point end;

    public Line3D(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point intersectLine(Line3D other) {

        double[] crossProduct1 = crossProduct(subtract(this.start, other.start), subtract(other.end, other.start));
        double[] crossProduct2 = crossProduct(subtract(this.end, other.start), subtract(other.end, other.start));

        double crossProduct1Length = length(crossProduct1);
        double crossProduct2Length = length(crossProduct2);

        if (crossProduct1Length == 0 || crossProduct2Length == 0) {
            // Lines are parallel or collinear, and there is no unique intersection point.
            return null;
        }

        double t = crossProduct2Length / (crossProduct1Length + crossProduct2Length);
        return add(this.start, scale(subtract(this.end, this.start), t));
    }

    public static double[] crossProduct(double[] a, double[] b) {
        return new double[]{
                a[1] * b[2] - a[2] * b[1],
                a[2] * b[0] - a[0] * b[2],
                a[0] * b[1] - a[1] * b[0]
        };
    }
    public static double length(double[] vector) {
        return Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2]);
    }

    public static Point add(Point a, double[] vector) {
        return new Point(a.x + vector[0], a.y + vector[1], a.z + vector[2]);
    }

    public static double[] scale(double[] vector, double scalar) {
        return new double[]{vector[0] * scalar, vector[1] * scalar, vector[2] * scalar};
    }
    public static double[] subtract(Point a, Point b) {
        return new double[]{a.x - b.x, a.y - b.y, a.z - b.z};
    }
}




public class ex3_10 {
    public static void main(String[] args) {
        // Create some 2D and 3D lines and find intersections.
        Line2D line2D = new Line2D(new Point(1, 2, 0), new Point(5, 7, 0));
        Point intersection2D = line2D.intersectOZ();
        System.out.println("2D Intersection: " + intersection2D);

        Line3D line3D1 = new Line3D(new Point(1, 2, 3), new Point(5, 7, 9));
        Line3D line3D2 = new Line3D(new Point(2, 3, 4), new Point(6, 8, 10));
        Point intersection3D = line3D1.intersectLine(line3D2);
        System.out.println("3D Intersection: " + intersection3D.x +" "+ intersection3D.y +" "+ intersection3D.z);

        // Create a list of Line3D objects to define groups of parallel lines.
        List<Line3D> parallelLinesGroup1 = new ArrayList<>();
        parallelLinesGroup1.add(new Line3D(new Point(0, 0, 0), new Point(0, 1, 0)));
        parallelLinesGroup1.add(new Line3D(new Point(1, 0, 0), new Point(1, 1, 0)));
    }
}
