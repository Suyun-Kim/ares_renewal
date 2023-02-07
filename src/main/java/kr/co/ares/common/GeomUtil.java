package kr.co.ares.common;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class GeomUtil {

    public static Point createPoint (double lat, double lon) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPoint(new Coordinate(lat, lon));
    }
}
