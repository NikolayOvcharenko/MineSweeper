package sweeper;

import java.util.ArrayList;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoord;

    public static void setSize (Coord _size)
    {
        size = _size;
        allCoord = new ArrayList<Coord>();
        for (int y=0; y<=size.y; y++)
            for (int x=0; x<=size.x; x++)
                allCoord.add(new Coord(x,y));


    }

    public static Coord getSize() {
        return size;
    }

    public static ArrayList<Coord> getAllCoord()
    {
        return allCoord;
    }
}
