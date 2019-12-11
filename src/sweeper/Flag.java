package sweeper;

class Flag
{
    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start()
    {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;

    }

    Box get (Coord coord)
    {
        return  flagMap.get(coord);
    }

    void setOpennedToBox(Coord coord)
    {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;

    }

    private void setFlagedToBox(Coord coord)
    {
        flagMap.set(coord, Box.FLAGED);
    }
    private void setClosedToBox(Coord coord)
    {
        flagMap.set(coord, Box.CLOSED);
    }

    void toggleFlagedToBox(Coord coord)
    {
        switch ( flagMap.get(coord))
        {
            case FLAGED:
                setClosedToBox(coord);
                break;
            case CLOSED:
                setFlagedToBox(coord);
                break;

        }

    }

    int getCountOfClosedBoxes()
    {
        return countOfClosedBoxes;
    }

    void setBombedToBox(Coord coord)
    {
        flagMap.set(coord, Box.BOMBED);
    }

    void setOpennedToClosedBombBox(Coord coord)
    {
        if (flagMap.get(coord) == Box.CLOSED)
            flagMap.set(coord, Box.OPENED);
    }

    void setNoBombToFlagedSafeBox(Coord coord)
    {
        if (flagMap.get(coord) == Box.FLAGED)
            flagMap.set(coord, Box.NOBOMB);

    }


    int getCountToFlagedBoxesAround(Coord coord) {
        int count = 0;
        for (Coord around : Ranges.getCoordsAround(coord))
            if (flagMap.get(around) == Box.FLAGED)
                count++;
        return count;
    }



}
